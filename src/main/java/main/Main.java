package main;

import dao.UsuarioDAO;
import dao.DeporteDAO;
import modelo.Usuario;
import modelo.Deporte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DeporteDAO deporteDAO = new DeporteDAO();

        while (true) {
            System.out.println("1. Insertar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Insertar deporte");
            System.out.println("4. Listar deportes");
            System.out.println("0. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    System.out.print("Identificación: ");
                    String identificacion = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    usuarioDAO.insertar(new Usuario(id, nombre, contrasena, identificacion, correo));
                }
                case 2 -> usuarioDAO.listar().forEach(u -> System.out.println(u.getNombre()));
                case 3 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nombre del deporte: ");
                    String nombre = scanner.nextLine();
                    deporteDAO.insertar(new Deporte(id, nombre));
                }
                case 4 -> deporteDAO.listar().forEach(d -> System.out.println(d.getNombre()));
                case 0 -> System.exit(0);
                default -> System.out.println("Opción inválida");
            }
        }
    }
}
