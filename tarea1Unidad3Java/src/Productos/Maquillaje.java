package Productos;

public class Maquillaje extends Producto {
    private String color;

    public Maquillaje(String nombre, double precio, String fechaImportacion, int stock, String color) {
        super(nombre, precio, fechaImportacion, stock);
        this.color = color;
    }
}
