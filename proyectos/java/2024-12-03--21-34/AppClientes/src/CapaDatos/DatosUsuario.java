/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import CapaEntidad.EntidadUsuario;

public class DatosUsuario {

    private final Connection connection;

    // Constructor que recibe la conexión a la base de datos
    public DatosUsuario(Connection connection) {
        this.connection = connection;
    }

    // Método para insertar un usuario
    public boolean insertarUsuario(EntidadUsuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario (IdUsuario, DNI, ApellidoP, ApellidoM, Nombre, Direccion, Telefono, " +
                     "Correo, Contrasena, IdRol, Estado, FechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getDni());
            stmt.setString(3, usuario.getApellidoP());
            stmt.setString(4, usuario.getApellidoM());
            stmt.setString(5, usuario.getNombre());
            stmt.setString(6, usuario.getDireccion());
            stmt.setString(7, usuario.getTelefono());
            stmt.setString(8, usuario.getCorreo());
            stmt.setString(9, usuario.getContrasena());
            stmt.setString(10, usuario.getIdRol());
            stmt.setBoolean(11, usuario.isEstado());
            stmt.setTimestamp(12, Timestamp.valueOf(usuario.getFechaRegistro()));
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para actualizar un usuario
    public boolean actualizarUsuario(EntidadUsuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET DNI = ?, ApellidoP = ?, ApellidoM = ?, Nombre = ?, Direccion = ?, Telefono = ?, " +
                     "Correo = ?, Contrasena = ?, IdRol = ?, Estado = ?, FechaRegistro = ? WHERE IdUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getDni());
            stmt.setString(2, usuario.getApellidoP());
            stmt.setString(3, usuario.getApellidoM());
            stmt.setString(4, usuario.getNombre());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getTelefono());
            stmt.setString(7, usuario.getCorreo());
            stmt.setString(8, usuario.getContrasena());
            stmt.setString(9, usuario.getIdRol());
            stmt.setBoolean(10, usuario.isEstado());
            stmt.setTimestamp(11, Timestamp.valueOf(usuario.getFechaRegistro()));
            stmt.setString(12, usuario.getIdUsuario());
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para buscar un usuario por ID
    public EntidadUsuario buscarUsuarioPorId(String idUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE IdUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapUsuario(rs);
                }
            }
        }
        return null;
    }

    // Método para eliminar un usuario por ID
    public boolean eliminarUsuario(String idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE IdUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idUsuario);
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para listar todos los usuarios
    public List<EntidadUsuario> listarTodosLosUsuarios() throws SQLException {
        List<EntidadUsuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(mapUsuario(rs));
            }
        }
        return usuarios;
    }

    public EntidadUsuario findByCorreoContrasena(String correo, String contrasena) throws SQLException{
        String sql = "SELECT * FROM Usuario WHERE Correo = ? AND Contrasena = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapUsuario(rs);
                }
            }
        }
        return null;
        
    }
    // Método auxiliar para mapear un ResultSet a un objeto Usuario
    private EntidadUsuario mapUsuario(ResultSet rs) throws SQLException {
        EntidadUsuario usuario = new EntidadUsuario();
        usuario.setIdUsuario(rs.getString("IdUsuario"));
        usuario.setDni(rs.getString("DNI"));
        usuario.setApellidoP(rs.getString("ApellidoP"));
        usuario.setApellidoM(rs.getString("ApellidoM"));
        usuario.setNombre(rs.getString("Nombre"));
        usuario.setDireccion(rs.getString("Direccion"));
        usuario.setTelefono(rs.getString("Telefono"));
        usuario.setCorreo(rs.getString("Correo"));
        usuario.setContrasena(rs.getString("Contrasena"));
        usuario.setIdRol(rs.getString("IdRol"));
        usuario.setEstado(rs.getBoolean("Estado"));
        usuario.setFechaRegistro(rs.getTimestamp("FechaRegistro").toLocalDateTime());
        return usuario;
    }
}
