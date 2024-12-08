/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.Datos;
import CapaDatos.DatosCategoriaProducto;
import CapaDatos.DatosConnection;
import CapaEntidad.EntidadCategoriaProducto;
import CapaEntidad.EntidadUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LAB02-PC1
 */
public class NegocioCategoriaProducto implements Datos<EntidadCategoriaProducto, EntidadUsuario, ResultSet> {
    private DatosCategoriaProducto datosCategoriaProducto = null;
    

    // Constructor que recibe la capa DatosUsuario
    public NegocioCategoriaProducto(EntidadUsuario parametro_usuario) {
       Connection connection = DatosConnection.getConnection();
        this.datosCategoriaProducto = new DatosCategoriaProducto(connection, parametro_usuario);
    }
    @Override
    public List<EntidadCategoriaProducto> listar(EntidadUsuario arg)  {
        return datosCategoriaProducto.listar(arg);
    }
    public boolean insertar(EntidadCategoriaProducto arg)  {
        return datosCategoriaProducto.insertar(arg);
    }
    @Override
    public boolean eliminar(EntidadCategoriaProducto arg)  {
        return datosCategoriaProducto.eliminar(arg);
    }
    @Override
    public boolean actualizar(EntidadCategoriaProducto arg)  {
        return datosCategoriaProducto.actualizar(arg);
    }
    public EntidadCategoriaProducto buscarPorId(int id){
        return datosCategoriaProducto.buscarPorId(id);
    }

    @Override
    public EntidadCategoriaProducto map(ResultSet arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  


}
