
package segundapracticacrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ANGEL
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/crud_db_1733440606";
    private static final String USER = "root";
    private static final String PASS = "";
    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
