package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;  //borrar
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import vista.Vista;

public class Controlador implements ActionListener {
    
    private Vista vista;
    private Producto producto;
    private DefaultTableModel modelo;
    
    //private ArrayList<Producto> productos; //borrar
    
    
    
    //Constructor
    public Controlador(Vista vista) 
    {   
        this.vista = vista;
        this.vista.setVisible(true);
        
        this.vista.jbAñadir.addActionListener(this);
        this.vista.jtfBusquedaPorCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBusquedaPorCodigoKeyPressed(evt);
            }
        });
        
        //productos = new ArrayList<>(); //borrar
        
        //Modelo de tabla
        modelo = (DefaultTableModel) vista.jtProductos.getModel();
       //Fin modelo de tabla------
    }
    
    //Manejador de eventos al presionar un botón en el campo de texto para la búsqueda por código de producto:
    private void jtBusquedaPorCodigoKeyPressed(java.awt.event.KeyEvent evt) {                                               
        
    }     
    
    
    //Manejador de eventos al presionar un botón:
    @Override
    public void actionPerformed(ActionEvent e) 
    {
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
                Producto p = new Producto();
                p.setCodigoProducto(vista.jtfCodigoProducto.getText().trim());
                p.setDescripcion(vista.jtfDescripcion.getText().trim());
                p.setGrado(vista.jtfGrado.getText().trim());
                try
                {
                    p.setExistenciasIniciales(Integer.parseInt(vista.jtfExistenciasIniciales.getText().trim()));
                    p.setCostoUnitario(Float.parseFloat(vista.jtfCostoUnitario.getText().trim()));
                    //productos.add(p);//borrar
                    actualizarTablaProductos();
                    JOptionPane.showMessageDialog(null, "Producto añadido exitosamente.");
                }catch(NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(null, "Error. El campo de existencias iniciales y costo unitario deben ser valores numéricos.");
                }
            } 
        }
    }
    
    public void actualizarTablaProductos()
    {
        Object []object = new Object[8];
        object[0] = vista.jtfCodigoProducto.getText().trim();
        object[1] = vista.jtfDescripcion.getText().trim();
        object[2] = vista.jtfGrado.getText().trim();
        object[3] = vista.jtfExistenciasIniciales.getText().trim(); 
        object[4] = "";
        object[5] = "";
        object[6] = "$ "+vista.jtfCostoUnitario.getText().trim();
        object[7] = vista.jtfExistenciasIniciales.getText().trim();
        
        vista.jtfCodigoProducto.setText("");
        vista.jtfDescripcion.setText("");
        vista.jtfGrado.setText("");        
        vista.jtfExistenciasIniciales.setText("");        
        vista.jtfCostoUnitario.setText("");
                
        modelo.addRow(object);   
    }
    
    
    public static void main(String args[]) {
        Controlador control = new Controlador(new Vista());
    }
}
