package dao;

import modelo.Usuario;
import conexion.Conexion;

import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    public void insertar(Usuario usuario) {
        try (Connection conn = Conexion.getConnection()) {
            String sql = "INSERT INTO usuario (id_usuario, nombre_usuario, contrasena_usuario, identificacion_usuario, correo_usuario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getIdentificacion());
            stmt.setString(5, usuario.getCorreo());
            stmt.executeUpdate();
            System.out.println("Usuario insertado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre_usuario"),
                    rs.getString("contrasena_usuario"),
                    rs.getString("identificacion_usuario"),
                    rs.getString("correo_usuario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // métodos actualizar, eliminar pueden agregarse aquí
}
