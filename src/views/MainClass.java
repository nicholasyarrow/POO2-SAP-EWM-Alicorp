package views; // Asegúrate de que el paquete coincida con la estructura de tu proyecto

import javax.swing.SwingUtilities;

public class MainClass {
    public static void main(String[] args) {
        // Asegúrate de que la UI se ejecute en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crea una instancia de tu JFrame
                login frame = new login();
                
                // Configura el tamaño y comportamiento del JFrame
                frame.setSize(800, 600); // Ajusta el tamaño según tus necesidades
                frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                
                // Haz visible el JFrame
                frame.setVisible(true);
            }
        });
    }
}