package views;

public class MenuView extends javax.swing.JFrame {

    public MenuView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        btnListar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        btnListar.setText("Listar Vehiculos");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar Vehiculo");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnListar)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {
        ListarVehiculosView view = new ListarVehiculosView();
        view.setMenuPadre(this);
        view.setVisible(true);
        this.setVisible(false);
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        AgregarVehiculosView view = new AgregarVehiculosView(this);
        view.setVisible(true);
    }

    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnAgregar;
}
