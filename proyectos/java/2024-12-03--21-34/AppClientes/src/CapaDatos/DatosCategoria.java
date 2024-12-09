/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import CapaEntidad.EntidadCategoria;
import CapaEntidad.EntidadUsuario;
import java.lang.System.Logger;




public class DatosCategoria implements Datos<EntidadCategoria, EntidadUsuario, ResultSet> {

    public Connection connection;
    public EntidadUsuario e_usuario;

    // Constructor que recibe la conexión a la base de datos
    public DatosCategoria(Connection connection, EntidadUsuario parametro_usuario) {
        this.connection = connection;
        this.e_usuario = parametro_usuario;
    }
    
    
    
    @Override
    public boolean insertar(EntidadCategoria arg) {
        String sql = "INSERT INTO Categoria (Nombre, Descripcion, Estado) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, arg.getNombre());
            stmt.setString(2, arg.getDescripcion());
            stmt.setBoolean(3, arg.isEstado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace(); // Puedes reemplazar esto con un logger o una acción más adecuada
        }
        return false;
    }

    
    
    
    
    
    @Override
//    public boolean actualizar(EntidadCategoria arg) {
//    // Método para actualizar una categoría
//    
//        String sql = "UPDATE Categoria SET Descripcion = ?, Estado = ?, FechaRegistro = ? WHERE IdCategoria = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, arg.getDescripcion());
//            stmt.setBoolean(2, arg.isEstado());
//            stmt.setString(3, arg.getFechaRegistro());
//            stmt.setInt(4, arg.getId());
//            return stmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            // Manejo de la excepción
//            e.printStackTrace(); // Puedes reemplazar esto con un logger o una acción más adecuada
//            
//        }
//        return false;
//    
//    }
    public boolean actualizar(EntidadCategoria arg) {
        // Método para actualizar una categoría
        String sql = "UPDATE Categoria SET Descripcion = ?, Estado = ?, FechaRegistro = ?, Nombre = ? WHERE IdCategoria = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Depuración: Imprimir el SQL y los valores antes de ejecutarlo
            System.out.println("SQL: " + sql);
            System.out.println("Parámetros:");
            System.out.println("Descripcion: " + arg.getDescripcion());
            System.out.println("Estado: " + arg.isEstado());
            System.out.println("FechaRegistro: " + arg.getFechaRegistro());
            System.out.println("IdCategoria: " + arg.getId());
            System.out.println("Nombre: " + arg.getId());

            stmt.setString(1, arg.getDescripcion());
            stmt.setBoolean(2, arg.isEstado());
            stmt.setString(3, arg.getFechaRegistro());
            stmt.setString(4, arg.getNombre());
            stmt.setInt(5, arg.getId());

            int rowsAffected = stmt.executeUpdate();

            // Depuración: Imprimir el resultado de la ejecución
            System.out.println("Filas afectadas: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            // Manejo de la excepción
            System.err.println("Error al ejecutar la consulta SQL:");
            e.printStackTrace(); // Puedes reemplazar esto con un logger si lo prefieres
        }
        return false;
    }

    @Override
    public boolean eliminar(EntidadCategoria arg) {
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
    public EntidadCategoria buscarPorId(int id) {
        String sql = "SELECT * FROM Categoria WHERE IdCategoria = ? ";

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
    public List<EntidadCategoria> listar(EntidadUsuario arg) {
        List<EntidadCategoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM Categoria;";

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

    public EntidadCategoria map(ResultSet arg) {
        try {
            EntidadCategoria categoria = new EntidadCategoria();
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