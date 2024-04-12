package Libreria;

import java.util.Scanner;

import Usuarios.Usuario;

public class Menu {
    private Libreria libreria = new Libreria();
    private Scanner leer = new Scanner(System.in);

    public void IniciarSesion() {
        boolean datosCorrectos = false;
        do {

            System.out.println("BIENVENIDO AL SISTEMA");
            System.out.println("\n Para continuar Iniciar secion");
            System.out.println("ingresa usuario");
            String usuario = leer.nextLine();
            System.out.println("ingresa contrasena");
            String contrasena = leer.nextLine();
            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contrasena);
            if (usuarioActual != null) {
                datosCorrectos = true;
                SeleccionarMenu(usuarioActual);

            } else {
                System.out.println("Usuario o contrasena incorrectos");
            }
        } while (!datosCorrectos);
    }

    // buscar funcion lambda
    private void SeleccionarMenu(Usuario usuario) {
        switch (usuario.getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();
        }
    }

    private void mostrarMenuCliente() {
        int op;
        do {

            System.out.println("1. Consultar libros");
            System.out.println("2. Consultar rentas");
            System.out.println("3. Cerrar sesión");
            System.out.println("\nIngrese opción: ");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    //
                    break;
                case 2:
                    //
                    break;

            }

        } while (op != 3);
        // cerrar sesion
    }

    private void mostrarMenuAsistente() {
        int op;
        do {
            System.out.println("\n\n---- BIENVENIDO ASISTENTE ----\n");
            System.out.println("1. Consultar libros");
            System.out.println("2. Consultar rentas");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Registrar libros");
            System.out.println("5. Consultar clientes");
            System.out.println("6. Eliminar cliente");
            System.out.println("7. Eliminar libros");
            System.out.println("8. Modificar datos de un cliente");
            System.out.println("9. Modificar datos de un libro");
            System.out.println("10. Cerrar sesión");
            op = leer.nextInt();
            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
            }

        } while (op != 10);
        // cerrando sesion
    }

    private void mostrarMenuGerente() {
        // lo mismo de asistente nomás le agregas para crear, modificar, eliminar
        // asistente y la renta de libros
        int op;
        do {
            System.out.println("\n\n---- BIENVENIDO GERENTE ----\n");
            System.out.println("1. Consultar libros");
            System.out.println("2. Consultar rentas");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Registrar libro");
            System.out.println("5. Consultar clientes");
            System.out.println("6. Eliminar cliente");
            System.out.println("7. Eliminar libros");
            System.out.println("8. Modificar datos de un cliente");
            System.out.println("9. Modificar datos de un libro");
            System.out.println("10.Crear o registrar asistente");
            System.out.println("11.Modificar asistente");
            System.out.println("12.eliminar asistente");
            System.out.println("13.Crear o registrar Renta de libros");
            System.out.println("14.Modificar renta de libros");
            System.out.println("15.eliminar renta de libros");
            System.out.println("16. cerrar Sesion");

            op = leer.nextInt();
            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:

                    break;

            }

        } while (op != 16);
        // cerrando sesion
    }
}
