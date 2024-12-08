package CapaNegocio;

import CapaDatos.Datos;
import CapaDatos.DatosUsuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import CapaEntidad.EntidadUsuario;
import CapaDatos.DatosConnection;
import CapaEntidad.EntidadCategoriaProducto;
import javax.swing.JOptionPane;
import CapaEntidad.EntidadRespuesta;
import java.sql.ResultSet;
import java.util.Collections;

public class NegocioUsuario implements Datos<EntidadUsuario, EntidadUsuario, ResultSet> {
    private DatosUsuario datosUsuario;
    EntidadUsuario usuario;


    public NegocioUsuario(EntidadUsuario arg) {
        Connection connection = DatosConnection.getConnection();
        this.datosUsuario = new DatosUsuario(connection);
        usuario = arg;
    }

    // Método para registrar un usuario con validaciones
    @Override
    public boolean insertar(EntidadUsuario usuario) {
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
        if (datosUsuario.buscarPorId(usuario.getId()) != null) {
            throw new IllegalArgumentException("El usuario con el ID proporcionado ya existe.");
        }
        // Registrar el usuario
        return datosUsuario.insertar(usuario);
    }

    // Método para actualizar un usuario
    @Override
    public boolean actualizar(EntidadUsuario usuario) {
        if (usuario == null || usuario.getId() == 0) {
            throw new IllegalArgumentException("El usuario o su ID no pueden ser nulos o cero.");
        }

        // Validar si el usuario existe
        EntidadUsuario usuarioExistente = datosUsuario.buscarPorId(usuario.getId());
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }
        // Actualizar usuario
        return datosUsuario.actualizar(usuario);
    }

    // Método para buscar un usuario por ID
    public EntidadUsuario buscarUsuarioPorId(int idUsuario) {
        if (idUsuario == 0) {
            throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
        }

        // Buscar usuario
        return datosUsuario.buscarPorId(idUsuario);
    }

    // Método para eliminar un usuario
    public boolean eliminar(EntidadCategoriaProducto arg) {
        if (arg.getId() == 0) {
            throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
        }

        // Validar si el usuario existe
        EntidadUsuario usuarioExistente = datosUsuario.buscarPorId(arg.getId());
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }
        // Eliminar usuario
        return datosUsuario.eliminar(usuarioExistente);
    }

    // Método para listar todos los usuarios
    public List<EntidadUsuario> listar() {
        return datosUsuario.listar(this.usuario);
    }

    // Método para cambiar el estado de un usuario (activar/desactivar)
    public boolean cambiarEstadoUsuario(int idUsuario, boolean nuevoEstado) {
        if (idUsuario <= 0) {
            throw new IllegalArgumentException("El ID del usuario debe ser un valor positivo.");
        }

        // Validar si el usuario existe
        EntidadUsuario usuarioExistente = datosUsuario.buscarPorId(idUsuario);
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("El usuario no existe.");
        }
        // Cambiar el estado
        usuarioExistente.setEstado(nuevoEstado);
        return datosUsuario.actualizar(usuarioExistente);
    }

    // Método para iniciar sesión (login)
    public EntidadRespuesta<EntidadUsuario> iniciarSesion(String correo, String contrasena) {
        EntidadRespuesta<EntidadUsuario> respuesta = new EntidadRespuesta<>();


//            if (correo == null || correo.isEmpty()) {
//                respuesta.setSuccess(false);
//                respuesta.setMensaje("El correo no puede estar vacío.");
//                return respuesta;
//            }
//            if (contrasena == null || contrasena.isEmpty()) {
//                respuesta.setSuccess(false);
//                respuesta.setMensaje("La contraseña no puede estar vacía.");
//                return respuesta;
//            }

            // Buscar al usuario en la base de datos
            EntidadUsuario usuario_local = datosUsuario.findByCorreoContrasena(correo, contrasena);

//            if (usuario_local == null) {
//                respuesta.setSuccess(false);
//                respuesta.setMensaje("Correo o contraseña incorrectos.");
//                return respuesta;
//            }
//
//            // Validar si el usuario está activo
//            if (!usuario_local.isEstado()) {
//                respuesta.setSuccess(false);
//                respuesta.setMensaje("El usuario está inactivo.");
//                return respuesta;
//            }

            // Configurar la respuesta como exitosa
            respuesta.setSuccess(true);
            respuesta.setMensaje("Inicio de sesión exitoso.");
            respuesta.setDatos(Collections.singletonList(usuario_local)); // Agregar el usuario a la lista de datos


        // Manejar errores de SQL

        return respuesta;
    }

    // Métodos del interface Datos

    @Override
    public boolean eliminar(EntidadUsuario arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EntidadUsuario buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EntidadUsuario> listar(EntidadUsuario arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EntidadUsuario map(ResultSet arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
