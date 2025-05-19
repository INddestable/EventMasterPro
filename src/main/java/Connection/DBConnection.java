/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/EventMasterPro";
    private static final String USER = "root"; // cámbialo si usas otro usuario
    private static final String PASSWORD = ""; // pon tu contraseña si tienes

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

