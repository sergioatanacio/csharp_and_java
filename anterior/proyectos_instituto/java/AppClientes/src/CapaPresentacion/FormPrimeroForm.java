package CapaPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Formulario principal para la gestión de productos.
 * Agrupa botones, tabla, buscador y campos de inserción en paneles separados con bordes.
 * 
 * @autor Usuario
 */
public class FormPrimeroForm extends JFrame {

    // Paneles principales
    private JPanel panelBusqueda;
    private JPanel panelInputs;
    private JPanel panelBotones;
    private JPanel panelTabla;

    // Componentes de Buscador
    private JLabel lblBuscar;
    private JTextField txtBuscar;

    // Componentes de Inserción
    private JLabel lblNombreProducto;
    private JTextField txtNombreProducto;
    private JLabel lblMedida;
    private JTextField txtMedida;
    private JLabel lblCantidad;
    private JTextField txtCantidad;

    // Componentes de Botones
    private JButton btnCrear;
    private JButton btnModificar;
    private JButton btnNuevo;
    private JButton btnEliminar;

    // Componentes de Tabla
    private JTable tblProductos;
    private JScrollPane scrollTabla;

    /**
     * Constructor del formulario.
     */
    public FormPrimeroForm() {
        initComponents();
    }

    /**
     * Inicializa y configura los componentes del formulario.
     */
    private void initComponents() {
        // Configuración del JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Productos");
        setSize(900, 600);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout(10, 10));

        // ========================================
        // Configuración del Panel de Buscador
        // ========================================
        panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Buscar",
                TitledBorder.LEFT, TitledBorder.TOP));

        lblBuscar = new JLabel("Buscar:");
        txtBuscar = new JTextField(20);

        panelBusqueda.add(lblBuscar);
        panelBusqueda.add(txtBuscar);

        // ========================================
        // Configuración del Panel de Inserción
        // ========================================
        panelInputs = new JPanel();
        panelInputs.setLayout(new GridBagLayout());
        panelInputs.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Insertar Producto",
                TitledBorder.LEFT, TitledBorder.TOP));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Nombre Producto
        gbc.gridx = 0;
        gbc.gridy = 0;
        lblNombreProducto = new JLabel("Nombre Producto:");
        panelInputs.add(lblNombreProducto, gbc);

        gbc.gridx = 1;
        txtNombreProducto = new JTextField(15);
        panelInputs.add(txtNombreProducto, gbc);

        // Medida
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblMedida = new JLabel("Medida:");
        panelInputs.add(lblMedida, gbc);

        gbc.gridx = 1;
        txtMedida = new JTextField(15);
        panelInputs.add(txtMedida, gbc);

        // Cantidad
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblCantidad = new JLabel("Cantidad:");
        panelInputs.add(lblCantidad, gbc);

        gbc.gridx = 1;
        txtCantidad = new JTextField(15);
        panelInputs.add(txtCantidad, gbc);

        // ========================================
        // Configuración del Panel de Botones
        // ========================================
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Acciones",
                TitledBorder.LEFT, TitledBorder.TOP));

        btnCrear = new JButton("Crear");
        btnModificar = new JButton("Modificar");
        btnNuevo = new JButton("Nuevo");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnCrear);
        panelBotones.add(btnModificar);
        panelBotones.add(btnNuevo);
        panelBotones.add(btnEliminar);

        // ========================================
        // Configuración del Panel de Tabla
        // ========================================
        panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Lista de Productos",
                TitledBorder.LEFT, TitledBorder.TOP));

        tblProductos = new JTable();
        tblProductos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre Producto", "Medida", "Cantidad"}
        ));
        scrollTabla = new JScrollPane(tblProductos);
        panelTabla.add(scrollTabla, BorderLayout.CENTER);

        // ========================================
        // Organización de los Paneles
        // ========================================
        // Panel Izquierdo (Buscador y Inputs)
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout(10, 10));
        panelIzquierdo.add(panelBusqueda, BorderLayout.NORTH);
        panelIzquierdo.add(panelInputs, BorderLayout.CENTER);

        // Panel Principal (Izquierdo y Botones)
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.add(panelIzquierdo, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.EAST);

        // Añadir al JFrame
        add(panelPrincipal, BorderLayout.NORTH);
        add(panelTabla, BorderLayout.CENTER);

        // Empaquetar componentes
        pack();
    }

    /**
     * Método principal para ejecutar el formulario.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Establecer el look and feel de Nimbus si está disponible
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Si Nimbus no está disponible, se usará el look and feel predeterminado
            ex.printStackTrace();
        }

        // Crear y mostrar el formulario
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPrimeroForm().setVisible(true);
            }
        });
    }
}
