package Dao;

import modelos.Tarifa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.conexion_bd;

public class TarifaDAO {

    public boolean createTarifa(Tarifa tarifa) {
  
        String sql = "INSERT INTO Tarifas (tipoHabitacion, precioBase, descuentoPorcentaje, descripcion, tipoCondicion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conexion_bd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, tarifa.getTipoHabitacion());
            pstmt.setDouble(2, tarifa.getPrecioBase());
            pstmt.setDouble(3, tarifa.getDescuentoPorcentaje());
            pstmt.setString(4, tarifa.getDescripcion());
            pstmt.setString(5, tarifa.getTipoCondicion());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        tarifa.setIdTarifa(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al crear tarifa: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Tarifa getTarifaById(int id) {
        Tarifa tarifa = null;
        String sql = "SELECT idTarifa, tipoHabitacion, precioBase, descuentoPorcentaje, descripcion, tipoCondicion FROM Tarifas WHERE idTarifa = ?";
        try (Connection conn = conexion_bd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
         
                    tarifa = new Tarifa(
                            rs.getInt("idTarifa"),
                            rs.getString("tipoHabitacion"),
                            rs.getDouble("precioBase"),
                            rs.getDouble("descuentoPorcentaje"),
                            rs.getString("descripcion"),
                            rs.getString("tipoCondicion")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tarifa por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return tarifa;
    }

    public List<Tarifa> getAllTarifas() {
        List<Tarifa> tarifas = new ArrayList<>();
        String sql = "SELECT idTarifa, tipoHabitacion, precioBase, descuentoPorcentaje, descripcion, tipoCondicion FROM Tarifas";
        try (Connection conn = conexion_bd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
             
                tarifas.add(new Tarifa(
                        rs.getInt("idTarifa"),
                        rs.getString("tipoHabitacion"),
                        rs.getDouble("precioBase"),
                        rs.getDouble("descuentoPorcentaje"),
                        rs.getString("descripcion"),
                        rs.getString("tipoCondicion")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las tarifas: " + e.getMessage());
            e.printStackTrace();
        }
        return tarifas;
    }

    public List<Tarifa> getTarifasByTipoHabitacion(String tipoHabitacionFiltro) {
        List<Tarifa> tarifas = new ArrayList<>();
        String sql = "SELECT idTarifa, tipoHabitacion, precioBase, descuentoPorcentaje, descripcion, tipoCondicion FROM Tarifas WHERE tipoHabitacion LIKE ?";
        try (Connection conn = conexion_bd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + tipoHabitacionFiltro + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                   
                    tarifas.add(new Tarifa(
                            rs.getInt("idTarifa"),
                            rs.getString("tipoHabitacion"),
                            rs.getDouble("precioBase"),
                            rs.getDouble("descuentoPorcentaje"),
                            rs.getString("descripcion"),
                            rs.getString("tipoCondicion")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tarifas por tipo de habitación: " + e.getMessage());
            e.printStackTrace();
        }
        return tarifas;
    }

    public boolean updateTarifa(Tarifa tarifa) {
        String sql = "UPDATE Tarifas SET tipoHabitacion = ?, precioBase = ?, descuentoPorcentaje = ?, descripcion = ?, tipoCondicion = ? WHERE idTarifa = ?";
        try (Connection conn = conexion_bd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tarifa.getTipoHabitacion());
            pstmt.setDouble(2, tarifa.getPrecioBase());
            pstmt.setDouble(3, tarifa.getDescuentoPorcentaje());
            pstmt.setString(4, tarifa.getDescripcion());
            pstmt.setString(5, tarifa.getTipoCondicion());
            pstmt.setInt(6, tarifa.getIdTarifa());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar tarifa: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTarifa(int id) {
        String sql = "DELETE FROM Tarifas WHERE idTarifa = ?";
        try (Connection conn = conexion_bd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar tarifa: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
