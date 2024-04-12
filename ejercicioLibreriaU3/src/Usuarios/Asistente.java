package Usuarios;
import Utils.Rol;

import java.time.LocalDate;

public class Asistente extends Usuario {
    private LocalDate fechaInicio;
    private Double sueldo;
    private String RFC;
    private String INE;

    public Asistente(String nombre, String apellido, String telefono,
                     LocalDate fechaInicio, Double sueldo, String RFC, String INE,String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.ASISTENTE,nombreUsuario, contrasena);
        this.fechaInicio = fechaInicio;
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }
    @Override
    public String toString(){
        return String.format("%s, Fecha de ingreso: %s, Sueldo: %.3f, RFC: %s, INE: %s "+
                super.toString(), fechaInicio, sueldo, RFC, INE);
    }
}
