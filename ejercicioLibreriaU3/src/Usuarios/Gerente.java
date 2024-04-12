package Usuarios;
import Utils.Rol;

public class Gerente extends Usuario{
    private Double sueldo;
    private String RFC;
    private String INE;

    public Gerente(String nombre, String apellido, String telefono,
                         Double sueldo, String RFC, String INE,String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.GERENTE,nombreUsuario, contrasena);
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }
    @Override
    public String toString(){
        return String.format("%s, Sueldo: %.3f, RFC: %s, INE: %s "+
                super.toString(), sueldo, RFC, INE);
    }
}

