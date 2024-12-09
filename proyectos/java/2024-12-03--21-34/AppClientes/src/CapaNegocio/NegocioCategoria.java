/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.Datos;
import CapaDatos.DatosCategoria;
import CapaDatos.DatosConnection;
import CapaEntidad.EntidadCategoria;
import CapaEntidad.EntidadUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LAB02-PC1
 */
public class NegocioCategoria implements Datos<EntidadCategoria, EntidadUsuario, ResultSet> {
    private DatosCategoria datosCategoriaProducto = null;
    

    // Constructor que recibe la capa DatosUsuario
    public NegocioCategoria(EntidadUsuario parametro_usuario) {
       Connection connection = DatosConnection.getConnection();
        this.datosCategoriaProducto = new DatosCategoria(connection, parametro_usuario);
    }
    @Override
    public List<EntidadCategoria> listar(EntidadUsuario arg)  {
        return datosCategoriaProducto.listar(arg);
    }
    public boolean insertar(EntidadCategoria arg)  {
        return datosCategoriaProducto.insertar(arg);
    }
    @Override
    public boolean eliminar(EntidadCategoria arg)  {
        return datosCategoriaProducto.eliminar(arg);
    }
    @Override
    public boolean actualizar(EntidadCategoria arg)  {
        return datosCategoriaProducto.actualizar(arg);
    }
    public EntidadCategoria buscarPorId(int id){
        return datosCategoriaProducto.buscarPorId(id);
    }

    @Override
    public EntidadCategoria map(ResultSet arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  


}
