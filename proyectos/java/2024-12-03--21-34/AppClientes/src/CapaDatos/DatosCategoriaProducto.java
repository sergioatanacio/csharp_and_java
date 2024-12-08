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
import CapaEntidad.EntidadUsuario;
import java.lang.System.Logger;




public class DatosCategoriaProducto implements Datos<EntidadCategoriaProducto, EntidadUsuario, ResultSet> {

    public Connection connection;
    public EntidadUsuario e_usuario;

    // Constructor que recibe la conexión a la base de datos
    public DatosCategoriaProducto(Connection connection, EntidadUsuario parametro_usuario) {
        this.connection = connection;
        this.e_usuario = parametro_usuario;
    }
    




    @Override
    public boolean insertar(EntidadCategoriaProducto arg) {
        String sql = "INSERT INTO Categoria (IdCategoria, Descripcion, Estado, FechaRegistro) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, arg.getId());
            stmt.setString(2, arg.getDescripcion());
            stmt.setBoolean(3, arg.isEstado());
            stmt.setTimestamp(4, Timestamp.valueOf(arg.getFechaRegistro()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace(); // Puedes reemplazar esto con un logger o una acción más adecuada
            
        }
        return false;
    }
    
    @Override
    public boolean actualizar(EntidadCategoriaProducto arg) {
    // Método para actualizar una categoría
    
        String sql = "UPDATE Categoria SET Descripcion = ?, Estado = ?, FechaRegistro = ? WHERE IdCategoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, arg.getDescripcion());
            stmt.setBoolean(2, arg.isEstado());
            stmt.setTimestamp(3, Timestamp.valueOf(arg.getFechaRegistro()));
            stmt.setInt(4, arg.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace(); // Puedes reemplazar esto con un logger o una acción más adecuada
            
        }
        return false;
    
    }
    
    @Override
    public boolean eliminar(EntidadCategoriaProducto arg) {
        String sql = "DELETE FROM Categoria WHERE IdCategoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, arg.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al eliminar la categoría con ID: " + arg.getId());
            System.err.println("Mensaje de error: " + e.getMessage());
            e.printStackTrace(); // Registra el error para depuración
            return false; // Devuelve false si ocurre un error
        }
    }
    
    @Override
    public EntidadCategoriaProducto buscarPorId(int id) {
        String sql = "SELECT * FROM Categoria WHERE IdCategoria = ? AND estado = 1;";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                } else {
                    System.out.println("No se encontró ninguna categoría con ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la categoría con ID: " + id);
            e.printStackTrace(); // Imprime el detalle del error en la consola
            throw new RuntimeException("Error al acceder a la base de datos para obtener la categoría.", e);
        }

        return null;    
    }


    
    @Override
    public List<EntidadCategoriaProducto> listar(EntidadUsuario arg) {
        List<EntidadCategoriaProducto> categorias = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categorias.add(map(rs));
            }

        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace(); // Puedes reemplazar esto con un logger o una acción más adecuada
            return null; // Retorna null en caso de error
        }

        // Retorna null si la lista está vacía
        return categorias.isEmpty() ? null : categorias;
        
    }

    public EntidadCategoriaProducto map(ResultSet arg) {
        try {
            EntidadCategoriaProducto categoria = new EntidadCategoriaProducto();
            categoria.setId(arg.getInt("IdCategoria"));
            categoria.setNombre(arg.getString("Nombre"));
            categoria.setDescripcion(arg.getString("Descripcion"));
            categoria.setEstado(arg.getBoolean("Estado"));
            categoria.setFechaRegistro(arg.getString("FechaRegistro"));
            // categoria.setFechaRegistro(rs.getTimestamp("FechaRegistro").toLocalDateTime());
            return categoria;
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al mapear la categoría: " + e.getMessage());
            e.printStackTrace(); // O puedes registrar el error en un logger
            return null; // O lanza una excepción personalizada si es necesario
        }
    }



}














// Método para buscar una categoría por ID
//    public EntidadCategoriaProducto buscarCategoriaSActivas() throws SQLException {
//        String sql = "SELECT * FROM Categoria WHERE estado = 1;";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    return (EntidadCategoriaProducto) map(rs);
//                }
//            }
//        }
//        return null;
//    }
//
//