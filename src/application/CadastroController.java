package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML private TextField nomeField;
    @FXML private TextField emailField;
    @FXML private PasswordField senhaField;
    @FXML private ChoiceBox<String> permissaoChoiceBox;
    @FXML private Label messageLabel;

    private Cadastro cadastro = new Cadastro();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        permissaoChoiceBox.setItems(FXCollections.observableArrayList("admin", "usuario"));
        permissaoChoiceBox.setValue("usuario"); // Valor padrão
    }

    @FXML
    private void handleCadastrarButtonAction(ActionEvent event) {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String senha = senhaField.getText();
        String permissao = permissaoChoiceBox.getValue();

        // validação da criação da senha do cadastro

        if (!nome.matches("^[a-zA-Zá-úÁ-Ú\\s]+$")) {
            messageLabel.setText("Erro: O nome deve conter apenas letras.");
            return;
        }

        if (senha.length() < 4 || senha.length() > 12) {
            messageLabel.setText("Erro: A senha deve ter entre 4 e 12 caracteres.");
            return;
        }
        if (!senha.matches(".*[a-zA-Z].*")) {
            messageLabel.setText("Erro: A senha deve conter ao menos uma letra.");
            return;
        }
        if (!senha.matches(".*[0-9].*")) {
            messageLabel.setText("Erro: A senha deve conter ao menos um número.");
            return;
        }
        if (!senha.matches(".*[!@#$%^&()+=\\-].*")) {
            messageLabel.setText("Erro: A senha deve conter ao menos um caractere especial.");
            return;
        }

        if (!EmailValidator.isValidEmail(email)) {
            messageLabel.setText("Erro: Email inválido.");
            return;
        }

        // Chama o método refatorado de Cadastro
        try {
            // Assumindo que você refatorou Cadastro.cadastrarUsuario para ser mais granular ou retornar status
            // Para demonstração, vamos assumir uma versão simplificada de chamar a lógica interna de Cadastro
            cadastro.cadastrarUsuario(nome, senha, email, permissao); // Você precisa criar este método em Cadastro.java que não usa scanner
            messageLabel.setText("Usuário cadastrado com sucesso!");
            messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
            // Limpa os campos
            nomeField.clear();
            emailField.clear();
            senhaField.clear();
        } catch (Exception e) {
            messageLabel.setText("Erro ao cadastrar usuário: " + e.getMessage());
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
        }
    }
}