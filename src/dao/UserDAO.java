package dao;

import connection.ConnectionFactory;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User findByUsername(String username) {

        String sql = "SELECT * FROM users WHERE username = ?";

        Connection connection = null;

        try {

            connection = ConnectionFactory.getConnection();

            /*
             * Verifica se a conexão falhou
             */
            if (connection == null) {

                System.out.println("Falha ao conectar com banco.");

                return null;
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, username);

                try (ResultSet resultSet = statement.executeQuery()) {

                    if (resultSet.next()) {

                        User user = new User();

                        user.setId(resultSet.getInt("id"));
                        user.setUsername(resultSet.getString("username"));
                        // Armazena o hash "iter$salt$hash", nunca a senha em texto puro
                        user.setPassword(resultSet.getString("password"));

                        return user;
                    }
                }
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar usuário.");

            e.printStackTrace();

        } finally {

            try {

                if (connection != null) {

                    connection.close();
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        return null;
    }
}