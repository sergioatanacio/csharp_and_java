/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combobox;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    // Crear un nuevo proveedor
    public void agregarProveedor(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO Proveedor (nombre, telefono, email, direccion) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getEmail());
            stmt.setString(4, proveedor.getDireccion());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    proveedor.setIdProveedor(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Obtener todos los proveedores
    public List<Proveedor> obtenerTodosProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEmail(rs.getString("email"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedores.add(proveedor);
            }
        }
        return proveedores;
    }

    // Actualizar un proveedor
    public void actualizarProveedor(Proveedor proveedor) throws SQLException {
        String sql = "UPDATE Proveedor SET nombre = ?, telefono = ?, email = ?, direccion = ? WHERE id_proveedor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getEmail());
            stmt.setString(4, proveedor.getDireccion());
            stmt.setInt(5, proveedor.getIdProveedor());
            stmt.executeUpdate();
        }
    }

    // Eliminar un proveedor
    public void eliminarProveedor(int idProveedor) throws SQLException {
        String sql = "DELETE FROM Proveedor WHERE id_proveedor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idProveedor);
            stmt.executeUpdate();
        }
    }

    // Obtener un proveedor por ID
    public Proveedor obtenerProveedorPorId(int idProveedor) throws SQLException {
        Proveedor proveedor = null;
        String sql = "SELECT * FROM Proveedor WHERE id_proveedor = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idProveedor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    proveedor = new Proveedor();
                    proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                    proveedor.setNombre(rs.getString("nombre"));
                    proveedor.setTelefono(rs.getString("telefono"));
                    proveedor.setEmail(rs.getString("email"));
                    proveedor.setDireccion(rs.getString("direccion"));
                }
            }
        }
        return proveedor;
    }
}
