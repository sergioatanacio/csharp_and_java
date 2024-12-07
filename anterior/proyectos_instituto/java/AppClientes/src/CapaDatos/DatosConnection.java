package CapaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatosConnection {

    // Parámetros de conexión
    private static final String URL = "jdbc:mysql://searchdominio.online:3306/searchdo_gio";
    private static final String USUARIO = "searchdo_searchdo";
    private static final String CONTRASENA = "searchdo_searchdo";

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el driver JDBC (opcional en Java moderno si usas un driver actual)
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el driver de MySQL", e);
        }
    }
}
