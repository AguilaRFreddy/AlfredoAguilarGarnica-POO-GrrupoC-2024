package TiendaYSistema;

import Productos.*;
import Personas.*;

import java.time.LocalDate;
import java.util.ArrayList;
// import java.util.Random;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Maquillaje> productosMaquillaje = new ArrayList<Maquillaje>();
    private ArrayList<Limpieza> productosLimpieza = new ArrayList<Limpieza>();
    private ArrayList<Alimento> productosAlimento = new ArrayList<Alimento>();
    private ArrayList<Electrodomestico> productosElectrodomestico = new ArrayList<Electrodomestico>();
    private ArrayList<String> Compra = new ArrayList<String>();
    private ArrayList<String> IDsCliente = new ArrayList<String>();
    private ArrayList<String> serieLArrayList = new ArrayList<String>();
    // private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Scanner leer = new Scanner(System.in);

    ////////////////////////////////////////////////////////////////////////
    public void registrarCliente() {

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa la direccion: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, direccion);
        clientes.add(cliente);

        System.out.println("¡Cliente registrado con exito!");
    }

    ////////////////////////////////////////////////////////////////////////
    public void consultarClientes() {
        System.out.println("¨*** CLIENTES ***");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.obtenerInformacion());
        }
    }

    ////////////////////////////////////////////////////////////////////////
    // public int validarIdCliente() {
    // boolean idValido = true;
    // int id = random.nextInt(1000) + 1;

    // do {
    // for (Cliente cliente : clientes) {
    // if (id == cliente.getId()) {
    // idValido = false;
    // id = random.nextInt(1000) + 1;
    // }
    // }

    // } while (!idValido);

    // return id;
    // }

    ////////////////////////////////////////////////////////////////////////
    public ArrayList<String> registrarDatosComun() {
        ArrayList<String> datos = new ArrayList<String>();
        System.out.print("Ingresa un nombre: ");
        String nombre = scanner.nextLine();
        datos.add(nombre);

        System.out.print("Ingresa el precio: ");
        double precio = scanner.nextDouble();
        datos.add(String.valueOf(precio));

        scanner.nextLine();
        System.out.print("Ingresa la fecha de importacion: ");
        String fecha = scanner.nextLine();
        datos.add(fecha);

        System.out.print("Ingresa el stock del producto: ");
        int Stock = scanner.nextInt();
        datos.add(String.valueOf(Stock));

        return datos;
    }

    ////////////////////////////////////////////////////////////////////////
    public void registrarProductoLimpieza() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria limpieza ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresa la marca: ");
        String marca = scanner.nextLine();

        Limpieza limpieza = new Limpieza(nombre, precio, fecha, stock, marca);

        productosLimpieza.add(limpieza);

    }

    ////////////////////////////////////////////////////////////////////////
    public void consultarProductosLimpieza() {
        System.out.println("*** PRODUCTOS LIMPIEZA*\n");
        for (Limpieza producto : productosLimpieza) {
            System.out.println(producto.obtenerInformacionConMarca());
        }
    }

    ////////////////////////////////////////////////////////////////////////
    public void registrarProductoElecrodomestico() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Electrodomestico ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresa la Voltaje: ");
        String voltaje = scanner.nextLine();

        Electrodomestico electrodomestico = new Electrodomestico(nombre, precio, fecha, stock, voltaje);

        productosElectrodomestico.add(electrodomestico);

    }

    ////////////////////////////////////////////////////////////////////////
    public void consultarProductosElectrodomestico() {
        System.out.println("\n**PRODUCTOS ELECTRODOMESTICO\n");
        for (Electrodomestico producto : productosElectrodomestico) {
            System.out.println(producto.obtenerInformacionConVoltaje());
        }
    }

    ////////////////////////////////////////////////////////////////////////
    public void registrarProductoAlimento() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Alimento ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresa la caducidad: ");
        String caducidad = scanner.nextLine();

        Alimento alimento = new Alimento(nombre, precio, fecha, stock, caducidad);

        productosAlimento.add(alimento);
    }

    ////////////////////////////////////////////////////////////////////////
    public void consultarProductosAlimento() {
        System.out.println("\n*** PRODUCTOS ALIMENTO*\n");
        for (Alimento producto : productosAlimento) {
            System.out.println(producto.obtenerInformacionConCaducidad());
        }
    }

    ////////////////////////////////////////////////////////////////////////
    public void registrarProductoMaquillaje() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Maquillaje ***");

        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresa la color: ");
        String color = scanner.nextLine();

        Maquillaje maquillaje = new Maquillaje(nombre, precio, fecha, stock, color);

        productosMaquillaje.add(maquillaje);
    }

    ////////////////////////////////////////////////////////////////////////
    public void consultarProductosMaquillaje() {
        System.out.println("\n*** PRODUCTOS MAQUILLAJE*\n");
        for (Maquillaje producto : productosMaquillaje) {
            System.out.println(producto.obtenerInformacionConColor());

        }
    }

    ////////////////////////////////////////////////////////////////////////
    public void aumentarStock() {
        System.out.println("Ingrese el numero de serie del producto:....");
        int numeroSerie = scanner.nextInt();
        for (int i = 0; i < productosLimpieza.size(); i++) {
            Limpieza limpiezaNumeroDeSerie = productosLimpieza.get(i);
            if (limpiezaNumeroDeSerie.getNumeroSerie() == numeroSerie) {
                System.out.println("Se encontro el producto solicitado en la clase limpieza");
                System.out.println("Ingresa la cantidad a aumentar stock");
                int cantidad = scanner.nextInt();
                limpiezaNumeroDeSerie.agregarStock(cantidad);
                return;

            }
        } // aqui termina de buscar en limpieza
        for (int i = 0; i < productosElectrodomestico.size(); i++) {
            Electrodomestico electrodomesticoNumeroDeSerie = productosElectrodomestico.get(i);
            if (electrodomesticoNumeroDeSerie.getNumeroSerie() == numeroSerie) {
                System.out.println("Se encontro el producto solicitado en la clase Electrodomestico");
                System.out.println("Ingresa la cantidad a aumentar stock");
                int cantidad = scanner.nextInt();
                electrodomesticoNumeroDeSerie.agregarStock(cantidad);
                return;

            }
        }
        for (int i = 0; i < productosAlimento.size(); i++) {
            Alimento alimentoNumeroDeSerie = productosAlimento.get(i);
            if (alimentoNumeroDeSerie.getNumeroSerie() == numeroSerie) {
                System.out.println("Se encontro el producto solicitado en la clase Alimento");
                System.out.println("Ingresa la cantidad a aumentar stock");
                int cantidad = scanner.nextInt();
                alimentoNumeroDeSerie.agregarStock(cantidad);
                return;

            }
        }
        for (int i = 0; i < productosMaquillaje.size(); i++) {
            Maquillaje maquillajeNumeroDeSerie = productosMaquillaje.get(i);
            if (maquillajeNumeroDeSerie.getNumeroSerie() == numeroSerie) {
                System.out.println("Se encontro el producto solicitado en la clase Maquillaje");
                System.out.println("Ingresa la cantidad a aumentar stock");
                int cantidad = scanner.nextInt();
                maquillajeNumeroDeSerie.agregarStock(cantidad);
                return;
            }
        }
        System.out.println("No se encontro el producto");

    }// aumentar stock
     ////////////////////////////////////////////////////////////////////////

    public void realizarRegistrarCompra() {
        System.out.println("Ingresa Id del cliente: ...");
        int validarIdCliente = scanner.nextInt();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente referenciaCliente = clientes.get(i);

            if (referenciaCliente.getId() == validarIdCliente) {
                LocalDate fechaActual = LocalDate.now();
                String fechaFormateada = String.format("%d/%02d/%02d", fechaActual.getYear(),
                        fechaActual.getMonthValue(), fechaActual.getDayOfMonth());

                System.out.println("El cliente fue encontrado");
                System.out.println("Ingresa numero de serie del producto: ...");
                int validarNumSerie = scanner.nextInt();
                int op;
                do {

                    System.out.println("Ingresa la caregoria");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomestico");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- maquillaje");
                    System.out.println("5.- SALIR");
                    op = scanner.nextInt();
                    switch (op) {
                        case 1:

                            for (int j = 0; j < productosLimpieza.size(); j++) {
                                Limpieza limpiezaCompra = productosLimpieza.get(j);
                                if (limpiezaCompra.getNumeroSerie() == validarNumSerie) {

                                    System.out.println("Ingresa la cantidad a comprar");
                                    int cantidad = scanner.nextInt();
                                    if (cantidad <= limpiezaCompra.getStock()) {
                                        limpiezaCompra.eliminarStock(cantidad);
                                        String nombre = referenciaCliente.getNombre();
                                        String producto = limpiezaCompra.getNombre();
                                        String compraRealizada = String.format(
                                                "El usuario %s, ha comprado %d, %s en la fecha %s ",
                                                nombre, cantidad, producto, fechaFormateada);
                                        Compra.add(compraRealizada);
                                        System.out.println("Compra realizada");

                                        String id = String.valueOf(validarIdCliente);
                                        IDsCliente.add(id);
                                        String nSerie = String.valueOf(validarNumSerie);
                                        serieLArrayList.add(nSerie);
                                        return;

                                    }

                                }
                            }
                            System.out.println("No se encontro el producto de limpieza");

                            break;
                        case 2:

                            for (int j = 0; j < productosElectrodomestico.size(); j++) {
                                Electrodomestico electrodomesticoCompra = productosElectrodomestico.get(j);
                                if (electrodomesticoCompra.getNumeroSerie() == validarNumSerie) {

                                    System.out.println("Ingresa la cantidad a comprar");
                                    int cantidad = scanner.nextInt();
                                    if (cantidad <= electrodomesticoCompra.getStock()) {
                                        electrodomesticoCompra.eliminarStock(cantidad);
                                        String nombre = referenciaCliente.getNombre();
                                        String producto = electrodomesticoCompra.getNombre();
                                        String compraRealizada = String.format(
                                                "El usuario %s, ha comprado %d, %s, en la fecha %s",
                                                nombre, cantidad, producto, fechaFormateada);
                                        Compra.add(compraRealizada);

                                        System.out.println("Compra realizada");

                                        String id = String.valueOf(validarIdCliente);
                                        IDsCliente.add(id);
                                        String nSerie = String.valueOf(validarNumSerie);
                                        serieLArrayList.add(nSerie);
                                        return;
                                    }

                                }
                            }
                            System.out.println("No se enconto el producto electrodomestico");

                            break;
                        case 3:

                            for (int j = 0; j < productosAlimento.size(); j++) {
                                Alimento alimentoCompra = productosAlimento.get(j);
                                if (alimentoCompra.getNumeroSerie() == validarNumSerie) {

                                    System.out.println("Ingresa la cantidad a comprar");
                                    int cantidad = scanner.nextInt();
                                    if (cantidad <= alimentoCompra.getStock()) {
                                        alimentoCompra.eliminarStock(cantidad);
                                        String nombre = referenciaCliente.getNombre();
                                        String producto = alimentoCompra.getNombre();
                                        String compraRealizada = String.format(
                                                "El usuario %s, ha comprado %d, %s, en la fecha %s",
                                                nombre, cantidad, producto, fechaFormateada);
                                        Compra.add(compraRealizada);

                                        System.out.println("Compra realizada");

                                        String id = String.valueOf(validarIdCliente);
                                        IDsCliente.add(id);
                                        String nSerie = String.valueOf(validarNumSerie);
                                        serieLArrayList.add(nSerie);
                                        return;
                                    }

                                }
                            }
                            System.out.println("No se enconto el producto Alimento");

                            break;
                        case 4:

                            for (int j = 0; j < productosMaquillaje.size(); j++) {
                                Maquillaje maquillajeCompra = productosMaquillaje.get(j);
                                if (maquillajeCompra.getNumeroSerie() == validarNumSerie) {

                                    System.out.println("Ingresa la cantidad a comprar");
                                    int cantidad = scanner.nextInt();
                                    if (cantidad <= maquillajeCompra.getStock()) {
                                        maquillajeCompra.eliminarStock(cantidad);
                                        String nombre = referenciaCliente.getNombre();
                                        String producto = maquillajeCompra.getNombre();
                                        String compraRealizada = String.format(
                                                "El usuario %s, ha comprado %d, %s, en la fecha %s",
                                                nombre, cantidad, producto, fechaFormateada);
                                        Compra.add(compraRealizada);

                                        System.out.println("Compra realizada");

                                        String id = String.valueOf(validarIdCliente);
                                        IDsCliente.add(id);
                                        String nSerie = String.valueOf(validarNumSerie);
                                        serieLArrayList.add(nSerie);
                                        return;
                                    }

                                }
                            }
                            System.out.println("No se enconto el producto maquillaje");

                            break;
                    }

                } while (op != 5);

            }
        }
        System.out.println("Compra terminada");
    }

    ////////////////////////////////////////////////////////////////////////
    public void consultarCompras() {
        for (int i = 0; i < Compra.size(); i++) {
            System.out.println(Compra.get(i));
        }

    }

    ////////////////////////////////////////////////////////////////////////
    public void eliminarProducto() {
        System.out.println("Ingresa el numero de serie del producto:");
        String eliminar = leer.nextLine();

        for (int i = 0; i < serieLArrayList.size(); i++) {
            String cadena = serieLArrayList.get(i);
            if (cadena.equals(eliminar)) {
                System.out.println("El producto ya ha sido comprado, imposible eliminar");
                return;
            }
        }

        int idEliminacion = Integer.parseInt(eliminar);

        for (int i = 0; i < productosLimpieza.size(); i++) {
            Limpieza limpiezaNumeroDeSerie = productosLimpieza.get(i);
            if (limpiezaNumeroDeSerie.getNumeroSerie() == idEliminacion) {
                System.out.println("Se encontro el producto solicitado en la clase limpieza");

                for (int j = 0; j < productosLimpieza.size(); j++) {
                    Limpieza limpieza = productosLimpieza.get(j);
                    String atributoSerie = String.valueOf(limpieza.getNumeroSerie());
                    if (atributoSerie.equals(eliminar)) {
                        productosLimpieza.remove(j); // Eliminar el objeto
                        j--; // Ajustar el índice después de eliminar un elemento
                        System.out.println("Producto eliminado");
                        return;
                    }
                }

            }

        }
        for (int i = 0; i < productosElectrodomestico.size(); i++) {
            Electrodomestico electroNumeroDeSerie = productosElectrodomestico.get(i);
            if (electroNumeroDeSerie.getNumeroSerie() == idEliminacion) {
                System.out.println("Se encontro el producto solicitado en la clase electrodomestico");
                // Busca que se encuentre el elemento

                for (int j = 0; j < productosElectrodomestico.size(); j++) {
                    Electrodomestico electrodomestico = productosElectrodomestico.get(j);
                    String atributoSerie = String.valueOf(electrodomestico.getNumeroSerie());
                    if (atributoSerie.equals(eliminar)) {
                        productosElectrodomestico.remove(j); // Eliminar el objeto
                        j--; // Ajustar el índice después de eliminar un elemento
                        System.out.println("Producto eliminado");
                        return;
                    }
                }

            }

        }
        for (int i = 0; i < productosAlimento.size(); i++) {
            Alimento alimentoNumeroDeSerie = productosAlimento.get(i);
            if (alimentoNumeroDeSerie.getNumeroSerie() == idEliminacion) {
                System.out.println("Se encontro el producto solicitado en la clase alimento");

                for (int j = 0; j < productosAlimento.size(); j++) {
                    Alimento alimento = productosAlimento.get(j);
                    String atributoSerie = String.valueOf(alimento.getNumeroSerie());
                    if (atributoSerie.equals(eliminar)) {
                        productosAlimento.remove(j); // Eliminar el objeto
                        j--; // Ajustar el índice después de eliminar un elemento
                        System.out.println("Producto eliminado");
                        return;
                    }
                }

            }

        }
        for (int i = 0; i < productosMaquillaje.size(); i++) {
            Maquillaje maquillajeNumeroDeSerie = productosMaquillaje.get(i);
            if (maquillajeNumeroDeSerie.getNumeroSerie() == idEliminacion) {
                System.out.println("Se encontro el producto solicitado en la clase maquillaje");
                // Busca que se encuentre el elemento

                for (int j = 0; j < productosMaquillaje.size(); j++) {
                    Maquillaje maquillaje = productosMaquillaje.get(j);
                    String atributoSerie = String.valueOf(maquillaje.getNumeroSerie());
                    if (atributoSerie.equals(eliminar)) {
                        productosMaquillaje.remove(j); // Eliminar el objeto
                        j--; // Ajustar el índice después de eliminar un elemento
                        System.out.println("Producto eliminado");
                        return;
                    }
                }

            }

        }

        System.out.println("No se encontro el producto");

    }

    ////////////////////////////////////////////////////////////////////////
    public void eliminarCliente() {
        System.out.println("Ingresa el Id del cliente:");
        String eliminar = leer.nextLine();

        for (int i = 0; i < IDsCliente.size(); i++) {
            String cadena = IDsCliente.get(i);
            if (cadena.equals(eliminar)) {
                System.out.println("El cliente ya ha realizado una compra");
            }
        } // el cliente no esta registrado con una compra o el cliente no existe

        int intEliminar = Integer.parseInt(eliminar);

        for (int i = 0; i < clientes.size(); i++) {
            Cliente clientebuscar = clientes.get(i);
            if (clientebuscar.getId() == intEliminar) {
                System.out.println("Se encontro el cliente");

                for (int j = 0; j < clientes.size(); j++) {
                    Cliente cliente = clientes.get(j); /// referencia al objeto clientes posicion j
                    String idString = String.valueOf(cliente.getId());// pasar a cadena para comparar
                    if (idString.equals(eliminar)) {
                        clientes.remove(j); // Eliminar el objeto
                        j--; // Ajustar el índice después de eliminar un elemento
                        System.out.println("Producto eliminado");
                        return;
                    }
                }

            }

        }
        System.out.println("El cliente no ha sido encontrado");

    }
    ////////////////////////////////////////////////////////////////////////
}