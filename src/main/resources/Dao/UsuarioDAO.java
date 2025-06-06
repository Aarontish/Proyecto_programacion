package Dao;

import conexion.conexion_bd;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO {

    private void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conexion_bd.closeConnection(conn);
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
            e.printStackTrace();
        }
    }

   
    public Usuario login(String nombreUsuario, String contrasenaPlana) {
        String sql = "SELECT idUsuario, nombreUsuario, contraseñaHash, rol FROM Usuarios WHERE nombreUsuario = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombreUsuario);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("contraseñaHash"); // Obtener el hash almacenado
                // Verificar la contraseña plana con el hash almacenado usando BCrypt
                if (BCrypt.checkpw(contrasenaPlana, storedHash)) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuario.setContraseñaHash(storedHash); // Almacenar el hash en el objeto modelo
                    usuario.setRol(rs.getString("rol"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en el login: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, pstmt, rs);
        }
        return usuario;
    }

    public boolean createUsuario(Usuario usuario) {
        // Generar el hash de la contraseña en texto plano
        String hashedPassword = BCrypt.hashpw(usuario.getContraseñaHash(), BCrypt.gensalt());

        String sql = "INSERT INTO Usuarios (nombreUsuario, contraseñaHash, rol) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, hashedPassword); // Guardar el hash
            pstmt.setString(3, usuario.getRol());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }

    public Usuario getUsuarioById(int idUsuario) {
        String sql = "SELECT idUsuario, nombreUsuario, contraseñaHash, rol FROM Usuarios WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseñaHash(rs.getString("contraseñaHash"));
                usuario.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, pstmt, rs);
        }
        return usuario;
    }

    public boolean updateUsuario(Usuario usuario) {
        String sql = "UPDATE Usuarios SET nombreUsuario = ?, contraseñaHash = ?, rol = ? WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContraseñaHash()); // Se asume que el hash ya está en el objeto
            pstmt.setString(3, usuario.getRol());
            pstmt.setInt(4, usuario.getIdUsuario());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }

    public boolean deleteUsuario(int idUsuario) {
        String sql = "DELETE FROM Usuarios WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }
}
