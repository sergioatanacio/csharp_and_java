package CapaDatos;

import CapaEntidad.EntidadCategoriaProducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import CapaEntidad.EntidadProducto;
import CapaEntidad.EntidadUsuario;


public class DatosProducto  implements Datos<EntidadProducto, EntidadUsuario, ResultSet> {

    private final Connection connection;

    // Constructor que recibe una conexión a la base de datos
    public DatosProducto(Connection connection) {
        this.connection = connection;
    }

    // Método para insertar un producto
    @Override
    public boolean insertar(EntidadProducto producto) {
        String sql = "INSERT INTO Producto (IdProducto, CodigoBarras, NombreProducto, Descripcion, IdCategoria, UnidadMedida, " +
                     "PrecioCompra, PrecioVenta, Marca, Modelo, Stock, FechaVencimiento, IdProveedor, IdUbicacion, Imagen, Estado, FechaRegistro) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, producto.getId());
            stmt.setString(2, producto.getCodigoBarras());
            stmt.setString(3, producto.getNombreProducto());
            stmt.setString(4, producto.getDescripcion());
            stmt.setString(5, producto.getIdCategoria());
            stmt.setString(6, producto.getUnidadMedida());
            stmt.setBigDecimal(7, producto.getPrecioCompra());
            stmt.setBigDecimal(8, producto.getPrecioVenta());
            stmt.setString(9, producto.getMarca());
            stmt.setString(10, producto.getModelo());
            stmt.setInt(11, producto.getStock());
            stmt.setDate(12, producto.getFechaVencimiento() != null ? Date.valueOf(producto.getFechaVencimiento()) : null);
            stmt.setString(13, producto.getIdProveedor());
            stmt.setString(14, producto.getIdUbicacion());
            stmt.setString(15, producto.getImagen());
            stmt.setBoolean(16, producto.isEstado());
            stmt.setTimestamp(17, Timestamp.valueOf(producto.getFechaRegistro()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al insertar el producto: " + e.getMessage());
            e.printStackTrace(); // Opcional: para depuración
            return false;
        }
    }


    // Método para actualizar un producto
    public boolean actualizar(EntidadProducto producto) {
        String sql = "UPDATE Producto SET CodigoBarras = ?, NombreProducto = ?, Descripcion = ?, IdCategoria = ?, UnidadMedida = ?, " +
                     "PrecioCompra = ?, PrecioVenta = ?, Marca = ?, Modelo = ?, Stock = ?, FechaVencimiento = ?, IdProveedor = ?, " +
                     "IdUbicacion = ?, Imagen = ?, Estado = ?, FechaRegistro = ? WHERE IdProducto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getCodigoBarras());
            stmt.setString(2, producto.getNombreProducto());
            stmt.setString(3, producto.getDescripcion());
            stmt.setString(4, producto.getIdCategoria());
            stmt.setString(5, producto.getUnidadMedida());
            stmt.setBigDecimal(6, producto.getPrecioCompra());
            stmt.setBigDecimal(7, producto.getPrecioVenta());
            stmt.setString(8, producto.getMarca());
            stmt.setString(9, producto.getModelo());
            stmt.setInt(10, producto.getStock());
            stmt.setDate(11, producto.getFechaVencimiento() != null ? Date.valueOf(producto.getFechaVencimiento()) : null);
            stmt.setString(12, producto.getIdProveedor());
            stmt.setString(13, producto.getIdUbicacion());
            stmt.setString(14, producto.getImagen());
            stmt.setBoolean(15, producto.isEstado());
            stmt.setTimestamp(16, Timestamp.valueOf(producto.getFechaRegistro()));
            stmt.setInt(17, producto.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al actualizar el producto: " + e.getMessage());
            e.printStackTrace(); // Opcional: para depuración
            return false;
        }
    }



    // Método para buscar un producto por ID

    /**
     *
     * @param idProducto
     * @return
     */
    public EntidadProducto buscarPorId(int idProducto) {
        String sql = "SELECT * FROM Producto WHERE IdProducto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapProducto(rs);
                }
            }
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al buscar el producto por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    // Método para eliminar un producto por ID
    public boolean eliminar(EntidadProducto arg) {
        String sql = "DELETE FROM Producto WHERE IdProducto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, arg.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al eliminar el producto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }



    // Método para listar todos los productos
    @Override
    public List<EntidadProducto> listar(EntidadUsuario arg) {
        List<EntidadProducto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                productos.add(mapProducto(rs));
            }
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al listar todos los productos: " + e.getMessage());
            e.printStackTrace();
        }
        return productos;
    }


    // Método auxiliar para mapear un ResultSet a un objeto Producto
    private EntidadProducto mapProducto(ResultSet rs) {
        try {
            EntidadProducto producto = new EntidadProducto();
            producto.setId(rs.getInt("IdProducto"));
            producto.setCodigoBarras(rs.getString("CodigoBarras"));
            producto.setNombreProducto(rs.getString("NombreProducto"));
            producto.setDescripcion(rs.getString("Descripcion"));
            producto.setIdCategoria(rs.getString("IdCategoria"));
            producto.setUnidadMedida(rs.getString("UnidadMedida"));
            producto.setPrecioCompra(rs.getBigDecimal("PrecioCompra"));
            producto.setPrecioVenta(rs.getBigDecimal("PrecioVenta"));
            producto.setMarca(rs.getString("Marca"));
            producto.setModelo(rs.getString("Modelo"));
            producto.setStock(rs.getInt("Stock"));
            producto.setFechaVencimiento(rs.getDate("FechaVencimiento") != null ? rs.getDate("FechaVencimiento").toLocalDate() : null);
            producto.setIdProveedor(rs.getString("IdProveedor"));
            producto.setIdUbicacion(rs.getString("IdUbicacion"));
            producto.setImagen(rs.getString("Imagen"));
            producto.setEstado(rs.getBoolean("Estado"));
            producto.setFechaRegistro(rs.getTimestamp("FechaRegistro").toLocalDateTime());
            return producto;
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al mapear el producto: " + e.getMessage());
            e.printStackTrace(); // Opcional: para depuración
            return null;
        }
    }
    @Override
    public EntidadProducto map(ResultSet arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
