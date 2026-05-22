package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:users.db";

    public static Connection getConnection() {

        try {

            Connection connection = DriverManager.getConnection(URL);

            System.out.println("Conexão realizada com sucesso.");
            System.out.println("Banco utilizado: users.db");    

            return connection;

        } catch (SQLException e) {

            System.out.println("Erro ao conectar no banco.");

            e.printStackTrace();

            return null;
        }
    }
}