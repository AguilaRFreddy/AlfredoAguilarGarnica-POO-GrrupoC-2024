
package Usuarios;
import Utils.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono, Rol.CLIENTE);
        this.fechaRegistro = LocalDate.now(); //Trae la fecha actual de la computadora.
    }
    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }
//    @Override //Indica que se está sobre escribiendo un método, por eso sale el simbolito de crculitos azules..
//    public String mostrarInfo() {
//        return String.format("%s, Fecha registro: %s", super.mostrarInfo(), fechaRegistro);
//    }
}