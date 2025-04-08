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
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Gestion de usuarios");
            System.out.println("2. Gestion de deportes");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            int principal = scanner.nextInt();
            scanner.nextLine();

            switch (principal) {
                case 1 -> {
                    int opcion;
                    do {
                        System.out.println("\n--- USUARIOS ---");
                        System.out.println("1. Insertar usuario");
                        System.out.println("2. Listar usuarios");
                        System.out.println("3. Actualizar usuario");
                        System.out.println("4. Eliminar usuario");
                        System.out.println("0. Atras");
                        System.out.print("Elige una opcion: ");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1 -> {
                                System.out.print("ID: ");
                                int id = scanner.nextInt(); scanner.nextLine();
                                System.out.print("Nombre: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Contrasena: ");
                                String contrasena = scanner.nextLine();
                                System.out.print("Identificacion: ");
                                String identificacion = scanner.nextLine();
                                System.out.print("Correo: ");
                                String correo = scanner.nextLine();
                                usuarioDAO.insertar(new Usuario(id, nombre, contrasena, identificacion, correo));
                            }
                            case 2 -> usuarioDAO.listar().forEach(u -> {
                                System.out.println("ID: " + u.getId());
                                System.out.println("Nombre: " + u.getNombre());
                                System.out.println("Contraseña: " + u.getContrasena());
                                System.out.println("Identificación: " + u.getIdentificacion());
                                System.out.println("Correo: " + u.getCorreo());
                                System.out.println("-------------------------");
                            });
                            case 3 -> {
                                System.out.print("ID del usuario a actualizar: ");
                                int id = scanner.nextInt(); scanner.nextLine();
                                System.out.print("Nuevo nombre: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Nueva contrasena: ");
                                String contrasena = scanner.nextLine();
                                System.out.print("Nueva identificacion: ");
                                String identificacion = scanner.nextLine();
                                System.out.print("Nuevo correo: ");
                                String correo = scanner.nextLine();
                                usuarioDAO.actualizar(new Usuario(id, nombre, contrasena, identificacion, correo));
                            }
                            case 4 -> {
                                System.out.print("ID del usuario a eliminar: ");
                                int id = scanner.nextInt(); scanner.nextLine();
                                usuarioDAO.eliminar(id);
                            }
                        }
                    } while (opcion != 0);
                }

                case 2 -> {
                    int opcion;
                    do {
                        System.out.println("\n--- DEPORTES ---");
                        System.out.println("1. Insertar deporte");
                        System.out.println("2. Listar deportes");
                        System.out.println("3. Actualizar deporte");
                        System.out.println("4. Eliminar deporte");
                        System.out.println("0. Atras");
                        System.out.print("Elige una opcion: ");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1 -> {
                                System.out.print("ID: ");
                                int id = scanner.nextInt(); scanner.nextLine();
                                System.out.print("Nombre del deporte: ");
                                String nombre = scanner.nextLine();
                                deporteDAO.insertar(new Deporte(id, nombre));
                            }
                            case 2 -> deporteDAO.listar().forEach(d -> System.out.println(d.getId() + " - " + d.getNombre()));
                            case 3 -> {
                                System.out.print("ID del deporte a actualizar: ");
                                int id = scanner.nextInt(); scanner.nextLine();
                                System.out.print("Nuevo nombre del deporte: ");
                                String nombre = scanner.nextLine();
                                deporteDAO.actualizar(new Deporte(id, nombre));
                            }
                            case 4 -> {
                                System.out.print("ID del deporte a eliminar: ");
                                int id = scanner.nextInt(); scanner.nextLine();
                                deporteDAO.eliminar(id);
                            }
                        }
                    } while (opcion != 0);
                }

                case 0 -> {
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                }

                default -> System.out.println("Opcion invalida");
            }
        }
    }
}