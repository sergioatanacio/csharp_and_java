/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Paneles;

import java.util.List;

public interface PanelCrud/* <T> */ {
    
    // Método para cargar los datos en el formulario.
    void cargarDatos();
    
    // Método para agregar un nuevo registro.
    void agregar();
    
    // Método para actualizar un registro existente.
    void actualizar();
    
    // Método para eliminar un registro existente.
    void eliminar();
    
    // Método para limpiar los campos del formulario.
    void limpiarCampos();
    
    // Método para limpiar la tabla (eliminar todas las filas).
    void limpiartabla();
    
    // Método para filtrar los datos de la tabla según un texto.
    void filtrar(String texto);
    
    // Método para obtener todos los datos desde el DAO.
//    List<T> obtenerDatos();
}
