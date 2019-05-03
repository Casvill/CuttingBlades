//PARA BUSCAR RÁPIDO, ESTA CLASE ESTÁ DIVIDIDA EN AGRUPACIONES QUE SE PUEDEN BUSCAR ASÍ:

//EXTRACCIÓN DB: Métodos que extraen la info completa de la db y la pone en sus respectivas tablas.

//BORRAR TABLAS: Métodos para eliminar todas las filas de tablas específicas (en la GUI).
//               En estos casos para el for se toma el número de filas que hay en la tabla y se va quitando 
//               desde el último hácia el primero porque cada que se quita una fila, el número de filas
//               disminuye, por lo tanto pretender remover las filas desde la primer hácia la última
//               no sería posible.

//BUSQUEDAS: Manejadores de eventos de jTextField's que hacen que al soltar una tecla en un campo de texto se buscan 
//           coincidencias con registros de la db y los muestra en sus respectivas tablas.

//AÑADIR REGISTROS: Métodos para añadir registros a la DB. Retornan true si lo añade / false si ocurre algún error.

//LIMPIADORES: Métodos para limpiar campos de textos de formularios.
//----------------------------------------------------------------------------------------------------------

//ESTAS SON NOTAS QUE HE PUESTO Y DEBERÍA MIRAR:
//Consultar
//temporal
//cambiar
//----------------------------------------------------------------------------------------------------------
//OTROS:
//*Para tener en cuenta a la hora de hacer la lógica de entradas/salidas (movimientos):
//update productos set stock = ((existenciasini + entradas)-salidas)
//Cada que haya una entrada, el costo unitario del producto cambia así:
//costoUnitario = ( (costoUnitario * stock) + (costoUnitarioEntrante * cantEntrante) ) / (stock + cantEntrante)

//*Hacer algo para que al ingresar un registro con una llave primaria repetida, no se muestre el mensaje de adv
//que se está mostrando sino otro.

//*Editar la pestaña registros, puede ser añadir dos botones para que la tabla cambie a la estructura entradas/salidas
//dependiendo de lo que se quiera consultar.

//CÓDIGO:-----------------------------------------------------------------------------------------------------

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
    private DefaultTableModel modeloProductos,modeloEntradas;
    private Conexion conexion;

    
    //Constructor:-------------------------------------------------------------------------------
    public Controlador(Vista vista) 
    {   
        this.vista = vista;  
        this.vista.setVisible(true);
        conexion = new Conexion();
        
        //ActionListeners:-------------------------------------------
        this.vista.jbAñadirProducto.addActionListener(this);
        this.vista.jbLimpiarEntrada.addActionListener(this);
        this.vista.jbAceptarEntrada.addActionListener(this);
        //Fin ActionListener.----------------------------------------
        
        
        //Consultar:------------------------------------------------------------
        //Esto se es lo que se debe añadir para añadir una escucha a un campo de texto
        //al soltar una tecla. En este caso se le añadió al campo de búsqueda de productos por código.
        //En este video explican un poco los eventos del teclado: https://www.youtube.com/watch?v=_BWYtHNmKCc
        this.vista.jtfBusquedaPorCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaPorCodigoProductoKeyReleased(evt);
            }
        });
        this.vista.jtfBusquedaPorNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaPorNumFacturaEntradasKeyReleased(evt);
            }
        });
        //Fin Consultar.--------------------------------------------------------
        
        
        //Modelos de tablas:--------
        modeloProductos = (DefaultTableModel) vista.jtProductos.getModel();
        modeloEntradas = (DefaultTableModel) vista.jtRegistros.getModel();
       //Fin modelo de tabla------
       
       
       //Se llena la tabla de productos principal con los datos de la DB:
       extraerProductos();
       extraerEntradas(); //temporal  cambiar a otro lugar
       
       
       //Importar tabla de excel:-----------
       DropXlsx drop = new DropXlsx();
       drop.setJtable(vista.jtImportar);
       //Fin importar tabla de excel--------
    }
    //Fin Constructor----------------------------------------------------------------------------------------
    
    
    
    //EXTRACCIÓN DB:****************************************************************************************/
    
    public void extraerProductos()
    {
        conexion.abrirConexion();
        ResultSet rs = conexion.ejecutarQueryResult("select * from productos");
        try
        {
            while(rs.next())
            {
                añadirATablaProductos(rs.getString("codigoproducto"), rs.getString("descripcion"), rs.getString("grado"), rs.getString("existenciasini")
                                        , rs.getString("entradas"), rs.getString("salidas"), rs.getString("costounitario"), rs.getString("stock"));
            }
        }catch(SQLException | NullPointerException error)
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos:\n"+error.getMessage());
        }
        conexion.cerrarConexion();
    }
    //Fin extraerProductos()------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    public void extraerEntradas()
    {
        conexion.abrirConexion();
        ResultSet rs = conexion.ejecutarQueryResult("select * from entradas");
        try
        {
            while(rs.next())
            {
                añadirATablaEntradas(rs.getString("numfactura"), rs.getString("codigoproducto"), rs.getString("nombreproveedor"), rs.getString("costodolares")
                                        , rs.getString("tasadecambio"), rs.getString("costototalpesos"), rs.getString("cantentrante"));
            }
        }catch(SQLException | NullPointerException error)
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos:\n"+error.getMessage());
        }
        conexion.cerrarConexion();
    }
    //Fin extraerEntradas()--------------------------------------------------------------------------------------
    
    //FIN EXTRACCIÓN DB******************************************************************************************
    
    
    
    //BUSQUEDAS:***************************************************************************************************/
    
    private void jtBusquedaPorCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) 
    {             
        String busqueda="";
        busqueda=vista.jtfBusquedaPorCodigoProducto.getText().trim();
        
        //Esto es para evitar sql injection
        if(busqueda.contains("'")) 
        {
            JOptionPane.showMessageDialog(null, "El campo de texto no puede incluir el caracter comilla (') ");
            vista.jtfBusquedaPorCodigoProducto.setText("");
        }
        else 
        {
            conexion.abrirConexion();
            ResultSet rs = conexion.ejecutarQueryResult("select * from productos where codigoproducto like '"+busqueda+"%'");
            try 
            {
                borrarTablaProductos();
                while(rs.next())
                {
                    añadirATablaProductos(rs.getString("codigoproducto"), rs.getString("descripcion"), rs.getString("grado"), rs.getString("existenciasini")
                            , rs.getString("entradas"), rs.getString("salidas"), rs.getString("costounitario"), rs.getString("stock"));
                }
                conexion.cerrarConexion();

            } catch (SQLException error) 
            {
                JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos.");
                conexion.cerrarConexion();
            }
        }
        
    }     
    //Fin jtBusquedaPorCodigoKeyTyped()---------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    private void jtBusquedaPorNumFacturaEntradasKeyReleased(java.awt.event.KeyEvent evt) 
    {             
        String busqueda="";
        busqueda=vista.jtfBusquedaPorNumFactura.getText().trim();
            
        //Esto es para evitar sql injection:
        if(busqueda.contains("'")) 
        {
            JOptionPane.showMessageDialog(null, "El campo de texto no puede incluir el caracter comilla (') ");
            vista.jtfBusquedaPorNumFactura.setText("");
        }
        
        else
        {
            conexion.abrirConexion();
            ResultSet rs = conexion.ejecutarQueryResult("select * from entradas where numfactura like '"+busqueda+"%'");
            try 
            {
                borrarTablaEntradas();
                while(rs.next())
                {
                    añadirATablaEntradas(rs.getString("numfactura"), rs.getString("codigoproducto"), rs.getString("nombreproveedor"), rs.getString("costodolares")
                                            , rs.getString("tasadecambio"), rs.getString("costototalpesos"), rs.getString("cantentrante"));
                }
                conexion.cerrarConexion();

            } catch (SQLException error) 
            {
                JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos.");
                conexion.cerrarConexion();
            }
        }
    }     
    //Fin jtBusquedaPorNumFacturaKeyTyped()---------------------------------------------------------------------
    
    //FIN BUSQUEDAS*********************************************************************************************
    
    
    
    
    
    //BOTONES:**************************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Añade el producto en caso de que cumpla los requisitos
        if(e.getSource() == vista.jbAñadirProducto)
        {   
            //Se verifica que ningún campo esté vacío:
            if(vista.jtfCodigoProducto.getText().equals("") || 
               vista.jtfDescripcion.getText().equals("") ||
               vista.jtfGrado.getText().equals("") ||
               vista.jtfExistenciasIniciales.getText().equals("") ||
               vista.jtfCostoUnitario.getText().equals("")   )
            {
                JOptionPane.showMessageDialog(null, "No puede haber ningún campo vacío.", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
            //Si ningún campo está vacío, se guardan los valores introducidos:
            else
            { 
                String codProducto=vista.jtfCodigoProducto.getText().trim();
                String descripcion=vista.jtfDescripcion.getText().trim();
                String grado = vista.jtfGrado.getText().trim();
                String exisIni = vista.jtfExistenciasIniciales.getText().trim();
                String costoUnitario = vista.jtfCostoUnitario.getText().trim();
                String stock = vista.jtfExistenciasIniciales.getText().trim();
                
                //Se valida que los campos existenciInicial y costoUnitario sean valores numéricos:
                try
                {
                    //Se hace el parseo de los campos existenciaInicial y costoUnitario:
                    Integer.parseInt(exisIni);
                    Float.parseFloat(costoUnitario);
                    
                    //En caso de que no haya ningún error, se añade el nuevo producto a la DB y al jTable de productos,
                    //se limpian los campos del formulario respectivo.
                    if(añadirProducto(codProducto,descripcion,grado,exisIni,"0","0",costoUnitario,stock) == true)
                    {
                        limpiarFormularioPestaña2();
                        añadirATablaProductos(codProducto,descripcion,grado,exisIni,"0","0",costoUnitario,stock);
                        JOptionPane.showMessageDialog(null, "Producto añadido exitosamente.");
                    }
                }catch(NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(null, "Error. El campo de existencias iniciales y costo unitario deben ser valores numéricos.");
                } 
            } 
        }//Fin botón añadirProducto.
        
        
        //Botón limpiarEntrada:-------------------
        if(e.getSource() == vista.jbLimpiarEntrada)
        {
            limpiarFormularioEntrada();
        }//Fin botón limpiarEntrada
        
        
        //Botón aceptarEntrada:-------------------
        if(e.getSource() == vista.jbAceptarEntrada)
        {
            if(vista.jtfP3CantidadEntrante.getText().equals("") ||
               vista.jtfP3CodProducto.getText().equals("") ||
               vista.jtfP3CostoTotalPesos.getText().equals("") ||
               vista.jtfP3NomProveedor.getText().equals("") ||
               vista.jtfP3NumFactura.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Los campos marcados con un asterisco (*) no pueden estar vacíos.", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
            else
            {
                String codProducto = vista.jtfP3CodProducto.getText();
                String numFactura = vista.jtfP3NumFactura.getText();
                String nombreProveedor = vista.jtfP3NomProveedor.getText();
                String costoDolares = vista.jtfP3CostoDolares.getText();
                String tasaDeCambio = vista.jtfP3TasaCambio.getText();
                String costoTotalPesos = vista.jtfP3CostoTotalPesos.getText();
                String cantEntrante = vista.jtfP3CantidadEntrante.getText();
                
                try
                {
                    if(!costoDolares.equals(""))
                        Float.parseFloat(costoDolares);
                    else costoDolares=null;
                    
                    if(!tasaDeCambio.equals(""))
                        Float.parseFloat(tasaDeCambio);
                    else tasaDeCambio=null;
                    
                    Integer.parseInt(numFactura);
                    Integer.parseInt(cantEntrante);
                    Float.parseFloat(costoTotalPesos);
                    
                    if(añadirEntrada(codProducto,numFactura,nombreProveedor,costoDolares,tasaDeCambio,costoTotalPesos,cantEntrante) == true)
                    {
                        limpiarFormularioEntrada();
                        añadirATablaEntradas(numFactura, codProducto, nombreProveedor, costoDolares, tasaDeCambio, costoTotalPesos, cantEntrante);
                        JOptionPane.showMessageDialog(null, "Entrada añadida exitosamente.");
                    }
                }catch(NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(null, "Error. Los campos Numero de factura, Cantidad Entrante y Costo total en pesos deben ser valores numéricos.");
                } 
            }
                
        }//Fin botón aceptarEntrada
    }
    //FIN BOTONES*********************************************************************************************
    
    
    
    
    
    //AÑADIR REGISTROS:***************************************************************************************
    
    public boolean añadirProducto(String codProducto,String descripcion,String grado,String exisIni,
                                  String entradas,String salidas,String costoUnitario,String stock)
    {
        String query="insert into productos values ('"+codProducto+"','"+descripcion+"','"
                     +grado+"','"+exisIni+"','"+entradas+"','"+salidas+"','"+costoUnitario+"','"+stock+"')";

        //Envío de Query:-----------------------
        conexion.abrirConexion();

        if(conexion.ejecutarQuery(query) != true)
        {
            conexion.cerrarConexion();
            return false;
        }

        conexion.cerrarConexion();
        //Fin del envío de la Query.------------
            
        return true;
    }
    //Fin añadirProducto()------------------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------------------------------------
    
    //En este método pueden haber valores nulos por lo cual la query se hace diferente 
    //dependiendo de si hay valores null o no, y en caso de haberlos entonces dependiendo de cuáles son nulos y cuáles no.
    public boolean añadirEntrada(String codProducto,String numFactura,String nombreProveedor,String costoDolares,
                               String tasaDeCambio,String costoTotalPesos,String cantEntrante)
    {
        String query;
        
        //Query en caso de que ambos valores sean nulos:
        if(costoDolares==null && tasaDeCambio==null)
            query="insert into entradas values ('"+codProducto+"','"+numFactura+"','"
                     +nombreProveedor+"',"+null+","+null+",'"+costoTotalPesos+"','"+cantEntrante+"')";
        
        //Query en caso de que sólo costoDolares sea nulo:
        else if(costoDolares==null)
            query="insert into entradas values ('"+codProducto+"','"+numFactura+"','"
                     +nombreProveedor+"',"+null+",'"+tasaDeCambio+"','"+costoTotalPesos+"','"+cantEntrante+"')";
        
        //Query en caso de que tasaDeCambio sea nulo:
        else if(tasaDeCambio==null)
            query="insert into entradas values ('"+codProducto+"','"+numFactura+"','"
                     +nombreProveedor+"','"+costoDolares+"',"+null+",'"+costoTotalPesos+"','"+cantEntrante+"')";
        
        //Query en caso de que ningún valor sea nulo:
        else
        query="insert into entradas values ('"+codProducto+"','"+numFactura+"','"
                     +nombreProveedor+"','"+costoDolares+"','"+tasaDeCambio+"','"+costoTotalPesos+"','"+cantEntrante+"')";

        //Envío de Query:-----------------------
        conexion.abrirConexion();

        if(conexion.ejecutarQuery(query) != true)
        {
            conexion.cerrarConexion();
            return false;
        }

        conexion.cerrarConexion();
        //Fin del envío de la Query.------------
        
        return true;
    }
    //Fin añadirEntrada()------------------------------------------------------------------------------------
    
    //FIN AÑADIR REGISTROS***********************************************************************************/
    
    
    
    
    
    //BORRAR TABLAS:******************************************************************************************
    
    public void borrarTablaProductos()
    {
        for (int i = modeloProductos.getRowCount() -1; i >= 0; i--)
        {
            modeloProductos.removeRow(i);
        }
    }
    //Fin borrarTablaProductos()-------------------------------------------------------------------------------
    
    //---------------------------------------------------------------------------------------------------------
    
    public void borrarTablaEntradas()
    {
        for (int i = modeloEntradas.getRowCount() -1; i >= 0; i--)
        {
            modeloEntradas.removeRow(i);
        }
    }
    //Fin borrarTablaEntradas()------------------------------------------------------------------------------
    
    //FIN BORRAR TABLAS*************************************************************************************
    
    
    
    
    
    //AÑADIR A TABLAS:****************************************************************************************/
    
    public void añadirATablaProductos(String codProducto, String descripcion, String grado, String exisIni, 
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
                
        modeloProductos.addRow(object);   
    }
    //Fin actualizarTablaProductos()----------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------------
    
    public void añadirATablaEntradas(String numFactura, String codProducto, String proveedor, String costoEnDolares, 
                                         String tasaDeCambio, String costoTotalPesos, String cantEntrante)
    {
        Object []object = new Object[7];
        object[0] = numFactura;
        object[1] = codProducto;
        object[2] = proveedor;
        object[3] = "US $ "+costoEnDolares; 
        object[4] = tasaDeCambio;
        object[5] = "$ "+costoTotalPesos;
        object[6] = cantEntrante;
                
        modeloEntradas.addRow(object);   
    }
    //Fin actualizarTablaEntradas()----------------------------------------------------------------------------
    
    //FIN AÑADIR TABLAS****************************************************************************************
    
    
    
    
    //LIMPIADORES:**********************************************************************************************
    public void limpiarFormularioPestaña2() //cambiar nombre del método xd
    {
        vista.jtfCodigoProducto.setText("");
        vista.jtfDescripcion.setText("");
        vista.jtfGrado.setText("");        
        vista.jtfExistenciasIniciales.setText("");        
        vista.jtfCostoUnitario.setText("");
    }
    //Fin limpiarFormularioPestaña2()---------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------------
    
    public void limpiarFormularioEntrada()
    {
        vista.jtfP3CantidadEntrante.setText("");
        vista.jtfP3CodProducto.setText("");
        vista.jtfP3CostoDolares.setText("");
        vista.jtfP3CostoTotalPesos.setText("");
        vista.jtfP3NomProveedor.setText("");
        vista.jtfP3NumFactura.setText("");
        vista.jtfP3TasaCambio.setText("");
    }
    //Fin limpiarFormularioEntrada()---------------------------------------------------------------------------
    
    //FIN LIMPIADORES******************************************************************************************
    
    
    
    
    
    //Método principal------------------------------------------------------------------------------------------
    public static void main(String args[]) {
        Controlador control = new Controlador(new Vista());
    }
    //Fin método principal--------------------------------------------------------------------------------------
}