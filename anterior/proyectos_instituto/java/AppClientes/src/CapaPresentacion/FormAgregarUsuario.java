package CapaPresentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FormAgregarUsuario extends JFrame {

    private JTextField txtIdUsuario, txtDNI, txtApellidoP, txtApellidoM, txtNombre, txtDireccion, txtTelefono, txtCorreo, txtIdRol;
    private JPasswordField txtContrasena;
    private JCheckBox chkEstado;
    private JButton btnGuardar;

    public FormAgregarUsuario() {
        setTitle("Agregar Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(12, 2, 5, 5));

        // Crear y agregar componentes
        add(new JLabel("ID Usuario:"));
        txtIdUsuario = new JTextField();
        add(txtIdUsuario);

        add(new JLabel("DNI:"));
        txtDNI = new JTextField();
        add(txtDNI);

        add(new JLabel("Apellido Paterno:"));
        txtApellidoP = new JTextField();
        add(txtApellidoP);

        add(new JLabel("Apellido Materno:"));
        txtApellidoM = new JTextField();
        add(txtApellidoM);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        add(txtCorreo);

        add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField();
        add(txtContrasena);

        add(new JLabel("ID Rol:"));
        txtIdRol = new JTextField();
        add(txtIdRol);

        add(new JLabel("Estado:"));
        chkEstado = new JCheckBox("Activo");
        chkEstado.setSelected(true);
        add(chkEstado);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }
        });
        add(btnGuardar);

        setLocationRelativeTo(null); // Centrar el formulario en la pantalla
    }

    private void guardarUsuario() {
        String url = "jdbc:mysql://searchdominio.online:3306/searchdo_gio"; // Cambia "tu_basedatos" por el nombre real de tu BD
        String usuario = "searchdo_searchdo"; // Cambia por tu usuario de MySQL
        String contrasenaBD = "searchdo_searchdo"; // Cambia por tu contraseña de MySQL

        String sql = "INSERT INTO Usuario (IdUsuario, DNI, ApellidoP, ApellidoM, Nombre, Direccion, Telefono, Correo, Contrasena, IdRol, Estado) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, usuario, contrasenaBD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, txtIdUsuario.getText());
            statement.setString(2, txtDNI.getText());
            statement.setString(3, txtApellidoP.getText());
            statement.setString(4, txtApellidoM.getText().isEmpty() ? null : txtApellidoM.getText());
            statement.setString(5, txtNombre.getText());
            statement.setString(6, txtDireccion.getText().isEmpty() ? null : txtDireccion.getText());
            statement.setString(7, txtTelefono.getText().isEmpty() ? null : txtTelefono.getText());
            statement.setString(8, txtCorreo.getText());
            statement.setString(9, new String(txtContrasena.getPassword())); // Convertir contraseña a String
            statement.setString(10, txtIdRol.getText());
            statement.setInt(11, chkEstado.isSelected() ? 1 : 0);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Usuario guardado correctamente.");
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        txtIdUsuario.setText("");
        txtDNI.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtContrasena.setText("");
        txtIdRol.setText("");
        chkEstado.setSelected(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormAgregarUsuario frame = new FormAgregarUsuario();
            frame.setVisible(true);
        });
    }
}
