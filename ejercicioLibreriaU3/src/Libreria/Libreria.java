package Libreria;
import Usuarios.Usuario;
import java.util.ArrayList;

public class Libreria {

   // @SuppressWarnings("rawTypes") para meter cualquier cosa
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario verificarInicioSesion(String nombreusuario,String contrasena){
        for(Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombreusuario)) {
             if (usuario.getContrasena().equals(contrasena)) {
                return usuario;
             }
             return null;
            }

        }
        return null;

    }

}
