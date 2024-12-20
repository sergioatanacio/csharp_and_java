/*
 * Clase entidad que representa la tabla "Categoria" en la base de datos
 */
package CapaEntidad;

import java.time.LocalDateTime;

public class EntidadCategoria implements Entidad {
    
    private int idCategoria;      // Identificador único de la categoría
    private String nombre;      // Descripción de la categoría
    private String descripcion;      // Descripción de la categoría
    private boolean estado;          // Estado de la categoría (activo/inactivo)
    private String fechaRegistro; // Fecha de registro de la categoría

    // Constructor vacío
    public EntidadCategoria() {}

    // Constructor con todos los campos
    public EntidadCategoria(int idCategoria, String nombre, String descripcion, boolean estado, String fechaRegistro) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y setters
    @Override
    public int getId() {
        return idCategoria;
    }
    public String getNombre() {
        return nombre;
    }    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setId(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "EntidadCategoriaProducto{" +
                "idCategoria='" + idCategoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
