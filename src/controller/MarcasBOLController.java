package controller;

import views.MostrarProducto;
import javax.swing.JFrame;

public class MarcasBOLController {

    private final MostrarProducto marcasBOLView;

    // Constructor modificado para aceptar la referencia del JFrame llamante
    public MarcasBOLController(int almacen, int boton, JFrame almacenOrigen) {
        // Crear una instancia de MostrarProducto con los parámetros proporcionados
        this.marcasBOLView = new MostrarProducto(almacen, boton, almacenOrigen);
        // Centramos el JFrame en la pantalla
        this.marcasBOLView.setLocationRelativeTo(null);
        // Hacemos visible el JFrame
        this.marcasBOLView.setVisible(true);
    }

    // Método main para la prueba independiente
    public static void main(String[] args) {
        // Ejemplo de uso: Almacén 1, Botón 1, sin referencia al JFrame llamante
        new MarcasBOLController(1, 1, null);
    }
}
