/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combobox;

/**
 *
 * @author ANGEL
 */



import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private ProveedorDAO proveedorDAO = new ProveedorDAO();

    // Crear un nuevo producto
    public void agregarProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO Producto (nombre, descripcion, precio, stock, id_proveedor) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setBigDecimal(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            stmt.setInt(5, producto.getProveedor().getIdProveedor());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    producto.setIdProducto(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodosProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getBigDecimal("precio"));
                producto.setStock(rs.getInt("stock"));
                
                int idProveedor = rs.getInt("id_proveedor");
                Proveedor proveedor = proveedorDAO.obtenerProveedorPorId(idProveedor);
                producto.setProveedor(proveedor);
                
                productos.add(producto);
            }
        }
        return productos;
    }

    // Actualizar un producto
    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE Producto SET nombre = ?, descripcion = ?, precio = ?, stock = ?, id_proveedor = ? WHERE id_producto = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setBigDecimal(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            stmt.setInt(5, producto.getProveedor().getIdProveedor());
            stmt.setInt(6, producto.getIdProducto());
            stmt.executeUpdate();
        }
    }

    // Eliminar un producto
    public void eliminarProducto(int idProducto) throws SQLException {
        String sql = "DELETE FROM Producto WHERE id_producto = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idProducto);
            stmt.executeUpdate();
        }
    }

    // Obtener un producto por ID
    public Producto obtenerProductoPorId(int idProducto) throws SQLException {
        Producto producto = null;
        String sql = "SELECT * FROM Producto WHERE id_producto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idProducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getBigDecimal("precio"));
                    producto.setStock(rs.getInt("stock"));
                    
                    int idProveedor = rs.getInt("id_proveedor");
                    Proveedor proveedor = proveedorDAO.obtenerProveedorPorId(idProveedor);
                    producto.setProveedor(proveedor);
                }
            }
        }
        return producto;
    }
}
