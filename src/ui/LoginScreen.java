package ui;

import service.AuthService;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private AuthService authService;

    public LoginScreen() {

        authService = new AuthService();

        setTitle("Sistema de Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        JLabel title = new JLabel("Login do Sistema");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(110, 20, 200, 30);

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(50, 80, 100, 25);

        usernameField = new JTextField();
        usernameField.setBounds(140, 80, 180, 25);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(50, 120, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 120, 180, 25);

        loginButton = new JButton("Entrar");
        loginButton.setBounds(140, 170, 100, 30);

        loginButton.addActionListener(e -> login());

        panel.add(title);
        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        setVisible(true);
    }

    private void login() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        String result = authService.authenticate(username, password);

        switch (result) {

            case "LOGIN_SUCCESS":

                JOptionPane.showMessageDialog(
                        this,
                        "Login realizado com sucesso!",
                        "Sucesso",
                        JOptionPane.PLAIN_MESSAGE
                );

                break;

            default:

                JOptionPane.showMessageDialog(
                        this,
                        result,
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);

                break;
        }
    }
}