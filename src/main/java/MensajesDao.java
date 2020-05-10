
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anton
 */
public class MensajesDao {

    static Conexion db_connect = new Conexion();

    public static boolean crearMensajeDB(Mensajes mensaje) {
        boolean resultado=false;
        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement pst = null;
            try {
                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?)";
                pst = conexion.prepareStatement(query);
                pst.setString(1, mensaje.getMensaje());
                pst.setString(2, mensaje.getAutor_mensaje());
                pst.executeUpdate();
                resultado=true;
                System.out.println("Mensaje Creado OK");
            } catch (SQLException e) {
                System.out.println("Error crear Mensaje");
                System.out.println(e.getCause());
                System.out.println(e.getStackTrace());
            }
        } catch (SQLException e) {
            System.out.println("Error Conexion para insertar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        System.out.println(resultado);
        return resultado;

    }

    public static ArrayList<Mensajes> leerMensajes() {
        ArrayList<Mensajes> arregloMensajes = new ArrayList<Mensajes>();
        

        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement pst = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM mensajes";
                pst = conexion.prepareStatement(query);
                rs = pst.executeQuery();
                while (rs.next()) {
                    Mensajes consultaMensaje = new Mensajes();
                    consultaMensaje.setId_mensaje(rs.getInt(1));
                    System.out.println("ID " + rs.getInt(1));
                    //
                    consultaMensaje.setMensaje(rs.getString(2));
                    System.out.println("Mensaje " + rs.getString(2));
                    //
                    consultaMensaje.setAutor_mensaje(rs.getString(3));
                    System.out.println("Autor " + rs.getString(3));
                    //
                    consultaMensaje.setFecha_mensaje(rs.getString(4));
                    System.out.println("TimeStamp " + rs.getString(4));
                    arregloMensajes.add(consultaMensaje);

                }

                System.out.println("Mensaje Consultado  OK");
            } catch (SQLException e) {
                System.out.println("Error Consulta  Mensaje");
                System.out.println(e.getCause());
                System.out.println(e.getStackTrace());
            }
        } catch (SQLException e) {
            System.out.println("Error Conexion para insertar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        for (Mensajes arregloMensaje : arregloMensajes) {
            System.out.println("Recorriendo desde MensajesDao");
            System.out.println(arregloMensaje.getMensaje());
        }
        return arregloMensajes;

    }

    public static void borrarMensaje(int id_mensaje) {

    }

    public static void actualizarMensaje(Mensajes mensaje) {

    }
}
