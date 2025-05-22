package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    private FazerLogin fazerLogin = new FazerLogin();

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String email = emailField.getText();
        String senha = passwordField.getText();

        // Nota: FazerLogin atualmente tem seu próprio Scanner e imprime no console.
        // Você precisará refatorar FazerLogin para aceitar email/senha como parâmetros
        // e retornar a permissão ou um booleano indicando sucesso/falha.
        // Por enquanto, vamos simular a chamada:
        String permission = fazerLogin.fazerLoginWithCredentials(email, senha); // Você criará este método

        if (permission != null && !permission.isEmpty()) {
            messageLabel.setText("Login realizado com sucesso!");
            try {
                // Navega para o menu apropriado com base na permissão
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                if ("admin".equals(permission)) {
                    Parent adminRoot = FXMLLoader.load(getClass().getResource("MenuAdministrador.fxml"));
                    stage.setScene(new Scene(adminRoot));
                    stage.setTitle("OnClock - Administrador");
                } else if ("usuario".equals(permission)) {
                    Parent userRoot = FXMLLoader.load(getClass().getResource("MenuUsuario.fxml"));
                    stage.setScene(new Scene(userRoot));
                    stage.setTitle("OnClock - Usuário");
                }
            } catch (IOException e) {
                e.printStackTrace();
                messageLabel.setText("Erro ao carregar menu.");
            }
        } else {
            messageLabel.setText("E-mail ou senha inválidos.");
        }
    }
}