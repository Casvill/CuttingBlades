package vista;

public class Vista extends javax.swing.JFrame {

    
    public Vista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jlBusquedaPorCodigo = new javax.swing.JLabel();
        jtfBusquedaPorCodigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jlCodigoProducto = new javax.swing.JLabel();
        jtfCodigoProducto = new javax.swing.JTextField();
        jlDescripcion = new javax.swing.JLabel();
        jtfDescripcion = new javax.swing.JTextField();
        jlGrado = new javax.swing.JLabel();
        jtfGrado = new javax.swing.JTextField();
        jlExistenciasIniciales = new javax.swing.JLabel();
        jtfExistenciasIniciales = new javax.swing.JTextField();
        jlCostoUnitario = new javax.swing.JLabel();
        jtfCostoUnitario = new javax.swing.JTextField();
        jbAñadir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(jtProductos);
        if (jtProductos.getColumnModel().getColumnCount() > 0) {
            jtProductos.getColumnModel().getColumn(0).setResizable(false);
            jtProductos.getColumnModel().getColumn(0).setPreferredWidth(110);
            jtProductos.getColumnModel().getColumn(1).setResizable(false);
            jtProductos.getColumnModel().getColumn(2).setResizable(false);
            jtProductos.getColumnModel().getColumn(3).setResizable(false);
            jtProductos.getColumnModel().getColumn(4).setResizable(false);
            jtProductos.getColumnModel().getColumn(4).setPreferredWidth(40);
            jtProductos.getColumnModel().getColumn(5).setResizable(false);
            jtProductos.getColumnModel().getColumn(5).setPreferredWidth(40);
            jtProductos.getColumnModel().getColumn(6).setResizable(false);
            jtProductos.getColumnModel().getColumn(7).setResizable(false);
            jtProductos.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        jlBusquedaPorCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlBusquedaPorCodigo.setText("Código de producto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlBusquedaPorCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfBusquedaPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBusquedaPorCodigo)
                    .addComponent(jtfBusquedaPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("General", jPanel1);

        jlCodigoProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCodigoProducto.setText("Código del producto:");

        jlDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDescripcion.setText("Descripción:");

        jlGrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlGrado.setText("Grado:");

        jlExistenciasIniciales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlExistenciasIniciales.setText("Existencias Iniciales:");

        jlCostoUnitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCostoUnitario.setText("Costo Unitario:");

        jbAñadir.setText("Añadir");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Magneto\\Documents\\NetBeansProjects\\CuttingBlades\\src\\vista\\valsider.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlCodigoProducto)
                                .addGap(29, 29, 29)
                                .addComponent(jtfCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlGrado)
                                    .addComponent(jlExistenciasIniciales)
                                    .addComponent(jlCostoUnitario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfExistenciasIniciales, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlCodigoProducto)
                                            .addComponent(jtfCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jlDescripcion))
                                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jlGrado))
                            .addComponent(jtfGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jlExistenciasIniciales))
                    .addComponent(jtfExistenciasIniciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlCostoUnitario)
                    .addComponent(jtfCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jbAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Añadir Nuevo Producto", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JButton jbAñadir;
    private javax.swing.JLabel jlBusquedaPorCodigo;
    private javax.swing.JLabel jlCodigoProducto;
    private javax.swing.JLabel jlCostoUnitario;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlExistenciasIniciales;
    private javax.swing.JLabel jlGrado;
    public javax.swing.JTable jtProductos;
    public javax.swing.JTextField jtfBusquedaPorCodigo;
    public javax.swing.JTextField jtfCodigoProducto;
    public javax.swing.JTextField jtfCostoUnitario;
    public javax.swing.JTextField jtfDescripcion;
    public javax.swing.JTextField jtfExistenciasIniciales;
    public javax.swing.JTextField jtfGrado;
    // End of variables declaration//GEN-END:variables
}
