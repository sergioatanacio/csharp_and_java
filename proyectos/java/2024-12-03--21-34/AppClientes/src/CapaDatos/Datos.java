/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaDatos;

import CapaEntidad.EntidadUsuario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author ANGEL
 * @param <T>
 */
public interface Datos <T, U, V>{
    public boolean insertar(T arg);
    public boolean actualizar(T arg);
    public boolean eliminar(T arg);
    public T buscarPorId(int id);
    public List<T> listar(U arg);
    public T map(V arg);
}
