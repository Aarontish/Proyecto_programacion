package Dao;

import conexion.conexion_bd;
import modelos.TiposHabitacionn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.TiposHabitacionn;


public class TipoHabitacionDAO {
	public boolean updateTipoHabitacion(TiposHabitacionn tipoHabitacion) {
	    String sql = "UPDATE TiposHabitacion SET nombreTipo = ?, descripcion = ?, capacidadMaxima = ?, precioPorNoche = ? WHERE idTipoHabitacion = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, tipoHabitacion.getNombreTipo());
	        pstmt.setString(2, tipoHabitacion.getDescripcion());
	        pstmt.setInt(3, tipoHabitacion.getCapacidadMaxima());
	        pstmt.setDouble(4, tipoHabitacion.getPrecioPorNoche());
	        pstmt.setInt(5, tipoHabitacion.getIdTipoHabitacion());

	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0; // Retorna true si se actualizó al menos una fila
	    } catch (SQLException e) {
	        System.err.println("Error al actualizar tipo de habitación: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conexion_bd.closeConnection(conn);
	        } catch (SQLException e) {
	            System.err.println("Error al cerrar la conexión: " + e.getMessage());
	        }
	    }
	}

	public boolean deleteTipoHabitacion(int idTipoHabitacion) {
	    String sql = "DELETE FROM TiposHabitacion WHERE idTipoHabitacion = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, idTipoHabitacion);

	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0; // Si afectó filas, sí eliminó
	    } catch (SQLException e) {
	        System.err.println("Error al eliminar tipo de habitación: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            System.err.println("Error al cerrar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

	public TiposHabitacionn getTipoHabitacionByName(String nombreTipo) {
	    TiposHabitacionn tipoHabitacion = null;
	    String sql = "SELECT idTipoHabitacion, nombreTipo, descripcion, capacidadMaxima, precioPorNoche FROM TiposHabitacion WHERE nombreTipo = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, nombreTipo);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            tipoHabitacion = new TiposHabitacionn(
	                rs.getInt("idTipoHabitacion"),
	                rs.getString("nombreTipo"),
	                rs.getString("descripcion"),
	                rs.getInt("capacidadMaxima"),
	                rs.getDouble("precioPorNoche")
	            );
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener tipo de habitación por nombre: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return tipoHabitacion;
	}

	public TiposHabitacionn getTipoHabitacionByName(String nombreTipo) {
	    TiposHabitacionn tipoHabitacion = null;
	    String sql = "SELECT idTipoHabitacion, nombreTipo, descripcion, capacidadMaxima, precioPorNoche FROM TiposHabitacion WHERE nombreTipo = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, nombreTipo);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            tipoHabitacion = new TiposHabitacionn(
	                rs.getInt("idTipoHabitacion"),
	                rs.getString("nombreTipo"),
	                rs.getString("descripcion"),
	                rs.getInt("capacidadMaxima"),
	                rs.getDouble("precioPorNoche")
	            );
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener tipo de habitación por nombre: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return tipoHabitacion;
	}

	
	public List<TiposHabitacionn> getAllTiposHabitacion() {
	    List<TiposHabitacionn> tiposHabitacion = new ArrayList<>();
	    String sql = "SELECT idTipoHabitacion, nombreTipo, descripcion, capacidadMaxima, precioPorNoche FROM TiposHabitacion";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            TiposHabitacionn tipo = new TiposHabitacionn(
	                rs.getInt("idTipoHabitacion"),
	                rs.getString("nombreTipo"),
	                rs.getString("descripcion"),
	                rs.getInt("capacidadMaxima"),
	                rs.getDouble("precioPorNoche")
	            );
	            tiposHabitacion.add(tipo);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener todos los tipos de habitación: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conexion_bd.closeConnection(conn);
	        } catch (SQLException e) {
	            System.err.println("Error al cerrar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    return tiposHabitacion;
	}

	public String getNombreTipoHabitacionById(int idTipoHabitacion) {
	    String nombreTipo = null;

	    String sql = "SELECT nombreTipo FROM TiposHabitacion WHERE idTipoHabitacion = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, idTipoHabitacion);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nombreTipo = rs.getString("nombreTipo");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener nombreTipoHabitacion por ID: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return nombreTipo;
	}

	public int getIdTipoHabitacionByNombre(String nombreTipo) {
	    int idTipoHabitacion = -1; 
	    String sql = "SELECT idTipoHabitacion FROM TiposHabitacion WHERE nombreTipo = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, nombreTipo);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            idTipoHabitacion = rs.getInt("idTipoHabitacion");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener idTipoHabitacion por nombre: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return idTipoHabitacion;
	}

	public TiposHabitacionn getTipoHabitacionById(int idTipoHabitacion) {
	    TiposHabitacionn tipoHabitacion = null;
	    String sql = "SELECT idTipoHabitacion, nombreTipo, descripcion, capacidadMaxima, precioPorNoche FROM TiposHabitacion WHERE idTipoHabitacion = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, idTipoHabitacion);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            tipoHabitacion = new TiposHabitacionn(
	                rs.getInt("idTipoHabitacion"),
	                rs.getString("nombreTipo"),
	                rs.getString("descripcion"),
	                rs.getInt("capacidadMaxima"),
	                rs.getDouble("precioPorNoche")
	            );
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener tipo de habitación por ID: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        // Cerrar recursos
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return tipoHabitacion;
	}


    // Método para crear un nuevo tipo de habitación
    public boolean createTipoHabitacion(TiposHabitacionn tipoHabitacion) {
        String sql = "INSERT INTO TiposHabitacion (nombreTipo, descripcion, capacidadMaxima, precioPorNoche) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, tipoHabitacion.getNombreTipo());
            pstmt.setString(2, tipoHabitacion.getDescripcion());
            pstmt.setInt(3, tipoHabitacion.getCapacidadMaxima());
            pstmt.setDouble(4, tipoHabitacion.getPrecioPorNoche());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // true si se insertó bien
        } catch (SQLException e) {
            System.err.println("Error al crear tipo de habitación: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conexion_bd.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
