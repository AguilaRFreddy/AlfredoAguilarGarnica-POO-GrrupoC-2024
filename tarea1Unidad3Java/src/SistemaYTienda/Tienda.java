package SistemaYTienda;
import Productos.*;    
import Personas.*;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Maquillaje> productosMaquillaje = new ArrayList<Maquillaje>();
    private ArrayList<Limpieza> productosLimpieza = new ArrayList<Limpieza>();
    private ArrayList<Alimento> productosAlimento = new ArrayList<Alimento>();
    private ArrayList<Electrodomestico> productosElectrodomestico = new ArrayList<Electrodomestico>();
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Scanner leer = new Scanner(System.in);

    public void registrarCliente() {
        int id = validarIdCliente();
        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa la direccion: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, direccion);
        clientes.add(cliente);
        
        System.out.println("¡Cliente registrado con exito!");
    }

    public void consultarClientes() {
        System.out.println("¨*** CLIENTES ***");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.obtenerInformacion());
        }
    }

    public int validarIdCliente() {
        boolean idValido = true;
        int id = random.nextInt(1000) + 1;

        do {
            for (Cliente cliente : clientes) {
                if (id == cliente.getId()) {
                    idValido = false;
                    id = random.nextInt(1000) + 1;
                }
            }

        } while (!idValido);

        return id;
    }

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

    public void consultarProductosLimpieza() {
        System.out.println("*** PRODUCTOS LIMPIEZA***");
        for (Limpieza producto : productosLimpieza) {
            System.out.println(producto.obtenerInformacionConMarca());
        }
    }
}

