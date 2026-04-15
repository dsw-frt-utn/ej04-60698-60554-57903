package views;

import data.Persistencia;
import domain.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgregarVehiculoView extends javax.swing.JFrame {

    private MenuView menuPadre;

    public AgregarVehiculoView(MenuView menuPadre) {
        this.menuPadre = menuPadre;
        initComponents();
        cargarCombos();
    }

    private void cargarCombos(){
        ArrayList<Marca> marcas = Persistencia.getMarcas();
        for(Marca marca : marcas){
            cboMarca.addItem(marca.getNombre());
        }

        ArrayList<Sucursal> sucursales = Persistencia.getSucursales();
        for(Sucursal suc : sucursales){
            cboSucursal.addItem(suc.getCodigo());
        }

        cboTipo.addItem("Combustible");
        cboTipo.addItem("Electrico");
    }

    private Sucursal buscarSucursal(String codigo){
        for(Sucursal suc : Persistencia.getSucursales()){
            if(suc.getCodigo().equals(codigo))
                return suc;
        }
        return null;
    }

    private Marca buscarMarca(String nombre){
        for(Marca marca : Persistencia.getMarcas()){
            if(marca.getNombre().equals(nombre))
                return marca;
        }
        return null;
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Vehiculo");

        javax.swing.JPanel main = new javax.swing.JPanel();
        main.setLayout(new javax.swing.BoxLayout(main, javax.swing.BoxLayout.Y_AXIS));

        lblPatente = new javax.swing.JLabel("Patente:");
        txtPatente = new javax.swing.JTextField(10);
        lblMarca = new javax.swing.JLabel("Marca:");
        cboMarca = new javax.swing.JComboBox<>();
        lblModelo = new javax.swing.JLabel("Modelo:");
        txtModelo = new javax.swing.JTextField(15);
        lblAnio = new javax.swing.JLabel("Anio:");
        txtAnio = new javax.swing.JTextField(6);
        lblCapacidad = new javax.swing.JLabel("Capacidad Carga:");
        txtCapacidad = new javax.swing.JTextField(10);
        lblSucursal = new javax.swing.JLabel("Sucursal:");
        cboSucursal = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel("Tipo:");
        cboTipo = new javax.swing.JComboBox<>();

        lblKmLitro = new javax.swing.JLabel("Km/Litro:");
        txtKmLitro = new javax.swing.JTextField(10);
        lblLitrosExtra = new javax.swing.JLabel("Litros Extra:");
        txtLitrosExtra = new javax.swing.JTextField(10);

        lblKwhBase = new javax.swing.JLabel("kWh Base:");
        txtKwhBase = new javax.swing.JTextField(10);

        panelCombustible = new javax.swing.JPanel();
        panelCombustible.setLayout(new javax.swing.BoxLayout(panelCombustible, javax.swing.BoxLayout.Y_AXIS));
        panelCombustible.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Combustible"));
        panelCombustible.add(lblKmLitro);
        panelCombustible.add(txtKmLitro);
        panelCombustible.add(lblLitrosExtra);
        panelCombustible.add(txtLitrosExtra);

        panelElectrico = new javax.swing.JPanel();
        panelElectrico.setLayout(new javax.swing.BoxLayout(panelElectrico, javax.swing.BoxLayout.Y_AXIS));
        panelElectrico.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Electrico"));
        panelElectrico.add(lblKwhBase);
        panelElectrico.add(txtKwhBase);

        btnGuardar = new javax.swing.JButton("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVolver = new javax.swing.JButton("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoActionPerformed(evt);
            }
        });

        javax.swing.JPanel fila1 = new javax.swing.JPanel(new java.awt.FlowLayout());
        fila1.add(lblPatente);
        fila1.add(txtPatente);
        fila1.add(lblMarca);
        fila1.add(cboMarca);

        javax.swing.JPanel fila2 = new javax.swing.JPanel(new java.awt.FlowLayout());
        fila2.add(lblModelo);
        fila2.add(txtModelo);
        fila2.add(lblAnio);
        fila2.add(txtAnio);

        javax.swing.JPanel fila3 = new javax.swing.JPanel(new java.awt.FlowLayout());
        fila3.add(lblCapacidad);
        fila3.add(txtCapacidad);
        fila3.add(lblSucursal);
        fila3.add(cboSucursal);

        javax.swing.JPanel fila4 = new javax.swing.JPanel(new java.awt.FlowLayout());
        fila4.add(lblTipo);
        fila4.add(cboTipo);

        javax.swing.JPanel btnPanel = new javax.swing.JPanel(new java.awt.FlowLayout());
        btnPanel.add(btnGuardar);
        btnPanel.add(btnVolver);

        main.add(fila1);
        main.add(fila2);
        main.add(fila3);
        main.add(fila4);
        main.add(panelCombustible);
        main.add(panelElectrico);
        main.add(btnPanel);

        add(main);
        pack();
    }

    private void cboTipoActionPerformed(java.awt.event.ActionEvent evt) {
        boolean esCombustible = cboTipo.getSelectedIndex() == 0;
        panelCombustible.setVisible(esCombustible);
        panelElectrico.setVisible(!esCombustible);
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String patente = txtPatente.getText().trim();
            String modelo = txtModelo.getText().trim();
            int anio = Integer.parseInt(txtAnio.getText().trim());
            double capacidad = Double.parseDouble(txtCapacidad.getText().trim());
            String codigoSucursal = (String) cboSucursal.getSelectedItem();
            String nombreMarca = (String) cboMarca.getSelectedItem();

            Marca marca = buscarMarca(nombreMarca);
            Sucursal sucursal = buscarSucursal(codigoSucursal);

            if(patente.isEmpty() || modelo.isEmpty()){
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }

            if(cboTipo.getSelectedIndex() == 0){
                double kmLitro = Double.parseDouble(txtKmLitro.getText().trim());
                double litrosExtra = Double.parseDouble(txtLitrosExtra.getText().trim());
                VehiculoCombustible v = new VehiculoCombustible(patente, marca, modelo, anio, capacidad, sucursal, kmLitro, litrosExtra);
                Persistencia.guardarVehiculo(v);
            } else {
                double kwhBase = Double.parseDouble(txtKwhBase.getText().trim());
                VehiculoElectrico v = new VehiculoElectrico(patente, marca, modelo, anio, capacidad, sucursal, kwhBase);
                Persistencia.guardarVehiculo(v);
            }

            JOptionPane.showMessageDialog(this, "Vehiculo guardado correctamente");
            txtPatente.setText("");
            txtModelo.setText("");
            txtAnio.setText("");
            txtCapacidad.setText("");
            txtKmLitro.setText("");
            txtLitrosExtra.setText("");
            txtKwhBase.setText("");

        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Ingrese valores numericos validos");
        }
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        menuPadre.setVisible(true);
    }

    private javax.swing.JLabel lblPatente;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JComboBox<String> cboMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JComboBox<String> cboSucursal;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JPanel panelCombustible;
    private javax.swing.JLabel lblKmLitro;
    private javax.swing.JTextField txtKmLitro;
    private javax.swing.JLabel lblLitrosExtra;
    private javax.swing.JTextField txtLitrosExtra;
    private javax.swing.JPanel panelElectrico;
    private javax.swing.JLabel lblKwhBase;
    private javax.swing.JTextField txtKwhBase;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
}
