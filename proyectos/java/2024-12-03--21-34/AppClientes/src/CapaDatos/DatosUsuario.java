package CapaDatos;

import CapaEntidad.EntidadUsuario;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Implementar la interfaz Datos con los tipos genéricos mapeados
public class DatosUsuario implements Datos<EntidadUsuario, EntidadUsuario, ResultSet> {

    private final Connection connection;
    private static final Logger LOGGER = Logger.getLogger(DatosUsuario.class.getName());

        
    // Constructor que recibe la conexión a la base de datos
    public DatosUsuario(Connection connection) {
        this.connection = connection;
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param usuario El usuario a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    @Override
    public boolean insertar(EntidadUsuario usuario) {
        String sql = "INSERT INTO Usuario (IdUsuario, DNI, ApellidoP, ApellidoM, Nombre, Direccion, Telefono, " +
                     "Correo, Contrasena, IdRol, Estado, FechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
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
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al insertar usuario: " + usuario, e);
            return false;
        }
    }

    /**
     * Actualiza la información de un usuario existente en la base de datos.
     * @param usuario El usuario con la información actualizada.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    @Override
    public boolean actualizar(EntidadUsuario usuario) {
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
            stmt.setInt(12, usuario.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al actualizar usuario: " + usuario, e);
            return false;
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     * @param usuario El usuario a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    @Override
    public boolean eliminar(EntidadUsuario usuario) {
        String sql = "DELETE FROM Usuario WHERE IdUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al eliminar usuario: " + usuario, e);
            return false;
        }
    }

    /**
     * Busca un usuario por su ID.
     * @param id El ID del usuario (se espera un entero, pero se convertirá a String).
     * @return El usuario encontrado o null si no se encuentra.
     */
    @Override
    public EntidadUsuario buscarPorId(int id) {
        // Convertir el int id a String, asumiendo que IdUsuario es un String numérico
        String idUsuario = String.valueOf(id);
        String sql = "SELECT * FROM Usuario WHERE IdUsuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al buscar usuario por ID: " + idUsuario, e);
        }
        return null;
    }

    /**
     * Lista todos los usuarios de la base de datos.
     * @param arg Se ignora este parámetro ya que no se utiliza en la implementación actual.
     * @return Una lista de todos los usuarios.
     */
    @Override
    public List<EntidadUsuario> listar(EntidadUsuario arg) {
        List<EntidadUsuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                EntidadUsuario usuario = map(rs);
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al listar todos los usuarios", e);
        }
        return usuarios;
    }

    /**
     * Mapea un ResultSet a un objeto EntidadUsuario.
     * @param rs El ResultSet obtenido de una consulta.
     * @return El objeto EntidadUsuario mapeado o null si ocurre un error.
     */
    @Override
    public EntidadUsuario map(ResultSet rs) {
        EntidadUsuario usuario = new EntidadUsuario();
        try {
            usuario.setId(rs.getInt("IdUsuario"));
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
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al mapear usuario desde ResultSet", e);
            return null;
        }
        return usuario;
    }

    /**
     * Método adicional para buscar un usuario por correo y contraseña.
     * Este método no forma parte de la interfaz, pero es útil para la autenticación.
     * @param correo La dirección de correo del usuario.
     * @param contrasena La contraseña del usuario.
     * @return El usuario encontrado o null si no se encuentra.
     */
    public EntidadUsuario findByCorreoContrasena(String correo, String contrasena) {
        String sql = "SELECT * FROM Usuario WHERE Correo = ? AND Contrasena = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al encontrar usuario por correo y contraseña: " + correo, e);
        }
        return null;
    }
}
