package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Apuesta;

public class ApuestaDAO {
    private Connection conexion;

    public ApuestaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarApuesta(Apuesta apuesta) {
        String sql = "INSERT INTO apuesta (id_apuesta, marcador, gano_b, empate, valor_min, valor_max, valor_apostado, id_usuario, id_encuentro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, apuesta.getId());
            stmt.setString(2, apuesta.getMarcador());
            stmt.setString(3, apuesta.getGano_b());
            stmt.setString(4, apuesta.getEmpate());
            stmt.setString(5, apuesta.getValor_min());
            stmt.setString(6, apuesta.getValor_max());
            stmt.setString(7, apuesta.getValor_apostado());
            stmt.setString(8, apuesta.getId_usuario());
            stmt.setString(9, apuesta.getId_encuentro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Apuesta> obtenerApuesta() {
        List<Apuesta> apuestas = new ArrayList<>();
        String sql = "SELECT * FROM apuesta";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                apuestas.add(new Apuesta(
                        rs.getInt("id_apuesta"),
                        rs.getString("marcador"),
                        rs.getString("gano_b"),
                        rs.getString("empate"),
                        rs.getString("valor_min"),
                        rs.getString("valor_max"),
                        rs.getString("valor_apostado"),
                        rs.getString("id_usuario"),
                        rs.getString("id_encuentro")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apuestas;
    }

    public void actualizarApuesta(Apuesta apuesta) {
        String sql = "UPDATE apuesta SET marcador=?, gano_b=?, empate=?, valor_min=?, valor_max=?, valor_apostado=?, id_usuario=?, id_encuentro=? WHERE id_apuesta=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, apuesta.getMarcador());
            stmt.setString(2, apuesta.getGano_b());
            stmt.setString(3, apuesta.getEmpate());
            stmt.setString(4, apuesta.getValor_min());
            stmt.setString(5, apuesta.getValor_max());
            stmt.setString(6, apuesta.getValor_apostado());
            stmt.setString(7, apuesta.getId_usuario());
            stmt.setString(8, apuesta.getId_encuentro());
            stmt.setInt(9, apuesta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarApuesta(int id) {
        String sql = "DELETE FROM apuesta WHERE id_apuesta=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}