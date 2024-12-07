package CapaPresentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import CapaEntidad.EntidadUsuario;

/**
 * Clase principal que representa el formulario de módulos.
 * Permite navegar entre diferentes secciones de la aplicación.
 * 
 * @author 
 */
public class FormModulos extends JFrame {
    private EntidadUsuario usuarioActual;

    // Componentes de la interfaz
    private JLabel lblSaludo;
    private JLabel lblNombreUsuario;
    private JButton btnIngresarProductos;
    private JButton btnGenerarComprobante;
    private JButton btnAgendarMensajes;
    private JButton btnIngresarClientes;
    private JButton btnVentas;
    private JButton btnGestionInventario;
    private JButton btnAgregarUsuarios;
    private JButton btnVerUsuarios;
    private JButton btnCategoriaProducto;

    /**
     * Constructor por defecto.
     */
    public FormModulos() {
        this(null);
    }

    /**
     * Constructor que recibe un objeto EntidadUsuario.
     * 
     * @param usuario Objeto que representa al usuario actual.
     */
    public FormModulos(EntidadUsuario usuario) {
        this.usuarioActual = usuario;
        inicializarComponentes();
        configurarVentana();
        actualizarNombreUsuario();
    }

    /**
     * Inicializa y configura los componentes de la interfaz.
     */
    private void inicializarComponentes() {
        // Inicialización de etiquetas
        lblSaludo = new JLabel("Hola:");
        lblNombreUsuario = new JLabel("-");

        // Inicialización de botones con nombres descriptivos
        btnIngresarProductos = new JButton("Ingresar Productos");
        btnGenerarComprobante = new JButton("Generar Comprobante");
        btnAgendarMensajes = new JButton("Agendar Mensajes");
        btnIngresarClientes = new JButton("Ingresar Clientes");
        btnVentas = new JButton("Ventas");
        btnGestionInventario = new JButton("Gestión de Inventario");
        btnAgregarUsuarios = new JButton("Agregar Usuarios");
        btnVerUsuarios = new JButton("Ver Usuarios");
        btnCategoriaProducto = new JButton("Categoría Producto");

        // Asignación de listeners a los botones
        btnIngresarProductos.addActionListener(this::abrirFormularioIngresarProductos);
        btnGenerarComprobante.addActionListener(this::abrirFormularioGenerarComprobante);
        btnAgendarMensajes.addActionListener(this::abrirFormularioAgendarMensajes);
        btnIngresarClientes.addActionListener(this::abrirFormularioIngresarClientes);
        btnVentas.addActionListener(this::abrirFormularioVentas);
        btnGestionInventario.addActionListener(this::abrirFormularioGestionInventario);
        btnAgregarUsuarios.addActionListener(this::abrirFormularioAgregarUsuarios);
        btnVerUsuarios.addActionListener(this::abrirFormularioVerUsuarios);
        btnCategoriaProducto.addActionListener(this::mostrarCategoriaProducto);

        // Configuración del layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir componentes al layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblSaludo, gbc);

        gbc.gridx = 1;
        add(lblNombreUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnCategoriaProducto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnIngresarProductos, gbc);

        gbc.gridx = 1;
        add(btnIngresarClientes, gbc);

        gbc.gridx = 2;
        add(btnVentas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnAgendarMensajes, gbc);

        gbc.gridx = 1;
        add(btnGenerarComprobante, gbc);

        gbc.gridx = 2;
        add(btnGestionInventario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnAgregarUsuarios, gbc);

        gbc.gridx = 1;
        add(btnVerUsuarios, gbc);
    }

    /**
     * Configura las propiedades básicas de la ventana.
     */
    private void configurarVentana() {
        setTitle("Módulos de la Aplicación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    /**
     * Actualiza la etiqueta con el nombre completo del usuario.
     */
    private void actualizarNombreUsuario() {
        if (usuarioActual != null) {
            String nombreCompleto = String.format("%s %s %s",
                    usuarioActual.getNombre(),
                    usuarioActual.getApellidoP(),
                    usuarioActual.getApellidoM());
            lblNombreUsuario.setText(nombreCompleto);
        }
    }

    // Métodos para manejar eventos de los botones

    private void abrirFormularioIngresarProductos(ActionEvent evt) {
        FormPrimeroForm formulario = new FormPrimeroForm();
        formulario.setVisible(true);
        // this.setVisible(false);
    }

    private void abrirFormularioGenerarComprobante(ActionEvent evt) {
        FormComprobantes formulario = new FormComprobantes();
        formulario.setVisible(true);
    }

    private void abrirFormularioAgendarMensajes(ActionEvent evt) {
        FormMensajes formulario = new FormMensajes();
        formulario.setVisible(true);
    }

    private void abrirFormularioIngresarClientes(ActionEvent evt) {
        FormIngresarClientes formulario = new FormIngresarClientes();
        formulario.setVisible(true);
    }

    private void abrirFormularioVentas(ActionEvent evt) {
        FormVentas formulario = new FormVentas();
        formulario.setVisible(true);
    }

    private void abrirFormularioGestionInventario(ActionEvent evt) {
        FormGestionInventario formulario = new FormGestionInventario();
        formulario.setVisible(true);
    }

    private void abrirFormularioAgregarUsuarios(ActionEvent evt) {
        FormAgregarUsuario formulario = new FormAgregarUsuario();
        formulario.setVisible(true);
    }

    private void abrirFormularioVerUsuarios(ActionEvent evt) {
        FormUsuario formulario = new FormUsuario();
        formulario.setVisible(true);
    }

    private void mostrarCategoriaProducto(ActionEvent evt) {
        FormCategoria formulario = new FormCategoria();
        formulario.setVisible(true);
        // JOptionPane.showMessageDialog(this, 
        //         "Diste click a Categoría Producto", 
        //         "Información", 
        //         JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método principal para ejecutar la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Establecer el tema de la interfaz (opcional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Crear y mostrar el formulario en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            FormModulos formulario = new FormModulos();
            formulario.setVisible(true);
        });
    }
}
