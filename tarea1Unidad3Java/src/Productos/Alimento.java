package Productos;

public class Alimento extends Producto {
    private String caducidad;

    public Alimento(String nombre, double precio, String fechaImportacion, int stock, String caducidad) {
        super(nombre, precio, fechaImportacion, stock);
        this.caducidad = caducidad;
    }
}
