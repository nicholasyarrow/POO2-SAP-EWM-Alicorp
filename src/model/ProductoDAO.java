package model;

import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class ProductoDAO {

    public List<Producto> listarProductos(String tabla, String valor) throws Exception {
        List<Producto> listaProductos = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Obtener una nueva conexión para cada operación
            con = Conexion.getConnection();

            String sql;
            if ("".equalsIgnoreCase(valor)) {
                sql = "SELECT idProductos, nombreProducto, almacen, marca, stock, peso, precio, fechaCaducidad, img FROM " + tabla + " ORDER BY idProductos ASC";
                ps = con.prepareStatement(sql);
            } else {
                sql = "SELECT idProductos, nombreProducto, almacen, marca, stock, peso, precio, fechaCaducidad, img FROM " + tabla + " WHERE nombreProducto LIKE ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + valor.trim() + "%");
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProductos(rs.getInt("idProductos"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setAlmacen(rs.getString("almacen"));
                producto.setMarca(rs.getString("marca"));
                producto.setStock(rs.getString("stock"));
                producto.setPeso(rs.getString("peso"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setFechaCaducidad(rs.getString("fechaCaducidad"));
                producto.setImg(rs.getBytes("img"));
                listaProductos.add(producto);
            }
        } finally {
            // Asegurarse de cerrar los recursos en el bloque finally
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return listaProductos;
    }


    public List<Producto> listarProductosCaducidad() throws Exception {
        List<Producto> listaProductosCaducidad = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT * FROM productos WHERE fechaCaducidad > CURDATE() AND fechaCaducidad <= DATE_ADD(CURDATE(), INTERVAL 60 DAY) ORDER BY fechaCaducidad ASC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProductos(rs.getInt("idProductos"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setAlmacen(rs.getString("almacen"));
                producto.setMarca(rs.getString("marca"));
                producto.setStock(rs.getString("stock"));
                producto.setPeso(rs.getString("peso"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setFechaCaducidad(rs.getString("fechaCaducidad"));
                listaProductosCaducidad.add(producto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return listaProductosCaducidad;
    }
     public void guardar(Producto producto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO productos (nombreProducto, almacen, marca, stock, peso, precio, fechaCaducidad, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getAlmacen());
            ps.setString(3, producto.getMarca());
            ps.setString(4, producto.getStock());
            ps.setString(5, producto.getPeso());
            ps.setFloat(6, producto.getPrecio());
            ps.setString(7, producto.getFechaCaducidad());
            ps.setBytes(8, producto.getImg());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void actualizar(Producto producto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.getConnection();
            String sql = "UPDATE productos SET nombreProducto=?, almacen=?, marca=?, stock=?, peso=?, precio=?, fechaCaducidad=?, img=? WHERE idProductos=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getAlmacen());
            ps.setString(3, producto.getMarca());
            ps.setString(4, producto.getStock());
            ps.setString(5, producto.getPeso());
            ps.setFloat(6, producto.getPrecio());
            ps.setString(7, producto.getFechaCaducidad());
            ps.setBytes(8, producto.getImg());
            ps.setInt(9, producto.getIdProductos());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void eliminar(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM productos WHERE idProductos=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
