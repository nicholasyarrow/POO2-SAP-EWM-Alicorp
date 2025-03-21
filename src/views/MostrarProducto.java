package views;

import controller.ProductosController;
import java.awt.Component;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Producto;
import model.ProductoDAO;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MostrarProducto extends javax.swing.JFrame {
    
    private Map<String, String> tablaMap;
    private ProductosController productoController;
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    DefaultTableModel modelo = new DefaultTableModel();    
    private JFrame almacenOrigen;
    private boolean isInitializing = true;
    
    
     public MostrarProducto() {
        this(1, 1,null); // Valores predeterminados, por ejemplo almacen 1 y boton 1
    }
     public MostrarProducto(int almacen, int boton, JFrame almacenOrigen) {
        this.almacenOrigen = almacenOrigen; 
        try {
            initComponents();

            // Inicializar el mapa de nombres amigables a nombres de tablas
            tablaMap = new LinkedHashMap<>(); // Utilizamos LinkedHashMap para mantener el orden de inserción

            // Configurar las tablas en función del almacén y el botón
            configurarTablas(almacen, boton);

            // Limpiar el JComboBox y agregar nombres amigables en el orden definido
            cboTablas.removeAllItems();
            for (String nombreAmigable : tablaMap.keySet()) {
                cboTablas.addItem(nombreAmigable);
            }

            // Agregar ActionListener al JComboBox para actualizar la lista de productos cuando se seleccione una nueva tabla
            cboTablas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (!isInitializing) { // Prevent action during initialization
                        cboTablasActionPerformed(evt); // Llamar al método que actualizará la lista de productos
                    }
                }
            });

            // Finalizar inicialización
            isInitializing = false;

            // Cargar los productos de la tabla seleccionada por defecto en el JComboBox
            actualizarListaProductos(); // Esta llamada debe estar después de la inicialización completa

            // Configurar acción para mostrar el almacén origen al cerrar
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if (almacenOrigen != null) {
                        almacenOrigen.setVisible(true);
                    }
                }
            });

            // Centramos el JFrame en la pantalla
            this.setLocationRelativeTo(null);

        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en la consola
            javax.swing.JOptionPane.showMessageDialog(this, "Error al inicializar el JFrame: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRetroceso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cboTablas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        btnRetroceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        btnRetroceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocesoActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Peso", "Precio", "Stock", "Fecha de Caducidad", "Imagen Referencial"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N

        cboTablas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "productos", "productos1", "productos2" }));
        cboTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTablasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRetroceso)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar)
                                .addGap(55, 55, 55))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cboTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRetroceso)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurarTablas(int almacen, int boton) {
    // Limpiar el mapa antes de configurar
    tablaMap.clear();

    // Configuración basada en almacén y botón
    if (almacen == 1) {
        if (boton == 1) {
            tablaMap.put("Productos Almacen 1 - Botón 1 - Opción 1", "productos");
            tablaMap.put("Electrónica Almacen 1 - Botón 1 - Opción 2", "productos1");
            tablaMap.put("Ropa Almacen 1 - Botón 1 - Opción 3", "productos2");
        } else if (boton == 2) {
            tablaMap.put("Productos Almacen 1 - Botón 2 - Opción 1", "productos3");
            tablaMap.put("Electrónica Almacen 1 - Botón 2 - Opción 2", "productos4");
            tablaMap.put("Ropa Almacen 1 - Botón 2 - Opción 3", "productos5");
        }
    } else if (almacen == 2) {
        if (boton == 1) {
            tablaMap.put("Productos Almacen 2 - Botón 1 - Opción 1", "productos6");
            tablaMap.put("Electrónica Almacen 2 - Botón 1 - Opción 2", "productos7");
            tablaMap.put("Ropa Almacen 2 - Botón 1 - Opción 3", "productos8");
        } else if (boton == 2) {
            tablaMap.put("Productos Almacen 2 - Botón 2 - Opción 1", "productos9");
            tablaMap.put("Electrónica Almacen 2 - Botón 2 - Opción 2", "productos10");
            tablaMap.put("Ropa Almacen 2 - Botón 2 - Opción 3", "productos11");
        }
    }
}

    private void btnRetrocesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocesoActionPerformed
       this.setVisible(false);
        if (almacenOrigen != null) {
            almacenOrigen.setVisible(true);
        } else {
            new almacen2().setVisible(true); // Opción por defecto si no se proporciona almacenOrigen
        }
    }//GEN-LAST:event_btnRetrocesoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cboTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTablasActionPerformed
         actualizarListaProductos();
    }//GEN-LAST:event_cboTablasActionPerformed
     
    private void LimpiarTable() {
        DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
        model.setRowCount(0); 
    }
                
    private void llenarTablaConProductos(List<Producto> productos) {
        DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
        model.setRowCount(0); // Limpia la tabla antes de llenarla

        for (Producto producto : productos) {
            // Convertir bytes de imagen a ImageIcon
            ImageIcon imageIcon = null;
            if (producto.getImg() != null) {
                imageIcon = new ImageIcon(producto.getImg());
                // Redimensionar la imagen para ajustarla a la celda de la tabla si es necesario
                Image image = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);
            }

            // Agrega una fila a la tabla, incluyendo la imagen
            model.addRow(new Object[]{
                producto.getNombreProducto(),
                producto.getPeso(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getFechaCaducidad(),
                imageIcon
            });
        }

        // Ajusta el renderizador de la celda para la columna de imagen
        tblProductos.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof ImageIcon) {
                    JLabel label = new JLabel((ImageIcon) value);
                    return label;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarProducto().setVisible(true);
            }
        });
    }
    
    private void actualizarListaProductos() {
        try {
            // Verificar si el JComboBox tiene ítems seleccionados
            if (cboTablas.getItemCount() == 0) {
                return; // Si no hay ítems, salir del método
            }

            // Obtiene el nombre amigable de la tabla seleccionada del JComboBox
            String nombreAmigable = (String) cboTablas.getSelectedItem();
            if (nombreAmigable == null) {
                return; // Si no hay selección válida, no hacer nada
            }

            // Obtiene el nombre real de la tabla a partir del mapa
            String nombreTabla = tablaMap.get(nombreAmigable);

            // Llama al método listarProductos con la tabla seleccionada y sin filtro de búsqueda
            List<Producto> productos = productoDAO.listarProductos(nombreTabla, "");

            // Llenar la tabla con los productos obtenidos
            llenarTablaConProductos(productos);
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al listar productos: " + e.getMessage());
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetroceso;
    private javax.swing.JComboBox<String> cboTablas;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}