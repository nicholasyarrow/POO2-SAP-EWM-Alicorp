package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/test_db?autoReconnect=true&serverTimezone=UTC&initialTimeout=360000";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Obtener una nueva conexión cada vez que se llame a este método
    public static Connection getConnection() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // Registrar la excepción en la consola
        }
        return cn;
    }
}
