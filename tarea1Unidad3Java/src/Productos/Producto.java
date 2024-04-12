package Productos;

public class Producto {
    public static int CANTIDAD_PRODUCTOS = 0;

    private String nombre;

    private double precio;

    private String fechaImportacion;

    private int numeroSerie;

    private int stock;

    public Producto(String nombre, double precio, String fechaImportacion, int stock) {
        
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        this.numeroSerie = this.CANTIDAD_PRODUCTOS += 1;
        this.CANTIDAD_PRODUCTOS = this.CANTIDAD_PRODUCTOS += 1;

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
    public String obtenerInformacion(){
        return String.format("Nombre: %s, precio: %f, fecha importacion: %s, stock: %d, numero de serie: %d", nombre, precio, fechaImportacion, stock, numeroSerie);
    }
}
