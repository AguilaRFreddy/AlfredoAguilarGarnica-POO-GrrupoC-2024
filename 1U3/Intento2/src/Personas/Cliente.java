package Personas;

public class Cliente {
    private int id;

    private String nombre;
    private static int contadorClientes = 0;
    private String direccion;

    public Cliente( String nombre, String direccion) {
        this.id = ++contadorClientes;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String obtenerInformacion() {
        return String.format("Id: %d Nombre: %s y direccion: %s", id, nombre, direccion);
    }

    public String getNombre() {
        return nombre;
    }

}
