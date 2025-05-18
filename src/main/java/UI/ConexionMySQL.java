/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UI;
import javax.swing.*;
import java.sql.*;

public class ConexionMySQL {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba de Conexión");
        JTextArea textArea = new JTextArea(10, 30);
        frame.add(new JScrollPane(textArea));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String url = "jdbc:mysql://localhost:3306/eventmasterpro?useSSL=false&serverTimezone=UTC";
        String usuario = "root"; // por defecto en XAMPP
        String contraseña = ""; // si no le has puesto contraseña

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prueba");

            while (rs.next()) {
                String dato = rs.getString(1); // primera columna
                textArea.append(dato + "\n");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            textArea.setText("Error al conectar: " + e.getMessage());
        }
    }
}
