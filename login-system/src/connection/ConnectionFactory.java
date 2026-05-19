package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:src/database/users.db";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL);

        } catch (SQLException e) {

            System.out.println("Erro na conexão com banco de dados.");

            e.printStackTrace();

            return null;
        }
    }
}