package TiendaYSistema;


import java.util.Scanner;

public class Sistema {
    private final String CONTRASEÑA = "qwerty";
    private Scanner scanner = new Scanner(System.in);
    private Tienda tienda = new Tienda();

    public void ejecutarPrograma() {
        boolean contraseñaValida = false;

        do {
            System.out.println("*** BIENVENIDO ***");
            System.out.print("INGRESA LA CONTRASEÑA PARA PODER ACCEDER AL SISTEMA: ");

            String contraseña = scanner.nextLine();

            if (validarContraseña(contraseña)) {
                contraseñaValida = true;
                mostrarMenuSistema();
            } else {
                System.out.println("Contraseña invalida intenta de nuevo.\n");
            }
        } while (!contraseñaValida);
    }

    private boolean validarContraseña(String contraseña) {
        return contraseña.equals(CONTRASEÑA);

    }

    private void mostrarMenuSistema() {

        int opcion = 0;

        do {
            System.out.println("ELIGE UNA OPCION PARA CONTINUAR");
            System.out.println("*** BIENVENIDOS ***");
            System.out.println("1.- Agregar cliente");
            System.out.println("2.- Agregar producto");
            System.out.println("3.- Añadir a stock");
            System.out.println("4.- Realizar Compra");
            System.out.println("5.- Listar clientes");
            System.out.println("6.- Listar productos");
            System.out.println("7.- Consultar productos por categoria");
            System.out.println("8.- Consultar compras");
            System.out.println("9.- Consultar total de productos y clientes");
            System.out.println("10.- Eliminar productos");
            System.out.println("11.- Eliminar clientes");
            System.out.println("12.- Salir");

            System.out.print("Ingresa la opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                ////////////////////////////////////////////////////////////////////////
                case 1:
                    // System.out.println("1.- Agregar cliente");

                    tienda.registrarCliente();

                    break;
                ////////////////////////////////////////////////////////////////////////
                case 2:
                    // System.out.println("2.- Agregar producto");

                    System.out.println("Ingresa el tipo de producto que deseas agregar: ");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- Maquillaje");
                    int opcionProducto = scanner.nextInt();

                    switch (opcionProducto) {
                        case 1:
                            tienda.registrarProductoLimpieza();

                            break;
                        case 2:
                            tienda.registrarProductoElecrodomestico();
                            break;

                        case 3:
                            tienda.registrarProductoAlimento();
                            break;

                        case 4:
                            tienda.consultarProductosMaquillaje();
                            break;

                        default:
                            break;
                    }

                    break;
                ////////////////////////////////////////////////////////////////////////
                case 3:
                    // System.out.println("3.- Añadir a stock");
                    tienda.aumentarStock();

                    break;
                ////////////////////////////////////////////////////////////////////////
                case 4:
                    // System.out.println("4.- Disminuir Stock");
                    tienda.realizarRegistrarCompra();
                    break;
                ////////////////////////////////////////////////////////////////////////
                case 5:
                    // System.out.println("5.- Listar clientes");
                    tienda.consultarClientes();

                    break;
                ////////////////////////////////////////////////////////////////////////
                case 6:
                    // System.out.println("6.- Listar productos");
                    tienda.consultarProductosLimpieza();
                    tienda.consultarProductosElectrodomestico();
                    tienda.consultarProductosAlimento();
                    tienda.consultarProductosMaquillaje();

                    break;
                ////////////////////////////////////////////////////////////////////////
                case 7:
                    // System.out.println("7.- Consultar productos por categoria");

                    System.out.println("Ingresa el tipo de producto que deseas consultar");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos ");
                    System.out.println("3.- Alimento ");
                    System.out.println("4.- Maquillaje");

                    int opcionProductoConsulta = scanner.nextInt();

                    switch (opcionProductoConsulta) {
                        case 1:
                            tienda.consultarProductosLimpieza();
                            break;
                        case 2:
                            tienda.consultarProductosElectrodomestico();
                            break;
                        case 3:
                            tienda.consultarProductosAlimento();
                            break;
                        case 4:
                            tienda.consultarProductosMaquillaje();
                            break;
                        default:
                            break;

                    }

                    break;
                ////////////////////////////////////////////////////////////////////////
                case 8:
                    // System.out.println("8.- Consultar compras");
                    tienda.consultarCompras();
                    break;
                ////////////////////////////////////////////////////////////////////////
                case 9:
                    // System.out.println("9.- Consultar total de productos y clientes");
                    tienda.consultarClientes();
                    tienda.consultarProductosLimpieza();
                    tienda.consultarProductosElectrodomestico();
                    tienda.consultarProductosAlimento();
                    tienda.consultarProductosMaquillaje();
                    break;
                ////////////////////////////////////////////////////////////////////////
                case 10:
                    // System.out.println("10.- Eliminar productos");
                    tienda.eliminarProducto();
                    break;
                ////////////////////////////////////////////////////////////////////////
                case 11:
                    // System.out.println("11.- Eliminar clientes");
                    tienda.eliminarCliente();
                    break;
                ////////////////////////////////////////////////////////////////////////
            }

        } while (opcion != 12);
    }
}