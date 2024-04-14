package Productos;

public class Producto {
    public static int CANTIDAD_PRODUCTOS = 0;

    private String nombre;

    private double precio;

    private String fechaImportacion;

    private int numeroSerie;

    private int stock;

    public Producto(String nombre, double precio, String fechaImportacion, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        this.numeroSerie = ++this.CANTIDAD_PRODUCTOS; // Incrementa y luego asigna

    }

    public void agregarStock(int cantidad) {
        stock += cantidad;

    }

    public void eliminarStock(int cantidad) {
        if (validadStock()) {
            System.out.println("");
        } else {
            stock -= cantidad;
        }
    }

    private boolean validadStock() {
        return stock == 0 ? true : false;
    }

    public String obtenerInformacion() {
        return String.format("Nombre: %s, precio: %f, fecha importacion: %s, stock: %d, numero de serie: %d", nombre,
                precio, fechaImportacion, stock, numeroSerie);
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

}
