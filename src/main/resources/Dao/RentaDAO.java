package Dao;

import conexion.conexion_bd;
import modelos.modelorentas;
import ui.Rentas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentaDAO {
	
	public List<modelorentas> getRentasByClienteId(int clienteId) {
	    List<modelorentas> rentas = new ArrayList<>();
	    String sql = "SELECT idRenta, idReserva, idHabitacion, idCliente, fechaCheckIn, fechaCheckOut, costoTotal, estado, notas, numHuespedes FROM Rentas WHERE idCliente = ? ORDER BY fechaCheckIn DESC";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, clienteId);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            modelorentas renta = new modelorentas(
	                rs.getInt("idRenta"),
	                rs.getObject("idReserva") != null ? rs.getInt("idReserva") : null,
	                rs.getInt("idHabitacion"),
	                rs.getInt("idCliente"),
	                rs.getTimestamp("fechaCheckIn").toLocalDateTime(),
	                rs.getTimestamp("fechaCheckOut").toLocalDateTime(),
	                rs.getDouble("costoTotal"),
	                rs.getString("estado"),
	                rs.getString("notas")
	            );
	            renta.setNumHuespedes(rs.getInt("numHuespedes"));
	            rentas.add(renta);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener historial de rentas por cliente ID: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        closeResources(conn, pstmt, rs);
	    }
	    return rentas;
	}

	public modelorentas getRentaActivaByHabitacionId(int idHabitacion) {
	    modelorentas renta = null;
	    String sql = "SELECT idRenta, idReserva, idHabitacion, idCliente, fechaCheckIn, fechaCheckOut, costoTotal, estado, notas, numHuespedes FROM Rentas WHERE idHabitacion = ? AND estado = 'Activa' LIMIT 1";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, idHabitacion);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            renta = new modelorentas(
	                rs.getInt("idRenta"),
	                rs.getObject("idReserva") != null ? rs.getInt("idReserva") : null,
	                rs.getInt("idHabitacion"),
	                rs.getInt("idCliente"),
	                rs.getTimestamp("fechaCheckIn").toLocalDateTime(),
	                rs.getTimestamp("fechaCheckOut").toLocalDateTime(),
	                rs.getDouble("costoTotal"),
	                rs.getString("estado"),
	                rs.getString("notas")
	            );
	            renta.setNumHuespedes(rs.getInt("numHuespedes"));
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener renta activa por ID de habitación: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        closeResources(conn, pstmt, rs);
	    }
	    return renta;
	}

	public modelorentas getRentaById(int id) {
	    modelorentas renta = null;
	    String sql = "SELECT idRenta, idReserva, idHabitacion, idCliente, fechaCheckIn, fechaCheckOut, costoTotal, estado, notas, numHuespedes FROM Rentas WHERE idRenta = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = conexion_bd.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, id);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            renta = new modelorentas(
	                rs.getInt("idRenta"),
	                rs.getObject("idReserva") != null ? rs.getInt("idReserva") : null,
	                rs.getInt("idHabitacion"),
	                rs.getInt("idCliente"),
	                rs.getTimestamp("fechaCheckIn").toLocalDateTime(),
	                rs.getTimestamp("fechaCheckOut").toLocalDateTime(),
	                rs.getDouble("costoTotal"),
	                rs.getString("estado"),
	                rs.getString("notas")
	            );
	            renta.setNumHuespedes(rs.getInt("numHuespedes")); // <-- Aquí el número de huéspedes
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al obtener renta por ID: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        closeResources(conn, pstmt, rs);
	    }
	    return renta;
	}


    private void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conexion_bd.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔥 INSERT con numHuespedes
    public boolean createRenta(modelorentas renta) {
        String sql = "INSERT INTO Rentas (idReserva, idHabitacion, idCliente, fechaCheckIn, fechaCheckOut, costoTotal, estado, notas, numHuespedes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;

        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            if (renta.getIdReserva() != null) {
                pstmt.setInt(1, renta.getIdReserva());
            } else {
                pstmt.setNull(1, Types.INTEGER);
            }
            pstmt.setInt(2, renta.getIdHabitacion());
            pstmt.setInt(3, renta.getIdCliente());
            pstmt.setTimestamp(4, Timestamp.valueOf(renta.getFechaCheckIn()));
            pstmt.setTimestamp(5, Timestamp.valueOf(renta.getFechaCheckOut()));
            pstmt.setDouble(6, renta.getCostoTotal());
            pstmt.setString(7, renta.getEstado());
            pstmt.setString(8, renta.getNotas());
            pstmt.setInt(9, renta.getNumHuespedes()); // Agregado el número de huéspedes

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    renta.setIdRenta(generatedKeys.getInt(1));
                }
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al crear renta: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, generatedKeys);
        }
    }

    // 🔥 UPDATE con numHuespedes
    public boolean updateRenta(modelorentas renta) {
        String sql = "UPDATE Rentas SET idReserva = ?, idHabitacion = ?, idCliente = ?, fechaCheckIn = ?, fechaCheckOut = ?, costoTotal = ?, estado = ?, notas = ?, numHuespedes = ? WHERE idRenta = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            if (renta.getIdReserva() != null) {
                pstmt.setInt(1, renta.getIdReserva());
            } else {
                pstmt.setNull(1, Types.INTEGER);
            }
            pstmt.setInt(2, renta.getIdHabitacion());
            pstmt.setInt(3, renta.getIdCliente());
            pstmt.setTimestamp(4, Timestamp.valueOf(renta.getFechaCheckIn()));
            pstmt.setTimestamp(5, Timestamp.valueOf(renta.getFechaCheckOut()));
            pstmt.setDouble(6, renta.getCostoTotal());
            pstmt.setString(7, renta.getEstado());
            pstmt.setString(8, renta.getNotas());
            pstmt.setInt(9, renta.getNumHuespedes()); // Agregado
            pstmt.setInt(10, renta.getIdRenta());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar renta: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }

    // 🔥 Método para traer la última renta creada
    public modelorentas getLastRentaByClienteAndHabitacion(int clienteId, int habitacionId) {
        String sql = "SELECT * FROM Rentas WHERE idCliente = ? AND idHabitacion = ? ORDER BY idRenta DESC LIMIT 1";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        modelorentas renta = null;

        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clienteId);
            pstmt.setInt(2, habitacionId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                renta = new modelorentas(
                    rs.getInt("idRenta"),
                    rs.getInt("idReserva"),
                    rs.getInt("idHabitacion"),
                    rs.getInt("idCliente"),
                    rs.getTimestamp("fechaCheckIn").toLocalDateTime(),
                    rs.getTimestamp("fechaCheckOut").toLocalDateTime(),
                    rs.getDouble("costoTotal"),
                    rs.getString("estado"),
                    rs.getString("notas")
                );
                renta.setNumHuespedes(rs.getInt("numHuespedes")); // Agregado
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la última renta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, pstmt, rs);
        }
        return renta;
    }
    
    public List<Rentas> getAllRentas() {
        List<Rentas> rentas = new ArrayList<>();

        String sql = "SELECT * FROM rentas";

        try (Connection conn = ConexionSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Rentas renta = new Rentas();
                renta.setIdReserva(rs.getInt("id_renta"));
                renta.setIdHabitacion(rs.getInt("id_habitacion"));
                renta.setIdCliente(rs.getInt("id_cliente"));
                renta.setEstado(rs.getString("estado"));
                renta.setFechaCheckIn(rs.getTimestamp("fecha_checkin").toLocalDateTime());
                if (rs.getTimestamp("fecha_checkout") != null) {
                    renta.setFechaCheckOut(rs.getTimestamp("fecha_checkout").toLocalDateTime());
                }
                renta.setIdReserva(rs.getObject("id_reserva", Integer.class));

                rentas.add(renta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentas;
    }
    
}
