package Dao; 

import conexion.conexion_bd;
import modelos.Usuario;    

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt; 

public class UsuarioDAO {

   
    public Usuario validarUsuario(String username, String password) {
    
        String sql = "SELECT idUsuario, nombreUsuario, contraseñaHash, rol FROM Usuarios WHERE nombreUsuario = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = conexion_bd.getConnection(); 
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("contraseñaHash");
      
                if (BCrypt.checkpw(password, hashedPassword)) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuario.setRol(rs.getString("rol"));
                 
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar usuario: " + e.getMessage());
            e.printStackTrace(); 
        } finally {
            conexion_bd.closeConnection(conn);
            try {
                if (pstmt != null) pstmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return usuario;
    }

    public boolean agregarUsuario(String username, String password, String rol) {
        String sql = "INSERT INTO Usuarios (nombreUsuario, contraseñaHash, rol) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt()); // Hashear la contraseña
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, rol);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
          
            if (e.getSQLState().startsWith("23")) { 
                System.err.println("Error: El nombre de usuario '" + username + "' ya existe.");
            } else {
                System.err.println("Error al añadir usuario: " + e.getMessage());
            }
            e.printStackTrace();
            return false;
        } finally {
            conexion_bd.closeConnection(conn);
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}