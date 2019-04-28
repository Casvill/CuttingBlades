// Para buscar rápido esta clase contiene:
//cambiar
//seguir
//..................................................................................
//para tener en cuenta a la hora de hacer la lógica de entradas/salidas (movimientos):
//update productos set stock = ((existenciasini + entradas)-salidas)

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.DropXlsx;
import vista.Vista;

public class Controlador implements ActionListener {
    
    private Vista vista;
    private DefaultTableModel modelo;
    private Conexion conexion;
    
 
    
    //Constructor:-------------------------------------------------------------------------------
    public Controlador(Vista vista) 
    {   
        this.vista = vista;
        this.vista.setVisible(true);
        conexion = new Conexion();
        
        
        this.vista.jbAñadir.addActionListener(this);
        this.vista.jtfBusquedaPorCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaPorCodigoKeyReleased(evt);
            }
        });
        
        
        //Modelo de tabla--------
        modelo = (DefaultTableModel) vista.jtProductos.getModel();
       //Fin modelo de tabla------
       
       extraerDeDB();
       
       //Importar tabla de excel:-----------
       DropXlsx drop = new DropXlsx();
       drop.setJtable(vista.jtImportar);
       //Fin importar tabla de excel--------
    }
    //Fin Constructor----------------------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método que extrae toda la info de la tabla productos de la base de datos y la muestra en el jTable de productos:
    public void extraerDeDB()
    {
        conexion.abrirConexion();
        ResultSet rs = conexion.ejecutarQueryResult("select * from productos");
        try
        {
            while(rs.next())
            {
                actualizarTablaProductos(rs.getString("codigoproducto"), rs.getString("descripcion"), rs.getString("grado"), rs.getString("existenciasini")
                                        , rs.getString("entradas"), rs.getString("salidas"), rs.getString("costounitario"), rs.getString("stock"));
            }
        }catch(SQLException | NullPointerException error)
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos:\n"+error.getMessage());
        }
        conexion.cerrarConexion();
    }
    //Fin extraerDeDB()--------------------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Manejador de eventos al presionar un botón en el campo de texto para la búsqueda por código de producto:
    //Lo que hace esto es que al soltar la tecla presionada, se busca el o los productos cuyo código empiece por
    //el texto escrito en el campo de búsqueda.
    private void jtBusquedaPorCodigoKeyReleased(java.awt.event.KeyEvent evt) {        
        
            String busqueda="";
            busqueda=vista.jtfBusquedaPorCodigo.getText().trim();
            conexion.abrirConexion();
            ResultSet rs = conexion.ejecutarQueryResult("select * from productos where codigoproducto like '"+busqueda+"%'");
        try {
            borrarTablaProductos();
            while(rs.next())
            {
                actualizarTablaProductos(rs.getString("codigoproducto"), rs.getString("descripcion"), rs.getString("grado"), rs.getString("existenciasini")
                        , rs.getString("entradas"), rs.getString("salidas"), rs.getString("costounitario"), rs.getString("stock"));
            }
            conexion.cerrarConexion();
        } catch (SQLException error) 
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos.");
        }
    }     
    //Fin jtBusquedaPorCodigoKeyTyped()---------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Manejador de eventos al presionar un botón:-------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Botón añadir (pestaña2): Añade el producto en caso de que cumpla los requisitos
        if(e.getSource() == vista.jbAñadir)
        {
            if(vista.jtfCodigoProducto.getText().equals("") || 
               vista.jtfDescripcion.getText().equals("") ||
               vista.jtfGrado.getText().equals("") ||
               vista.jtfExistenciasIniciales.getText().equals("") ||
               vista.jtfCostoUnitario.getText().equals("")   )
            {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
            }
            else
            { 
                String codProducto=vista.jtfCodigoProducto.getText().trim();
                String descripcion=vista.jtfDescripcion.getText().trim();
                String grado = vista.jtfGrado.getText().trim();
                String exisIni = vista.jtfExistenciasIniciales.getText().trim();
                String costoUnitario = vista.jtfCostoUnitario.getText().trim();
                String stock = vista.jtfExistenciasIniciales.getText().trim();//cambiar  (depronto, no sé, a ver que pasa con el tiempo :v)
                
                try
                {
                    Integer.parseInt(exisIni);
                    Float.parseFloat(costoUnitario);
                    
                    if(añadirProducto(codProducto,descripcion,grado,exisIni,"0","0",costoUnitario,stock) == true)
                    {
                        limpiarFormularioPestaña2();
                        actualizarTablaProductos(codProducto,descripcion,grado,exisIni,"0","0",costoUnitario,stock);
                        JOptionPane.showMessageDialog(null, "Producto añadido exitosamente.");
                    }
                }catch(NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(null, "Error. El campo de existencias iniciales y costo unitario deben ser valores numéricos.");
                } 
            } 
        }//Fin botón añadir (pestaña2)
    }
    //Fin actionPerformed()-----------------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método para añadir un producto a la base de datos:------------------------------------------------------
    //retorna true si lo añade / false si ocurre algún error
    public boolean añadirProducto(String codProducto,String descripcion,String grado,String exisIni,
                               String entradas,String salidas,String costoUnitario,String stock)
    {
            String query="insert into productos values ('"+codProducto+"','"+descripcion+"','"
                         +grado+"','"+exisIni+"','"+entradas+"','"+salidas+"','"+costoUnitario+"','"+stock+"')";

            conexion.abrirConexion();
            
            if(conexion.ejecutarQuery(query) != true)
            {
                conexion.cerrarConexion();
                return false;
            }
              
            
            conexion.cerrarConexion();
            
            return true;
    }
    //Fin añadirProducto()------------------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Este método borrar todas las filas de la tabla de productos de la pestaña general-----------------------
    public void borrarTablaProductos()
    {
        for (int i = modelo.getRowCount() -1; i >= 0; i--)
        {
            modelo.removeRow(i);
        }
    }
    //Fin borrarTablaProductos()------------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método para actualizar la tabla de productos al agregar un producto:------------------------------------
    public void actualizarTablaProductos(String codProducto, String descripcion, String grado, String exisIni, 
                                         String entradas, String salidas, String costoUnitario, String stock)
    {
        Object []object = new Object[8];
        object[0] = codProducto;
        object[1] = descripcion;
        object[2] = grado;
        object[3] = exisIni; 
        object[4] = entradas;
        object[5] = salidas;
        object[6] = "$ "+costoUnitario;
        object[7] = stock;
                
        modelo.addRow(object);   
    }
    //Fin actualizarTablaProductos()----------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método para limpiar los campos de texto de la interfaz para añadir productos:-----------------------------
    public void limpiarFormularioPestaña2()
    {
        vista.jtfCodigoProducto.setText("");
        vista.jtfDescripcion.setText("");
        vista.jtfGrado.setText("");        
        vista.jtfExistenciasIniciales.setText("");        
        vista.jtfCostoUnitario.setText("");
    }
    //Fin limpiarFormularioPestaña2()---------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método principal------------------------------------------------------------------------------------------
    public static void main(String args[]) {
        Controlador control = new Controlador(new Vista());
    }
    //Fin método principal--------------------------------------------------------------------------------------
}
