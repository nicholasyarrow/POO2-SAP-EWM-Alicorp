package model;

import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase DAO para manejar operaciones con la tabla `usuario`.
 */
public class UsuarioDAO {

    // Método para validar el login de un usuario
    public boolean login(String usuario, String clave) throws SQLException {
        boolean estado = false;
        Connection cn = Conexion.getConnection();
        String query = "SELECT * FROM usuario WHERE usuario = ?";
        
        try (PreparedStatement pstm = cn.prepareStatement(query)) {
            pstm.setString(1, usuario);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String claveBD = rs.getString("clave");
                    if (claveBD.equals(clave)) {
                        estado = true;
                    }
                }
            }
        }
        return estado;
    }

    // Método para consultar un usuario por su nombre de usuario
    public Usuario consultarUsuario(String usuario) throws SQLException {
        Usuario dto = null;
        Connection cn = Conexion.getConnection();
        String query = "SELECT * FROM usuario WHERE usuario = ?";
        
        try (PreparedStatement pstm = cn.prepareStatement(query)) {
            pstm.setString(1, usuario);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    dto = new Usuario();
                    dto.setUsuario(rs.getString("usuario"));
                    dto.setNombres(rs.getString("nombres"));
                    dto.setApellidos(rs.getString("apellidos"));
                    dto.setRol(rs.getString("rol"));
                }
            }
        }
        return dto;
    }

    // Método para listar usuarios con rol 2 (por ejemplo, usuarios normales)
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        Connection con = Conexion.getConnection();
        String sql = "SELECT * FROM usuario WHERE rol = 2 ORDER BY id DESC";
        
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setUsuario(rs.getString("usuario"));
                lista.add(usu);
            }
        }
        return lista;
    }

    // Método para registrar un nuevo usuario
    public boolean registrar(Usuario usu) throws SQLException {
        String sql = "INSERT INTO usuario(nombres, apellidos, usuario, clave, rol) VALUES (?, ?, ?, ?, ?)";
        Connection con = Conexion.getConnection();
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usu.getNombres());
            ps.setString(2, usu.getApellidos());
            ps.setString(3, usu.getUsuario());
            ps.setString(4, usu.getClave()); 
            ps.setString(5, usu.getRol());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
