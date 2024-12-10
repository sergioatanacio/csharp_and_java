/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import CapaEntidad.EntidadCategoria;
import CapaEntidad.EntidadProveedor;
import CapaEntidad.EntidadUsuario;
import java.sql.ResultSet;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ANGEL
 */
public class DatosProveedor implements Datos<EntidadProveedor, EntidadUsuario, ResultSet> {
    public Connection connection;
    public EntidadUsuario e_usuario;
    
    public DatosProveedor(Connection connection, EntidadUsuario parametro_usuario){
        this.connection = connection;
        this.e_usuario = parametro_usuario;
    }

    @Override
    public boolean insertar(EntidadProveedor arg) {
        String sql = """
            INSERT INTO Proveedor (RUC, RazonSocial, Direccion, Telefono, Correo, Estado, FechaRegistro)
            VALUES (?, ?, ?, ?, ?, ?, NOW());""";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, arg.getRuc());
            stmt.setString(2, arg.getRazonSocial());
            stmt.setString(3, arg.getDireccion());
            stmt.setString(1, arg.getTelefono());
            stmt.setString(1, arg.getCorreo());
            stmt.setBoolean(1, arg.isEstado());
            stmt.setString(1, arg.getRuc());
            stmt.setString(1, arg.getRuc());
            stmt.setString(1, arg.getRuc());
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
    public boolean actualizar(EntidadProveedor arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(EntidadProveedor arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EntidadProveedor buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EntidadProveedor> listar(EntidadUsuario arg) {
        List<EntidadProveedor> proveedor = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor;";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                proveedor.add(map(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return proveedor.isEmpty() ? null : proveedor;
    }

    @Override
    public EntidadProveedor map(ResultSet arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
