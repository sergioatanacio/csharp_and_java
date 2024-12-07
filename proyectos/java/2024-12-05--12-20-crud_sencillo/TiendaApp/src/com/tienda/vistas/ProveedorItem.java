package com.tienda.vistas;

/**
 * Clase que representa un ítem de proveedor en el JComboBox.
 */
public class ProveedorItem {
    private int id;
    private String nombre;

    public ProveedorItem(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre; // Solo se muestra el nombre en el JComboBox
    }
}
