package service;

import dao.UserDAO;
import model.User;
import security.PasswordHasher;

public class AuthService {

    private UserDAO userDAO;

    public AuthService() {

        this.userDAO = new UserDAO();
    }

    public static final String INVALID_CREDENTIALS = "Usuário ou senha inválidos";

    /*
     * Hash válido de uma senha descartável. Usado quando o usuário não existe,
     * para que o tempo de resposta seja parecido e não revele quais usuários existem.
     */
    private static final String DUMMY_HASH = PasswordHasher.hash("senha-descartavel");

    public String authenticate(String username, String password) {

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {

            return "Preencha todos os campos.";
        }

        User user = userDAO.findByUsername(username);

        // Mesma mensagem para usuário inexistente e senha incorreta
        if (user == null) {

            PasswordHasher.verify(password, DUMMY_HASH);

            return INVALID_CREDENTIALS;
        }

        if (!PasswordHasher.verify(password, user.getPassword())) {

            return INVALID_CREDENTIALS;
        }

        return "LOGIN_SUCCESS: " + user.getUsername();
    }
}
