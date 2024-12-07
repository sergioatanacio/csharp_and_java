package CapaNegocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import CapaDatos.DatosUsuario;
import CapaEntidad.EntidadUsuario;
import CapaDatos.DatosConnection;
import javax.swing.JOptionPane;
import CapaEntidad.EntidadRespuesta;
import java.util.Collections;
public class NegocioUsuario {

    private final DatosUsuario datosUsuario;

    // Constructor que recibe la capa DatosUsuario
    public NegocioUsuario() throws SQLException {
       Connection connection = DatosConnection.getConnection();
        this.datosUsuario = new DatosUsuario(connection);
    }

    // Método para registrar un usuario con validaciones
    public boolean registrarUsuario(EntidadUsuario usuario) throws SQLException {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }

        // Validar campos obligatorios
        if (usuario.getDni() == null || usuario.getDni().isEmpty()) {
            throw new IllegalArgumentException("El DNI del usuario es obligatorio.");
        }
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario es obligatorio.");
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().isEmpty()) {
            throw new IllegalArgumentException("La contraseña del usuario es obligatoria.");
        }

        // Validar longitud del DNI
        if (usuario.getDni().length() != 8) {
            throw new IllegalArgumentException("El DNI debe tener 8 caracteres.");
        }

        // Validar si el usuario ya existe
        if (datosUsuario.buscarUsuarioPorId(usuario.getIdUsuario()) != null) {
            throw new IllegalArgumentException("El usuario con el ID proporcionado ya existe.");
        }

        // Registrar el usuario
        return datosUsuario.insertarUsuario(usuario);
    }

    // Método para actualizar un usuario
    public boolean actualizarUsuario(EntidadUsuario usuario) throws SQLException {
        if (usuario == null || usuario.getIdUsuario() == null) {
            throw new IllegalArgumentException("El usuario o su ID no pueden ser nulos.");
        }

        // Validar si el usuario existe
        EntidadUsuario usuarioExistente = datosUsuario.buscarUsuarioPorId(usuario.getIdUsuario());
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }

        // Actualizar usuario
        return datosUsuario.actualizarUsuario(usuario);
    }

    // Método para buscar un usuario por ID
    public EntidadUsuario buscarUsuarioPorId(String idUsuario) throws SQLException {
        if (idUsuario == null || idUsuario.isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
        }

        // Buscar usuario
        return datosUsuario.buscarUsuarioPorId(idUsuario);
    }

    // Método para eliminar un usuario
    public boolean eliminarUsuario(String idUsuario) throws SQLException {
        if (idUsuario == null || idUsuario.isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
        }

        // Validar si el usuario existe
        EntidadUsuario usuarioExistente = datosUsuario.buscarUsuarioPorId(idUsuario);
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }

        // Eliminar usuario
        return datosUsuario.eliminarUsuario(idUsuario);
    }

    // Método para listar todos los usuarios
    public List<EntidadUsuario> listarUsuarios() throws SQLException {
        return datosUsuario.listarTodosLosUsuarios();
    }

    // Método para cambiar el estado de un usuario (activar/desactivar)
    public boolean cambiarEstadoUsuario(String idUsuario, boolean nuevoEstado) throws SQLException {
        if (idUsuario == null || idUsuario.isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
        }

        // Validar si el usuario existe
        EntidadUsuario usuarioExistente = datosUsuario.buscarUsuarioPorId(idUsuario);
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }

        // Cambiar el estado
        usuarioExistente.setEstado(nuevoEstado);
        return datosUsuario.actualizarUsuario(usuarioExistente);
    }

    // Método para iniciar sesión (login)


    public EntidadRespuesta<EntidadUsuario> iniciarSesion(String correo, String contrasena) throws SQLException {
        EntidadRespuesta<EntidadUsuario> respuesta = new EntidadRespuesta<>();

        try {
            if (correo == null || correo.isEmpty()) {
                respuesta.setSuccess(false);
                respuesta.setMensaje("El correo no puede estar vacío.");
                return respuesta;
            }
            if (contrasena == null || contrasena.isEmpty()) {
                respuesta.setSuccess(false);
                respuesta.setMensaje("La contraseña no puede estar vacía.");
                return respuesta;
            }

            // Buscar al usuario en la base de datos
            EntidadUsuario usuario = datosUsuario.findByCorreoContrasena(correo, contrasena);

            if (usuario == null) {
                respuesta.setSuccess(false);
                respuesta.setMensaje("Correo o contraseña incorrectos.");
                return respuesta;
            }

            // Validar si el usuario está activo
            if (!usuario.isEstado()) {
                respuesta.setSuccess(false);
                respuesta.setMensaje("El usuario está inactivo.");
                return respuesta;
            }

            // Configurar la respuesta como exitosa
            respuesta.setSuccess(true);
            respuesta.setMensaje("Inicio de sesión exitoso.");
            respuesta.setDatos(Collections.singletonList(usuario)); // Agregar el usuario a la lista de datos

        } catch (Exception e) {
            // Manejar errores inesperados
            respuesta.setSuccess(false);
            respuesta.setMensaje("Error al intentar iniciar sesión: " + e.getMessage());
        }

        return respuesta;
    }

}
