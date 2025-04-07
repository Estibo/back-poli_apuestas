package dao;

import modelo.Deporte;
import conexion.Conexion;

import java.sql.*;
import java.util.*;

public class DeporteDAO {

    public void insertar(Deporte deporte) {
        try (Connection conn = Conexion.getConnection()) {
            String sql = "INSERT INTO deporte (id_deporte, nombre_deporte) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, deporte.getId());
            stmt.setString(2, deporte.getNombre());
            stmt.executeUpdate();
            System.out.println("Deporte insertado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Deporte> listar() {
        List<Deporte> deportes = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM deporte");
            while (rs.next()) {
                deportes.add(new Deporte(
                    rs.getInt("id_deporte"),
                    rs.getString("nombre_deporte")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deportes;
    }

    public void eliminar(int id) {
        try (Connection conn = Conexion.getConnection()) {
            String sql = "DELETE FROM deporte WHERE id_deporte = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Deporte eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Deporte deporte) {
        try (Connection conn = Conexion.getConnection()) {
            String sql = "UPDATE deporte SET nombre_deporte = ? WHERE id_deporte = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, deporte.getNombre());
            stmt.setInt(2, deporte.getId());
            stmt.executeUpdate();
            System.out.println("Deporte actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
