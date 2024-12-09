/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidad;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;



public class EntidadProducto  implements Entidad  {

    private int idProducto;
    private String codigoBarras;
    private String nombreProducto;
    private String descripcion;
    private String idCategoria;
    private String unidadMedida;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private String marca;
    private String modelo;
    private int stock;
    private LocalDate fechaVencimiento;
    private String idProveedor;
    private String idUbicacion;
    private String imagen;
    private boolean estado;
    private String fechaRegistro;

    // Constructor vacío
    public EntidadProducto() {}

    // Constructor completo
    public EntidadProducto(int idProducto, String codigoBarras, String nombreProducto, String descripcion, 
                    String idCategoria, String unidadMedida, BigDecimal precioCompra, BigDecimal precioVenta,
                    String marca, String modelo, int stock, LocalDate fechaVencimiento, String idProveedor,
                    String idUbicacion, String imagen, boolean estado, String fechaRegistro) {
        this.idProducto = idProducto;
        this.codigoBarras = codigoBarras;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
        this.idProveedor = idProveedor;
        this.idUbicacion = idUbicacion;
        this.imagen = imagen;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    @Override
    public int getId() {
        return idProducto;
    }

    @Override
    public void setId(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto='" + idProducto + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", idCategoria='" + idCategoria + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", stock=" + stock +
                ", fechaVencimiento=" + fechaVencimiento +
                ", idProveedor='" + idProveedor + '\'' +
                ", idUbicacion='" + idUbicacion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado=" + estado +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}

