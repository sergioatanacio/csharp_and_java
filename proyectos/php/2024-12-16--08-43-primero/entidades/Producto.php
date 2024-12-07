<?php
// entidades/Producto.php

class Producto {
    private $id;
    private $nombre;
    private $descripcion;
    private $precio;
    private $proveedor;

    // Constructor
    public function __construct($id = null, $nombre = "", $descripcion = "", $precio = 0.0, $proveedor = null) {
        $this->id = $id;
        $this->nombre = $nombre;
        $this->descripcion = $descripcion;
        $this->precio = $precio;
        $this->proveedor = $proveedor;
    }

    // Getters y Setters
    public function getId() {
        return $this->id;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function getDescripcion() {
        return $this->descripcion;
    }

    public function getPrecio() {
        return $this->precio;
    }

    public function getProveedor() {
        return $this->proveedor;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function setNombre($nombre) {
        $this->nombre = $nombre;
    }

    public function setDescripcion($descripcion) {
        $this->descripcion = $descripcion;
    }

    public function setPrecio($precio) {
        $this->precio = $precio;
    }

    public function setProveedor($proveedor) {
        $this->proveedor = $proveedor;
    }
}
?>
