package Dao;

import conexion.conexion_bd;
import modelos.Tarifa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class TarifaDAO {

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

    public boolean createTarifa(Tarifa tarifa) {
        String sql = "INSERT INTO Tarifas (tipoHabitacion, precioBase, descuentoPorcentaje) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tarifa.getTipoHabitacion());
            pstmt.setDouble(2, tarifa.getPrecioBase());
            pstmt.setDouble(3, tarifa.getDescuentoPorcentaje());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al crear tarifa: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }

    public Tarifa getTarifaById(int idTarifa) {
        String sql = "SELECT idTarifa, tipoHabitacion, precioBase, descuentoPorcentaje FROM Tarifas WHERE idTarifa = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Tarifa tarifa = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idTarifa);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                tarifa = new Tarifa();
                tarifa.setIdTarifa(rs.getInt("idTarifa"));
                tarifa.setTipoHabitacion(rs.getString("tipoHabitacion"));
                tarifa.setPrecioBase(rs.getDouble("precioBase"));
                tarifa.setDescuentoPorcentaje(rs.getDouble("descuentoPorcentaje"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tarifa por ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, pstmt, rs);
        }
        return tarifa;
    }

    public List<Tarifa> getAllTarifas() {
        String sql = "SELECT idTarifa, tipoHabitacion, precioBase, descuentoPorcentaje FROM Tarifas";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Tarifa> tarifas = new ArrayList<>();
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Tarifa tarifa = new Tarifa();
                tarifa.setIdTarifa(rs.getInt("idTarifa"));
                tarifa.setTipoHabitacion(rs.getString("tipoHabitacion"));
                tarifa.setPrecioBase(rs.getDouble("precioBase"));
                tarifa.setDescuentoPorcentaje(rs.getDouble("descuentoPorcentaje"));
                tarifas.add(tarifa);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tarifas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, pstmt, rs);
        }
        return tarifas;
    }

    public List<Tarifa> getTarifasByTipoHabitacion(String tipo) {
        String sql = "SELECT idTarifa, tipoHabitacion, precioBase, descuentoPorcentaje FROM Tarifas WHERE tipoHabitacion LIKE ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Tarifa> tarifas = new ArrayList<>();
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + tipo + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Tarifa tarifa = new Tarifa();
                tarifa.setIdTarifa(rs.getInt("idTarifa"));
                tarifa.setTipoHabitacion(rs.getString("tipoHabitacion"));
                tarifa.setPrecioBase(rs.getDouble("precioBase"));
                tarifa.setDescuentoPorcentaje(rs.getDouble("descuentoPorcentaje"));
                tarifas.add(tarifa);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tarifas por tipo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, pstmt, rs);
        }
        return tarifas;
    }

    public boolean updateTarifa(Tarifa tarifa) {
        String sql = "UPDATE Tarifas SET tipoHabitacion = ?, precioBase = ?, descuentoPorcentaje = ? WHERE idTarifa = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tarifa.getTipoHabitacion());
            pstmt.setDouble(2, tarifa.getPrecioBase());
            pstmt.setDouble(3, tarifa.getDescuentoPorcentaje());
            pstmt.setInt(4, tarifa.getIdTarifa());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar tarifa: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }

    public boolean deleteTarifa(int idTarifa) {
        String sql = "DELETE FROM Tarifas WHERE idTarifa = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = conexion_bd.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idTarifa);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar tarifa: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }
}
