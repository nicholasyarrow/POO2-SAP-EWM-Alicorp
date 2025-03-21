package controller;

import views.MarcasDV;
import model.ProductoDAO;
import model.ProductoDAO;

public class OpcionesController {
    private ProductoDAO productoDAO;
    private MarcasDV marcasDVView;

    public OpcionesController(ProductoDAO productoDAO, MarcasDV marcasDVView) {
        this.productoDAO = productoDAO;
        this.marcasDVView = marcasDVView;
    }

    // Aquí puedes agregar métodos para manejar la lógica relacionada con la vista MarcasDV
}
