package dao;

import modelo.Deporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeporteDAO {
    private Connection conexion;

    public DeporteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarDeporte(Deporte deporte) {
        String sql = "INSERT INTO deporte (id_deporte, nombre_deporte) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, deporte.getId());
            stmt.setString(2, deporte.getNombre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Deporte> obtenerDeportes() {
        List<Deporte> deportes = new ArrayList<>();
        String sql = "SELECT * FROM deporte";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                deportes.add(new Deporte(rs.getInt("id_deporte"), rs.getString("nombre_deporte")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deportes;
    }

    public void actualizarDeporte(Deporte deporte) {
        String sql = "UPDATE deporte SET nombre_deporte=? WHERE id_deporte=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, deporte.getNombre());
            stmt.setInt(2, deporte.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDeporte(int id) {
        String sql = "DELETE FROM deporte WHERE id_deporte=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}