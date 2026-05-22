package service;

import dao.UserDAO;
import model.User;

public class AuthService {

    private UserDAO userDAO;

    public AuthService() {

        this.userDAO = new UserDAO();
    }

    public String authenticate(String username, String password) {

        if (username.isEmpty() || password.isEmpty()) {

            return "Preencha todos os campos.";
        }

        User user = userDAO.findByUsername(username);

        if (user == null) {

            return "Usuário não encontrado.";
        }

        if (!user.getPassword().equals(password)) {

            return "Senha incorreta.";
        }

        return "LOGIN_SUCCESS:" + user.getUsername();
    }
}