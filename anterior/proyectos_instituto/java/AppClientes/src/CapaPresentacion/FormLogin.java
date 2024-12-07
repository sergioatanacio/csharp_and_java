package CapaPresentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CapaNegocio.NegocioUsuario;
import java.sql.SQLException;
import CapaEntidad.EntidadRespuesta;
import CapaEntidad.EntidadUsuario;
import CapaNegocio.NegocioAlerta;

/**
 * Formulario de Inicio de Sesión Mejorado
 * 
 * @autor USER
 */
public class FormLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public FormLogin() {
        inicializarComponentes();
        configurarVentana();
        agregarComponentes();
        agregarEventos();
        establecerValoresPorDefecto();
    }

    /**
     * Inicializa los componentes del formulario.
     */
    private void inicializarComponentes() {
        txtUsuario = new JTextField(20);
        txtPassword = new JPasswordField(20);
        btnIngresar = new JButton("Ingresar");
    }

    /**
     * Configura las propiedades de la ventana principal.
     */
    private void configurarVentana() {
        setTitle("Abarrotes Hogar - Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setResizable(false);
    }

    /**
     * Agrega los componentes al formulario utilizando GridBagLayout.
     */
    private void agregarComponentes() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();

        // Título
        JLabel lblTitulo = new JLabel("Abarrotes Hogar");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(34, 139, 34)); // Verde oscuro

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lblTitulo, gbc);

        // Label Usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lblUsuario, gbc);

        // Campo de Usuario
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtUsuario, gbc);

        // Label Contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(lblPassword, gbc);

        // Campo de Contraseña
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtPassword, gbc);

        // Espaciador
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;
        panel.add(Box.createVerticalStrut(10), gbc);

        // Botón Ingresar
        btnIngresar.setBackground(new Color(34, 139, 34));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 50, 10, 50);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(btnIngresar, gbc);

        add(panel);
    }

    /**
     * Agrega los eventos a los componentes.
     */
    private void agregarEventos() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intentarInicioSesion();
            }
        });
    }

    /**
     * Establece valores por defecto en los campos de texto.
     */
    private void establecerValoresPorDefecto() {
        txtUsuario.setText("juan.gomez@email.com");
        txtPassword.setText("contrasena123");
    }

    /**
     * Maneja el intento de inicio de sesión.
     */
    private void intentarInicioSesion() {
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        // Validación básica
        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            NegocioUsuario negocioUsuario = new NegocioUsuario();
            EntidadRespuesta resultado = negocioUsuario.iniciarSesion(usuario, password);

            if (resultado.isSuccess()) {
                EntidadUsuario usuarioDevuelto = (EntidadUsuario) resultado.getDatos().get(0);
                FormModulos formulario = new FormModulos(usuarioDevuelto);
                formulario.setVisible(true);
                this.dispose();
            } else {
                NegocioAlerta.mostrar(resultado.getMensaje());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            // Opcional: Log del error
            // Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método principal para ejecutar el formulario.
     */
    public static void main(String[] args) {
        // Establecer el look and feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            // Manejar excepciones si es necesario
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }
}
