/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.DatosCategoriaProducto;
import CapaDatos.DatosConnection;
import CapaDatos.DatosUsuario;
import CapaEntidad.EntidadCategoriaProducto;
import CapaEntidad.EntidadUsuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LAB02-PC1
 */
public class NegocioCategoriaProducto {
    private final DatosCategoriaProducto datosCategoriaProducto;

    // Constructor que recibe la capa DatosUsuario
    public NegocioCategoriaProducto() throws SQLException {
       Connection connection = DatosConnection.getConnection();
        this.datosCategoriaProducto = new DatosCategoriaProducto(connection);
    }
    public List<EntidadCategoriaProducto> listarCategoriaProductos() throws SQLException {
        return datosCategoriaProducto.listarTodasLasCategorias();
    }

}
