package CapaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosConnection {

    // Parámetros de conexión
    private static final String URL = "jdbc:mysql://searchdominio.online:3306/searchdo_gio";
    private static final String USUARIO = "searchdo_searchdo_searchdo";
    private static final String CONTRASENA = "searchdo_searchdo_searchdo";

    // Logger para registrar errores
    private static final Logger LOGGER = Logger.getLogger(DatosConnection.class.getName());

    // Método para obtener la conexión
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Registrar el driver JDBC (opcional en Java moderno si usas un driver actual)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException e) {
            // Manejo de la excepción cuando el driver no se encuentra
            LOGGER.log(Level.SEVERE, "Error al cargar el driver de MySQL", e);
            // Opcional: Puedes lanzar una RuntimeException si consideras que la aplicación no puede continuar
            // throw new RuntimeException("Driver de MySQL no encontrado.", e);
        } catch (SQLException e) {
            // Manejo de la excepción de SQL
            LOGGER.log(Level.SEVERE, "Error al establecer la conexión con la base de datos", e);
            // Opcional: Puedes lanzar una RuntimeException si consideras que la aplicación no puede continuar
            // throw new RuntimeException("No se pudo establecer la conexión con la base de datos.", e);
        }
        return connection;
    }
}
