package main;

import conexion.ConexionBD;
import dao.DeporteDAO;
import dao.UsuarioDAO;
import modelo.Deporte;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            DeporteDAO deporteDAO = new DeporteDAO(conexion);

            Usuario usuario = new Usuario(1, "Juan Perez", "1234", "juan@example.com", "12345678");
            usuarioDAO.insertarUsuario(usuario);
            System.out.println("Usuarios: " + usuarioDAO.obtenerUsuarios());

            Deporte deporte = new Deporte(1, "Fútbol");
            deporteDAO.insertarDeporte(deporte);
            System.out.println("Deportes: " + deporteDAO.obtenerDeportes());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
