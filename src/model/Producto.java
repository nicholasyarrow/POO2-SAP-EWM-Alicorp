package model;

/**
 *
 * Clase que representa un producto.
 */
public class Producto {
    private int idProductos;
    private String nombreProducto;
    private String almacen;
    private String marca;
    private String stock;
    private String peso;
    private float precio;
    private String fechaCaducidad;
    private byte[] img;

    // Constructor con todos los atributos
    public Producto(int idProductos, String nombreProducto, String almacen, String marca, String stock, String peso, float precio, String fechaCaducidad, byte[] img) {
        this.idProductos = idProductos;
        this.nombreProducto = nombreProducto;
        this.almacen = almacen;
        this.marca = marca;
        this.stock = stock;
        this.peso = peso;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
        this.img = img;
    }

    // Constructor vacío necesario para algunas operaciones
    public Producto() {
    }

    // Métodos getter y setter para todos los atributos
    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
