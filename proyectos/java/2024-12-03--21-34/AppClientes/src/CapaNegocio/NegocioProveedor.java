/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;
import java.sql.Connection;
import CapaDatos.Datos;
import CapaDatos.DatosConnection;
import CapaDatos.DatosProveedor;
import CapaEntidad.EntidadCategoria;
import CapaEntidad.EntidadProveedor;
import CapaEntidad.EntidadUsuario;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ANGEL
 */
public class NegocioProveedor implements Datos<EntidadProveedor, EntidadUsuario, ResultSet> {
    private DatosProveedor datosProveedor = null;
    public NegocioProveedor(EntidadUsuario parametro_usuario){
        Connection conexion = DatosConnection.getConnection();
        this.datosProveedor = new DatosProveedor(conexion, parametro_usuario);
    }

    @Override
    public boolean insertar(EntidadProveedor arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        return datosProveedor.listar(arg);
    }

    @Override
    public EntidadProveedor map(ResultSet arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
