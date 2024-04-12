package Personas;

public class Cliente {
    private int id;

    private String nombre;

    private String direccion;

    public Cliente(int i, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String obtenerInformacion(){
        return String.format("Id: %d Nombre: %s y direccion: %s", id, nombre, direccion);
    }

}