import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
            if (connection != null) {
                System.out.println("Conexión con BD Establecida");
            }

        } catch (SQLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println("Error Conexion");
        }
        return connection;
    }

}
