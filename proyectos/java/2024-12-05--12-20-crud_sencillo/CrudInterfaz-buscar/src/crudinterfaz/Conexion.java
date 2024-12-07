package crudinterfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/crud_db_1733437165";
    private static final String USER = "root"; // Cambia si tienes otro usuario
    private static final String PASS = ""; // Cambia si tienes contraseña
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
