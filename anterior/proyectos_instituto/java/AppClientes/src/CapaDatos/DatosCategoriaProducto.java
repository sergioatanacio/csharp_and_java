/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import CapaEntidad.EntidadCategoriaProducto;
// import CapaEntidad.EntidadUsuario;

public class DatosCategoriaProducto {

    private final Connection connection;
    // private EntidadUsuario e_usuario;

    // Constructor que recibe la conexión a la base de datos
    public DatosCategoriaProducto(Connection connection/*, EntidadUsuario parametro_usuario*/) {
        this.connection = connection;
        // this.e_usuario = parametro_usuario;
    }

    // Método para insertar una categoría
    public boolean insertarCategoria(EntidadCategoriaProducto categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (IdCategoria, Descripcion, Estado, FechaRegistro) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getIdCategoria());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setBoolean(3, categoria.isEstado());
            stmt.setTimestamp(4, Timestamp.valueOf(categoria.getFechaRegistro()));
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para actualizar una categoría
    public boolean actualizarCategoria(EntidadCategoriaProducto categoria) throws SQLException {
        String sql = "UPDATE Categoria SET Descripcion = ?, Estado = ?, FechaRegistro = ? WHERE IdCategoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getDescripcion());
            stmt.setBoolean(2, categoria.isEstado());
            stmt.setTimestamp(3, Timestamp.valueOf(categoria.getFechaRegistro()));
            stmt.setString(4, categoria.getIdCategoria());
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para buscar una categoría por ID
    public EntidadCategoriaProducto buscarCategoriaPorId(String idCategoria) throws SQLException {
        String sql = "SELECT * FROM Categoria WHERE IdCategoria = ? AND estado = 1;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idCategoria);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapCategoria(rs);
                }
            }
        }
        return null;
    }
    
        // Método para buscar una categoría por ID
    public EntidadCategoriaProducto buscarCategoriaSActivas() throws SQLException {
        String sql = "SELECT * FROM Categoria WHERE estado = 1;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapCategoria(rs);
                }
            }
        }
        return null;
    }

    // Método para eliminar una categoría por ID
    public boolean eliminarCategoria(EntidadCategoriaProducto ECategoria) throws SQLException {
        String sql = "DELETE FROM Categoria WHERE IdCategoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ECategoria.getIdCategoria());
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para listar todas las categorías
    public List<EntidadCategoriaProducto> listarTodasLasCategorias() throws SQLException {
        List<EntidadCategoriaProducto> categorias = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                categorias.add(mapCategoria(rs));
            }
        }
        return categorias;
    }

    // Método auxiliar para mapear un ResultSet a un objeto Categoría
    private EntidadCategoriaProducto mapCategoria(ResultSet rs) throws SQLException {
        EntidadCategoriaProducto categoria = new EntidadCategoriaProducto();
        categoria.setIdCategoria(rs.getString("IdCategoria"));
        categoria.setDescripcion(rs.getString("Descripcion"));
        categoria.setEstado(rs.getBoolean("Estado"));
        categoria.setFechaRegistro(rs.getString("FechaRegistro"));
        // categoria.setFechaRegistro(rs.getTimestamp("FechaRegistro").toLocalDateTime());
        return categoria;
    }
}
