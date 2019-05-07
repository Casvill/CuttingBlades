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

//AUTOCOMPLETADORES: Métodos para buscar coincidencias con lo que se está escribiendo y llenar el campo de texto
//                   al darle enter o click.
//----------------------------------------------------------------------------------------------------------

//ESTAS SON NOTAS QUE HE PUESTO Y DEBERÍA MIRAR:
//Consultar
//----------------------------------------------------------------------------------------------------------
//OTROS:
//*Para tener en cuenta a la hora de hacer la lógica de entradas/salidas (movimientos):
//update productos set stock = ((existenciasini + entradas)-salidas)
//Cada que haya una entrada, el costo unitario del producto cambia así:
//costoUnitario = ( (costoUnitario * stock) + (costoUnitarioEntrante * cantEntrante) ) / (stock + cantEntrante)

//*Hacer algo para que al ingresar un registro con una llave primaria repetida, no se muestre el mensaje de adv
//que se está mostrando sino otro.

//CÓDIGO:-----------------------------------------------------------------------------------------------------

package controlador;

import com.mxrck.autocompleter.TextAutoCompleter; 

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
    private DefaultTableModel modeloProductos,modeloMovimientos;
    private Conexion conexion;
    
    //Esta variable es para controlar la busqueda en la tabla de registros, cambia según se oprima el botón Entradas / Salidas
    //Su función principal está en: jtfBusquedaPorNumFacturaMovimientosKeyReleased
    private boolean setTablaMovimiento; //false entradas / true salidas
    
    
    private TextAutoCompleter textAutoCompleterEntrada; 

    
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
        this.vista.jbEntradas.addActionListener(this);
        this.vista.jbSalidas.addActionListener(this);
        //Fin ActionListener.----------------------------------------
        
        
        //Consultar:------------------------------------------------------------
        //Esto se es lo que se debe añadir para añadir una escucha a un campo de texto
        //al soltar una tecla. En este caso se le añadió al campo de búsqueda de productos por código.
        //En este video explican un poco los eventos del teclado: https://www.youtube.com/watch?v=_BWYtHNmKCc
        this.vista.jtfBusquedaPorCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBusquedaPorCodigoProductoKeyReleased(evt);
            }
        });
        this.vista.jtfBusquedaPorNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBusquedaPorNumFacturaMovimientosKeyReleased(evt);
            }
        });
        //Fin Consultar.-------------------------------------------------------------------------------------
        
        
        //Modelos de tablas:------------------------------------------------------
        modeloProductos = (DefaultTableModel) this.vista.jtProductos.getModel();
        modeloMovimientos = (DefaultTableModel) this.vista.jtRegistros.getModel();
       //Fin modelo de tabla------------------------------------------------------
       
       
       //Se extraen datos de la DB:-
       extraerProductosDeDB();
       extraerEntradasDeDB();
       //Fin de extacción.----------
       
       
       //Importar tabla de excel:-----------
       DropXlsx drop = new DropXlsx();
       drop.setJtable(this.vista.jtImportar);
       //Fin importar tabla de excel--------
       
       
       //Auto completadores de texto:---------------------------------------------------------------------------------
       textAutoCompleterEntrada = new TextAutoCompleter(this.vista.jtfFormularioEntradaCodProducto);
       autoCompletadorDeTextoDeCodigoProducto(textAutoCompleterEntrada, this.vista.jtfFormularioEntradaCodProducto.getText().trim());
       //Fin auto completadores de texto.-----------------------------------------------------------------------------
       
       
    }
    //Fin Constructor----------------------------------------------------------------------------------------
    
    
    
    //EXTRACCIÓN DB:****************************************************************************************/
    
    public void extraerProductosDeDB()
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
            JOptionPane.showMessageDialog(vista, "Error al tratar de recuperar los datos de la base de datos:\n"+error.getMessage());
        }
        conexion.cerrarConexion();
    }
    //Fin extraerProductos()------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    public void extraerEntradasDeDB()
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
    
    public void extraerSalidas()
    {
        conexion.abrirConexion();
        ResultSet rs = conexion.ejecutarQueryResult("select * from salidas");
        try
        {
            while(rs.next())
            {
                añadirATablaSalidas(rs.getString("numfactura"), rs.getString("codigoproducto"), rs.getString("comprador"), rs.getString("preciounitario")
                                        , rs.getString("preciototal"), rs.getString("cantsalient"));
            }
        }catch(SQLException | NullPointerException error)
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos:\n"+error.getMessage());
        }
        conexion.cerrarConexion();
    }
    //Fin extraerSalidas()--------------------------------------------------------------------------------------
    
    //FIN EXTRACCIÓN DB******************************************************************************************
    
    
    
    //BUSQUEDAS:***************************************************************************************************/
    
    private void jtfBusquedaPorCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) 
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
    //Fin jtfBusquedaPorCodigoProductoKeyReleased()---------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    private void jtfBusquedaPorNumFacturaMovimientosKeyReleased(java.awt.event.KeyEvent evt) 
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
            if(!setTablaMovimiento)
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
            else if(setTablaMovimiento)
            {
                conexion.abrirConexion();
                ResultSet rs = conexion.ejecutarQueryResult("select * from salidas where numfactura like '"+busqueda+"%'");
                try 
                {
                    borrarTablaSalidas();
                    while(rs.next())
                    {
                        añadirATablaSalidas(rs.getString("numfactura"), rs.getString("codigoproducto"), rs.getString("comprador"), rs.getString("preciounitario")
                                        , rs.getString("preciototal"), rs.getString("cantsalient"));
                    }
                    conexion.cerrarConexion();

                } catch (SQLException error) 
                {
                    JOptionPane.showMessageDialog(null, "Error al tratar de recuperar los datos de la base de datos.");
                    conexion.cerrarConexion();
                }
            }
            
        }
    }     
    //Fin jtfBusquedaPorNumFacturaMovimientosKeyReleased()---------------------------------------------------------------------
    
    //FIN BUSQUEDAS*********************************************************************************************
    
    
    
    
    
    //BOTONES:**************************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Añade el producto en caso de que cumpla los requisitos
        if(e.getSource() == vista.jbAñadirProducto)
        {   
            //Se verifica que ningún campo esté vacío:
            if(vista.jtfFormularioAddProductoCodigoProducto.getText().equals("") || 
               vista.jtfFormularioAddProductoDescripcion.getText().equals("") ||
               vista.jtfFormularioAddProductoGrado.getText().equals("") ||
               vista.jtfFormularioAddProductoExistenciasIniciales.getText().equals("") ||
               vista.jtfFormularioAddProductoCostoUnitario.getText().equals("")   )
            {
                JOptionPane.showMessageDialog(vista, "No puede haber ningún campo vacío.", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
            //Si ningún campo está vacío, se guardan los valores introducidos:
            else
            { 
                String codProducto=vista.jtfFormularioAddProductoCodigoProducto.getText().trim();
                String descripcion=vista.jtfFormularioAddProductoDescripcion.getText().trim();
                String grado = vista.jtfFormularioAddProductoGrado.getText().trim();
                String exisIni = vista.jtfFormularioAddProductoExistenciasIniciales.getText().trim();
                String costoUnitario = vista.jtfFormularioAddProductoCostoUnitario.getText().trim();
                String stock = vista.jtfFormularioAddProductoExistenciasIniciales.getText().trim();
                
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
                        limpiarFormularioAñadirProducto();
                        añadirATablaProductos(codProducto,descripcion,grado,exisIni,"0","0",costoUnitario,stock);
                        textAutoCompleterEntrada.addItem(codProducto);
                        JOptionPane.showMessageDialog(vista, "Producto añadido exitosamente.");
                    }
                    
                }catch(NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(vista, "El campo de existencias iniciales y costo unitario deben ser valores numéricos.", "Error", JOptionPane.WARNING_MESSAGE);
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
            //Se verifica que ningún campo obligatorio esté vacío:
            if(vista.jtfFormularioEntradaCantidadEntrante.getText().equals("") ||
               vista.jtfFormularioEntradaCodProducto.getText().equals("") ||
               vista.jtfFormularioEntradaCostoTotalPesos.getText().equals("") ||
               vista.jtfFormularioEntradaNomProveedor.getText().equals("") ||
               vista.jtfFormularioEntradaNumFactura.getText().equals(""))
            {
                JOptionPane.showMessageDialog(vista, "Los campos marcados con un asterisco (*) no pueden estar vacíos.", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
            //Se verifica que la cantidad de productos entrante sea 1 como mínimo:
            else if(Integer.parseInt(vista.jtfFormularioEntradaCantidadEntrante.getText()) < 1)
            {
                JOptionPane.showMessageDialog(vista, "La cantidad de productos entrante debe ser mínimo 1", "Error", JOptionPane.WARNING_MESSAGE);
                vista.jtfFormularioEntradaCantidadEntrante.setText("");
            }
            
            else
            {
                String codProducto = vista.jtfFormularioEntradaCodProducto.getText().trim();
                String numFactura = vista.jtfFormularioEntradaNumFactura.getText().trim();
                String nombreProveedor = vista.jtfFormularioEntradaNomProveedor.getText().trim();
                String costoDolares = vista.jtfFormularioEntradaCostoDolares.getText().trim();
                String tasaDeCambio = vista.jtfFormularioEntradaTasaCambio.getText().trim();
                String costoTotalPesos = vista.jtfFormularioEntradaCostoTotalPesos.getText().trim();
                String cantEntrante = vista.jtfFormularioEntradaCantidadEntrante.getText().trim();
                
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
                    
                    if(verificarExistenciaDelProducto(codProducto))
                    {
                        if(añadirEntrada(codProducto,numFactura,nombreProveedor,costoDolares,tasaDeCambio,costoTotalPesos,cantEntrante))
                        {
                            limpiarFormularioEntrada();
                            añadirATablaEntradas(numFactura, codProducto, nombreProveedor, costoDolares, tasaDeCambio, costoTotalPesos, cantEntrante);
                            actualizarProductoPorEntrada(codProducto, Integer.parseInt(cantEntrante), Float.parseFloat(costoTotalPesos));
                            JOptionPane.showMessageDialog(vista, "Entrada añadida exitosamente.");
                        }
                    }
                    
                    else
                        JOptionPane.showMessageDialog(vista, "El código de producto '"+codProducto+"' no se encuentra registrado en la base de datos.", "Error", JOptionPane.WARNING_MESSAGE);
                    
                    
                }catch(NumberFormatException error)
                {
                    JOptionPane.showMessageDialog(vista, "Los campos Numero de factura, Cantidad Entrante y Costo total en pesos deben ser valores numéricos.", "Error", JOptionPane.WARNING_MESSAGE);
                } 
            }
                
        }//Fin botón aceptarEntrada
        
        
        //Botón Entradas (de registros)
        if(e.getSource() == vista.jbEntradas)
        {
            setTablaMovimiento=false; 
            
            //Se cambia el modelo de la tabla para ser compatible con Entradas:-------
            vista.jtRegistros.setModel(new javax.swing.table.DefaultTableModel
            (
                new Object [][] {},
                new String [] 
                {
                    "Número de factura", "Código del producto", "Proveedor", "Costo en dólares (Unitario)", "Tasa de cambio", "Costo total en pesos", "Cantidad entrante"
                }
            ) 
            {
                boolean[] canEdit = new boolean [] 
                {
                    false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) 
                {
                    return canEdit [columnIndex];
                }
            });//Fin cambio de modelo---------------------------------------------------
            
            //Se cambia el modelo de la tabla para poder usar el método añadirATablaMovimientos()
            modeloMovimientos = (DefaultTableModel) vista.jtRegistros.getModel(); 
            
            extraerEntradasDeDB();
        }
        
        if(e.getSource() == vista.jbSalidas)
        {
            setTablaMovimiento = true;
            
            //Se cambia el modelo de la tabla para ser compatible con Salidas:-------
            vista.jtRegistros.setModel(new javax.swing.table.DefaultTableModel
            (
                new Object [][] {},
                new String [] 
                {
                    "Número de factura", "Código del producto", "Comprador", "Précio unitario", "Précio total", "Cantidad saliente"
                }
            ) 
            {
                boolean[] canEdit = new boolean [] 
                {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) 
                {
                    return canEdit [columnIndex];
                }
            });//Fin cambio de modelo--------------------------------------------------
            
            //Se cambia el modelo de la tabla para poder usar el método añadirATablaMovimientos()
            modeloMovimientos = (DefaultTableModel) vista.jtRegistros.getModel();
            
            extraerSalidas();
        }
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
        for (int i = modeloMovimientos.getRowCount() -1; i >= 0; i--)
        {
            modeloMovimientos.removeRow(i);
        }
    }
    //Fin borrarTablaEntradas()------------------------------------------------------------------------------
    
    public void borrarTablaSalidas()
    {
        for (int i = modeloMovimientos.getRowCount() -1; i >= 0; i--)
        {
            modeloMovimientos.removeRow(i);
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
        
        if(costoEnDolares == null)
            object[3] = "";
        else
            object[3] = "US $ "+costoEnDolares; 
        
        object[4] = tasaDeCambio;
        object[5] = "$ "+costoTotalPesos;
        object[6] = cantEntrante;
                
        modeloMovimientos.addRow(object);   
    }
    //Fin actualizarTablaEntradas()----------------------------------------------------------------------------
    
    public void añadirATablaSalidas(String numFactura, String codProducto, String comprador, String precioUnitario, 
                                         String precioTotal, String cantSaliente)
    {
        Object []object = new Object[6];
        object[0] = numFactura;
        object[1] = codProducto;
        object[2] = comprador;
        object[3] = "$ "+precioUnitario; 
        object[4] = "$ "+precioTotal;
        object[5] = cantSaliente;
                
        modeloMovimientos.addRow(object);   
    }
    //Fin actualizarTablaEntradas()----------------------------------------------------------------------------
    
    //FIN AÑADIR TABLAS****************************************************************************************
    
    
    
    
    
    //LIMPIADORES:**********************************************************************************************
    public void limpiarFormularioAñadirProducto() 
    {
        vista.jtfFormularioAddProductoCodigoProducto.setText("");
        vista.jtfFormularioAddProductoDescripcion.setText("");
        vista.jtfFormularioAddProductoGrado.setText("");        
        vista.jtfFormularioAddProductoExistenciasIniciales.setText("");        
        vista.jtfFormularioAddProductoCostoUnitario.setText("");
    }
    //Fin limpiarFormularioAñadirProducto()---------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------------
    
    public void limpiarFormularioEntrada()
    {
        vista.jtfFormularioEntradaCantidadEntrante.setText("");
        vista.jtfFormularioEntradaCodProducto.setText("");
        vista.jtfFormularioEntradaCostoDolares.setText("");
        vista.jtfFormularioEntradaCostoTotalPesos.setText("");
        vista.jtfFormularioEntradaNomProveedor.setText("");
        vista.jtfFormularioEntradaNumFactura.setText("");
        vista.jtfFormularioEntradaTasaCambio.setText("");
    }
    //Fin limpiarFormularioEntrada()---------------------------------------------------------------------------
    
    //FIN LIMPIADORES******************************************************************************************
    
    
    
    
    
    //AUTOCOMPLETADORES:**********************************************************************************************
    public void autoCompletadorDeTextoDeCodigoProducto(TextAutoCompleter textAutoCompleter, String codigoBuscado)
    {
        conexion.abrirConexion();
        ResultSet rs = conexion.ejecutarQueryResult("select * from productos where codigoproducto like '"+codigoBuscado+"%'");
        try 
        {
            while(rs.next())
            {
                textAutoCompleter.addItem(rs.getString("codigoproducto"));
            }
            conexion.cerrarConexion();

        } catch (SQLException error) 
        {
            conexion.cerrarConexion();
        }
    }//fin autocompletadorDeTextoDeCodigoProducto()-----------------------------------------------------------------
    
    //FIN AUTOCOMPLETADORES******************************************************************************************
    
    
    
    
    
    public boolean verificarExistenciaDelProducto(String codigoDelProducto)
    {
        for (int i = 0; i < modeloProductos.getRowCount(); i++) 
        {
            if(codigoDelProducto.equals(modeloProductos.getValueAt(i, 0)))
                return true;
        }
        return false;
    }//Fin verificarExistenciaDelProducto()-------------------------------
    
    

    public void actualizarProductoPorEntrada(String codigoProducto, int cantidadEntrante, float costoTotalPesos)
    {
        float nuevoCostoUnitario=0;
        float anteriorCostoUnitario=0;
        int stock=0;
        
        //Se buscan los valores stock y costoUnitario desde la tabla de productos
        for (int i = 0; i < modeloProductos.getRowCount(); i++) 
        {
            if(codigoProducto.equals(modeloProductos.getValueAt(i, 0)))
            {
                stock = Integer.parseInt((String) modeloProductos.getValueAt(i, 7));
                //Este valor primero se castea a String, luego se le quita la parte "$ ", y luego se parsea a float:
                anteriorCostoUnitario =  Float.parseFloat(((String) modeloProductos.getValueAt(i, 6)).substring(1,((String) modeloProductos.getValueAt(i, 6)).length())); 
            }
        }
        
        //Se hace la operación para hallar el costo unitario ponderado
        nuevoCostoUnitario = ( (anteriorCostoUnitario * stock) + costoTotalPesos ) / (stock + cantidadEntrante);
        
        //Se actualiza la base de datos según los datos de la entrada
        conexion.abrirConexion();
        conexion.ejecutarQuery("UPDATE productos SET costounitario="+nuevoCostoUnitario+", entradas=entradas+"+cantidadEntrante+", stock=stock+"+cantidadEntrante+" WHERE codigoproducto='"+codigoProducto+"';");
        conexion.cerrarConexion();
        
        
        //Se actualiza la tabla de productos con los cambios hechos en la DB
        borrarTablaProductos();
        extraerProductosDeDB();
    }//Fin actualizaProductoPorEntrada()------------------------------------------------------------------------
    
    
    
    
    
    //Método principal------------------------------------------------------------------------------------------
    public static void main(String args[]) {
        Controlador control = new Controlador(new Vista());
    }
    //Fin método principal--------------------------------------------------------------------------------------
}