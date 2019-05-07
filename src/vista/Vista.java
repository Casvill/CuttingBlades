// Para buscar rápido esta clase contiene:

package vista;

public class Vista extends javax.swing.JFrame {

    
    public Vista() {
        initComponents();
        setTitle("Cutting Blades");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jlBusquedaPorCodigo = new javax.swing.JLabel();
        jtfBusquedaPorCodigoProducto = new javax.swing.JTextField();
        jPanelRegistros = new javax.swing.JPanel();
        jlBusquedaPorNumDeFactura = new javax.swing.JLabel();
        jtfBusquedaPorNumFactura = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtRegistros = new javax.swing.JTable();
        jbEntradas = new javax.swing.JButton();
        jbSalidas = new javax.swing.JButton();
        jPanelMovimientos = new javax.swing.JPanel();
        jpSalida = new javax.swing.JPanel();
        jpEntrada = new javax.swing.JPanel();
        jlP3CodProducto = new javax.swing.JLabel();
        jtfFormularioEntradaNumFactura = new javax.swing.JTextField();
        jlP3NumFactura = new javax.swing.JLabel();
        jtfFormularioEntradaCodProducto = new javax.swing.JTextField();
        jlP3NomProveedor = new javax.swing.JLabel();
        jtfFormularioEntradaNomProveedor = new javax.swing.JTextField();
        jlP3CostoDolares = new javax.swing.JLabel();
        jtfFormularioEntradaCostoDolares = new javax.swing.JTextField();
        jlP3TasaCambio = new javax.swing.JLabel();
        jtfFormularioEntradaCostoTotalPesos = new javax.swing.JTextField();
        jlP3CostoTotalPesos = new javax.swing.JLabel();
        jlP3CantidadEntrante = new javax.swing.JLabel();
        jtfFormularioEntradaTasaCambio = new javax.swing.JTextField();
        jtfFormularioEntradaCantidadEntrante = new javax.swing.JTextField();
        jbLimpiarEntrada = new javax.swing.JButton();
        jbAceptarEntrada = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelAñadirProducto = new javax.swing.JPanel();
        jPanelSubAñadir = new javax.swing.JPanel();
        jtfFormularioAddProductoGrado = new javax.swing.JTextField();
        jlExistenciasIniciales = new javax.swing.JLabel();
        jbAñadirProducto = new javax.swing.JButton();
        jlGrado = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        jlCostoUnitario = new javax.swing.JLabel();
        jtfFormularioAddProductoDescripcion = new javax.swing.JTextField();
        jtfFormularioAddProductoCodigoProducto = new javax.swing.JTextField();
        jlCodigoProducto = new javax.swing.JLabel();
        jtfFormularioAddProductoCostoUnitario = new javax.swing.JTextField();
        jtfFormularioAddProductoExistenciasIniciales = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelImportarArchivo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtImportar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de producto", "Descripción", "Grado", "Existencias Iniciales", "Entradas", "Salidas", "Costo Unitario", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductos.setAlignmentX(8.0F);
        jtProductos.setSelectionBackground(new java.awt.Color(153, 255, 153));
        jScrollPane1.setViewportView(jtProductos);
        if (jtProductos.getColumnModel().getColumnCount() > 0) {
            jtProductos.getColumnModel().getColumn(0).setPreferredWidth(110);
            jtProductos.getColumnModel().getColumn(4).setPreferredWidth(40);
            jtProductos.getColumnModel().getColumn(5).setPreferredWidth(40);
            jtProductos.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        jlBusquedaPorCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlBusquedaPorCodigo.setText("Código de producto:");

        javax.swing.GroupLayout jPanelGeneralLayout = new javax.swing.GroupLayout(jPanelGeneral);
        jPanelGeneral.setLayout(jPanelGeneralLayout);
        jPanelGeneralLayout.setHorizontalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addComponent(jlBusquedaPorCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(jtfBusquedaPorCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelGeneralLayout.setVerticalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralLayout.createSequentialGroup()
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jlBusquedaPorCodigo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfBusquedaPorCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("General", jPanelGeneral);

        jlBusquedaPorNumDeFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlBusquedaPorNumDeFactura.setText("Número de factura:");

        jtRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de factura", "Código del producto", "Proveedor", "Costo en dólares (Unitario)", "Tasa de cambio", "Costo total en pesos", "Cantidad entrante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jtRegistros);
        if (jtRegistros.getColumnModel().getColumnCount() > 0) {
            jtRegistros.getColumnModel().getColumn(5).setHeaderValue("Costo total en pesos");
        }

        jbEntradas.setText("Entradas");

        jbSalidas.setText("Salidas");

        javax.swing.GroupLayout jPanelRegistrosLayout = new javax.swing.GroupLayout(jPanelRegistros);
        jPanelRegistros.setLayout(jPanelRegistrosLayout);
        jPanelRegistrosLayout.setHorizontalGroup(
            jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                    .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                        .addComponent(jlBusquedaPorNumDeFactura)
                        .addGap(18, 18, 18)
                        .addComponent(jtfBusquedaPorNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jbEntradas)
                        .addGap(27, 27, 27)
                        .addComponent(jbSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRegistrosLayout.setVerticalGroup(
            jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrosLayout.createSequentialGroup()
                .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrosLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jlBusquedaPorNumDeFactura))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBusquedaPorNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEntradas)
                            .addComponent(jbSalidas))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registros", jPanelRegistros);

        jpSalida.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2), "Salida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        javax.swing.GroupLayout jpSalidaLayout = new javax.swing.GroupLayout(jpSalida);
        jpSalida.setLayout(jpSalidaLayout);
        jpSalidaLayout.setHorizontalGroup(
            jpSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpSalidaLayout.setVerticalGroup(
            jpSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        jpEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2), "Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jlP3CodProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlP3CodProducto.setText("Código del producto:");
        jlP3CodProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        jlP3NumFactura.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlP3NumFactura.setText("Número de Factura: ");
        jlP3NumFactura.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        jlP3NomProveedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlP3NomProveedor.setText("Nombre del proveedor: ");
        jlP3NomProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        jlP3CostoDolares.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlP3CostoDolares.setText("Costo en dólares:");
        jlP3CostoDolares.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        jlP3TasaCambio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlP3TasaCambio.setText("Tasa de cambio:");
        jlP3TasaCambio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        jlP3CostoTotalPesos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlP3CostoTotalPesos.setText("Costo total en pesos:");
        jlP3CostoTotalPesos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        jlP3CantidadEntrante.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlP3CantidadEntrante.setText("Cantidad entrante:");
        jlP3CantidadEntrante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        jbLimpiarEntrada.setText("Limpiar");

        jbAceptarEntrada.setText("Aceptar");

        jLabel2.setText("*         ");

        jLabel3.setText("*         ");

        jLabel4.setText("*         ");

        jLabel5.setText("*         ");

        jLabel6.setText("*         ");

        javax.swing.GroupLayout jpEntradaLayout = new javax.swing.GroupLayout(jpEntrada);
        jpEntrada.setLayout(jpEntradaLayout);
        jpEntradaLayout.setHorizontalGroup(
            jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlP3CodProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlP3NumFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlP3NomProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlP3CostoDolares, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfFormularioEntradaNumFactura)
                    .addComponent(jtfFormularioEntradaCodProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jtfFormularioEntradaNomProveedor)
                    .addComponent(jtfFormularioEntradaCostoDolares))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEntradaLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jlP3CostoTotalPesos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfFormularioEntradaCostoTotalPesos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEntradaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEntradaLayout.createSequentialGroup()
                                .addComponent(jlP3TasaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfFormularioEntradaTasaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEntradaLayout.createSequentialGroup()
                                .addComponent(jlP3CantidadEntrante, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfFormularioEntradaCantidadEntrante, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEntradaLayout.createSequentialGroup()
                                .addComponent(jbLimpiarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbAceptarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17))))
        );
        jpEntradaLayout.setVerticalGroup(
            jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEntradaLayout.createSequentialGroup()
                        .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfFormularioEntradaCodProducto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlP3TasaCambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpEntradaLayout.createSequentialGroup()
                                .addComponent(jlP3CodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfFormularioEntradaTasaCambio))
                        .addGap(18, 18, 18))
                    .addGroup(jpEntradaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)))
                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEntradaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpEntradaLayout.createSequentialGroup()
                        .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFormularioEntradaCostoTotalPesos, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addGroup(jpEntradaLayout.createSequentialGroup()
                                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtfFormularioEntradaNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlP3NumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlP3CostoTotalPesos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpEntradaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlP3NomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfFormularioEntradaNomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlP3CantidadEntrante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpEntradaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jtfFormularioEntradaCantidadEntrante, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEntradaLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jbLimpiarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpEntradaLayout.createSequentialGroup()
                                    .addGroup(jpEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlP3CostoDolares, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfFormularioEntradaCostoDolares, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                    .addGap(19, 19, 19))
                                .addGroup(jpEntradaLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jbAceptarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))))))
        );

        javax.swing.GroupLayout jPanelMovimientosLayout = new javax.swing.GroupLayout(jPanelMovimientos);
        jPanelMovimientos.setLayout(jPanelMovimientosLayout);
        jPanelMovimientosLayout.setHorizontalGroup(
            jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMovimientosLayout.setVerticalGroup(
            jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMovimientosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jpEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jpSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Movimientos", jPanelMovimientos);

        jPanelSubAñadir.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)), "Nuevo Producto"));

        jlExistenciasIniciales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlExistenciasIniciales.setText("Existencias Iniciales:");

        jbAñadirProducto.setText("Añadir");

        jlGrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlGrado.setText("Grado:");

        jlDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDescripcion.setText("Descripción:");

        jlCostoUnitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCostoUnitario.setText("Costo Unitario:");

        jlCodigoProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCodigoProducto.setText("Código del producto:");

        javax.swing.GroupLayout jPanelSubAñadirLayout = new javax.swing.GroupLayout(jPanelSubAñadir);
        jPanelSubAñadir.setLayout(jPanelSubAñadirLayout);
        jPanelSubAñadirLayout.setHorizontalGroup(
            jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubAñadirLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelSubAñadirLayout.createSequentialGroup()
                        .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCodigoProducto)
                            .addComponent(jlDescripcion)
                            .addComponent(jlGrado)
                            .addComponent(jlExistenciasIniciales)
                            .addComponent(jlCostoUnitario))
                        .addGap(31, 31, 31)
                        .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFormularioAddProductoCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFormularioAddProductoExistenciasIniciales, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFormularioAddProductoGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFormularioAddProductoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFormularioAddProductoCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelSubAñadirLayout.createSequentialGroup()
                        .addComponent(jbAñadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanelSubAñadirLayout.setVerticalGroup(
            jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubAñadirLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlCodigoProducto)
                    .addComponent(jtfFormularioAddProductoCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelSubAñadirLayout.createSequentialGroup()
                        .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfFormularioAddProductoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDescripcion))
                        .addGap(18, 18, 18)
                        .addComponent(jlGrado))
                    .addComponent(jtfFormularioAddProductoGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfFormularioAddProductoExistenciasIniciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlExistenciasIniciales))
                .addGap(18, 18, 18)
                .addGroup(jPanelSubAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlCostoUnitario)
                    .addComponent(jtfFormularioAddProductoCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jbAñadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Magneto\\Documents\\NetBeansProjects\\CuttingBlades\\src\\vista\\valsider.jpg")); // NOI18N

        javax.swing.GroupLayout jPanelAñadirProductoLayout = new javax.swing.GroupLayout(jPanelAñadirProducto);
        jPanelAñadirProducto.setLayout(jPanelAñadirProductoLayout);
        jPanelAñadirProductoLayout.setHorizontalGroup(
            jPanelAñadirProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAñadirProductoLayout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(jPanelSubAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
            .addGroup(jPanelAñadirProductoLayout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAñadirProductoLayout.setVerticalGroup(
            jPanelAñadirProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAñadirProductoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanelSubAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Añadir Nuevo Producto", jPanelAñadirProducto);

        jtImportar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtImportar);

        javax.swing.GroupLayout jPanelImportarArchivoLayout = new javax.swing.GroupLayout(jPanelImportarArchivo);
        jPanelImportarArchivo.setLayout(jPanelImportarArchivoLayout);
        jPanelImportarArchivoLayout.setHorizontalGroup(
            jPanelImportarArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImportarArchivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelImportarArchivoLayout.setVerticalGroup(
            jPanelImportarArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImportarArchivoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Importar archivo", jPanelImportarArchivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelAñadirProducto;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelImportarArchivo;
    private javax.swing.JPanel jPanelMovimientos;
    private javax.swing.JPanel jPanelRegistros;
    private javax.swing.JPanel jPanelSubAñadir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JButton jbAceptarEntrada;
    public javax.swing.JButton jbAñadirProducto;
    public javax.swing.JButton jbEntradas;
    public javax.swing.JButton jbLimpiarEntrada;
    public javax.swing.JButton jbSalidas;
    private javax.swing.JLabel jlBusquedaPorCodigo;
    private javax.swing.JLabel jlBusquedaPorNumDeFactura;
    private javax.swing.JLabel jlCodigoProducto;
    private javax.swing.JLabel jlCostoUnitario;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlExistenciasIniciales;
    private javax.swing.JLabel jlGrado;
    private javax.swing.JLabel jlP3CantidadEntrante;
    private javax.swing.JLabel jlP3CodProducto;
    private javax.swing.JLabel jlP3CostoDolares;
    private javax.swing.JLabel jlP3CostoTotalPesos;
    private javax.swing.JLabel jlP3NomProveedor;
    private javax.swing.JLabel jlP3NumFactura;
    private javax.swing.JLabel jlP3TasaCambio;
    private javax.swing.JPanel jpEntrada;
    private javax.swing.JPanel jpSalida;
    public javax.swing.JTable jtImportar;
    public javax.swing.JTable jtProductos;
    public javax.swing.JTable jtRegistros;
    public javax.swing.JTextField jtfBusquedaPorCodigoProducto;
    public javax.swing.JTextField jtfBusquedaPorNumFactura;
    public javax.swing.JTextField jtfFormularioAddProductoCodigoProducto;
    public javax.swing.JTextField jtfFormularioAddProductoCostoUnitario;
    public javax.swing.JTextField jtfFormularioAddProductoDescripcion;
    public javax.swing.JTextField jtfFormularioAddProductoExistenciasIniciales;
    public javax.swing.JTextField jtfFormularioAddProductoGrado;
    public javax.swing.JTextField jtfFormularioEntradaCantidadEntrante;
    public javax.swing.JTextField jtfFormularioEntradaCodProducto;
    public javax.swing.JTextField jtfFormularioEntradaCostoDolares;
    public javax.swing.JTextField jtfFormularioEntradaCostoTotalPesos;
    public javax.swing.JTextField jtfFormularioEntradaNomProveedor;
    public javax.swing.JTextField jtfFormularioEntradaNumFactura;
    public javax.swing.JTextField jtfFormularioEntradaTasaCambio;
    // End of variables declaration//GEN-END:variables
}
