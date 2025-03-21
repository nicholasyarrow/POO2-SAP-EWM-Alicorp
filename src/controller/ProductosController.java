package controller;

import model.Producto;
import model.ProductoDAO;

import java.util.List;

public class ProductosController {

    private ProductoDAO productoDAO;

    public ProductosController() {
        productoDAO = new ProductoDAO();
    }

    public List<Producto> listarProductos(String tabla, String valor) throws Exception {
        return productoDAO.listarProductos(tabla, valor);
    }

    public Producto obtenerProductoPorId(int id, String tabla) throws Exception {
        List<Producto> listaProductos = productoDAO.listarProductos(tabla, "");
        for (Producto producto : listaProductos) {
            if (producto.getIdProductos() == id) {
                return producto;
            }
        }
        return null;
    }

    public void insertarProducto(Producto nuevoProducto) throws Exception {
        productoDAO.guardar(nuevoProducto);
    }

    public void actualizarProducto(Producto productoExistente) throws Exception {
        productoDAO.actualizar(productoExistente);
    }

    public void eliminarProducto(int id, String tabla) throws Exception {
        productoDAO.eliminar(id);
    }
}
