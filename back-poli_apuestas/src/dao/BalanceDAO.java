package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Balance;

public class BalanceDAO {
    private Connection conexion;

    public BalanceDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarBalance(Balance balance) {
        String sql = "INSERT INTO balance (id_balance, porcentaje_ganancia, total_apostado, total_ganadores, ganancia_jugador, id_apuesta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, balance.getId());
            stmt.setString(2, balance.getPorcentaje_ganancia());
            stmt.setString(3, balance.getTotal_apostado());
            stmt.setString(4, balance.getTotal_ganadores());
            stmt.setString(5, balance.getGanancia_jugador());
            stmt.setString(6, balance.getId_apuesta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Balance> obtenerBalance() {
        List<Balance> balances = new ArrayList<>();
        String sql = "SELECT * FROM balance";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                balances.add(new Balance(
                        rs.getInt("id_balance"),
                        rs.getString("porcentaje_ganancia"),
                        rs.getString("total_apostado"),
                        rs.getString("total_ganadores"),
                        rs.getString("ganancia_jugador"),
                        rs.getString("id_apuesta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balances;
    }

    public void actualizarBalance(Balance balance) {
        String sql = "UPDATE balance SET porcentaje_ganancia=?, total_apostado=?, total_ganadores=?, ganancia_jugador=?, id_apuesta=? WHERE id_balance=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, balance.getPorcentaje_ganancia());
            stmt.setString(2, balance.getTotal_apostado());
            stmt.setString(3, balance.getTotal_ganadores());
            stmt.setString(4, balance.getGanancia_jugador());
            stmt.setString(5, balance.getId_apuesta());
            stmt.setInt(6, balance.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarBalance(int id) {
        String sql = "DELETE FROM balance WHERE id_balance=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}