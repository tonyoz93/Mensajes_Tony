
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anton
 */
public class MensajesService {

    static Scanner teclado = new Scanner(System.in);
    static Mensajes registro = new Mensajes();

    public static boolean crearMensaje() {
        System.out.println("Mensaje a enviar...");
        //String mensaje = teclado.nextLine();
        String mensaje;
        System.out.println("Autor del mensaje...");
        //String autor = teclado.nextLine();
        String autor = "";
        return MensajesDao.crearMensajeDB(registro);
    }

    public static ArrayList<Mensajes> listarMensajes() {
        ArrayList<Mensajes> listador = new ArrayList<Mensajes>();
        listador = MensajesDao.leerMensajes();
        for (Mensajes mensajes : listador) {
            System.out.println("Mensaje en Listar"+mensajes.getMensaje());
            listador.get(1).getId_mensaje();
        }
        
        return listador;

    }

    public static void borrarMensaje() {

    }

    public static void editarMensaje() {

    }
}
