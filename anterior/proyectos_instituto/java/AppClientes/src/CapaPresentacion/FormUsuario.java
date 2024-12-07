package CapaPresentacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FormUsuario extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public FormUsuario() {
        setTitle("Lista de Usuarios");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("IdUsuario");
        tableModel.addColumn("DNI");
        tableModel.addColumn("ApellidoP");
        tableModel.addColumn("ApellidoM");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Direccion");
        tableModel.addColumn("Telefono");
        tableModel.addColumn("Correo");
        tableModel.addColumn("IdRol");
        tableModel.addColumn("Estado");
        tableModel.addColumn("FechaRegistro");

        // Crear la tabla con el modelo
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Cargar datos desde la base de datos
        cargarDatos();

        // Agregar el scrollPane al frame
        add(scrollPane, BorderLayout.CENTER);
    }

    private void cargarDatos() {
        String url = "jdbc:mysql://searchdominio.online:3306/searchdo_gio"; // Cambia "tu_basedatos" por el nombre real de tu BD
        String usuario = "searchdo_searchdo"; // Cambia por tu usuario de MySQL
        String contrasena = "searchdo_searchdo"; // Cambia por tu contraseña de MySQL

        try (Connection connection = DriverManager.getConnection(url, usuario, contrasena);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Usuario")) {

            while (resultSet.next()) {
                Object[] fila = new Object[11]; // Número de columnas en la tabla Usuario
                fila[0] = resultSet.getString("IdUsuario");
                fila[1] = resultSet.getString("DNI");
                fila[2] = resultSet.getString("ApellidoP");
                fila[3] = resultSet.getString("ApellidoM");
                fila[4] = resultSet.getString("Nombre");
                fila[5] = resultSet.getString("Direccion");
                fila[6] = resultSet.getString("Telefono");
                fila[7] = resultSet.getString("Correo");
                fila[8] = resultSet.getString("IdRol");
                fila[9] = resultSet.getInt("Estado");
                fila[10] = resultSet.getTimestamp("FechaRegistro");
                tableModel.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormUsuario frame = new FormUsuario();
            frame.setVisible(true);
        });
    }
}
