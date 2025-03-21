package controller;

import views.Imprimir;
import model.ProductoDAO;

public class ImprimirController {
    private ProductoDAO ProductoDAO;
    private Imprimir imprimirView;

    public ImprimirController(ProductoDAO productoDao, Imprimir imprimirView) {
        this.ProductoDAO = productoDao;
        this.imprimirView = imprimirView;
    }

   
}
