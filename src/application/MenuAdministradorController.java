package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuAdministradorController {

    // Se você tiver elementos com fx:id no FXML, declare-os aqui:
    // @FXML private Label welcomeLabel;

    // Método para o botão "Cadastrar Usuário"
    @FXML
    private void handleCadastrarUsuarioButton(ActionEvent event) {
        System.out.println("Botão Cadastrar Usuário clicado!");
        // Exemplo de como abrir uma nova tela de cadastro (se tiver uma)
        try {
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("CadastroUsuario.fxml")); // Supondo que você criou CadastroUser.fxml
            stage.setScene(new Scene(root));
            stage.setTitle("OnClock - Cadastro de Usuário");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Mostrar erro na GUI ou logar
        }
    }

    // Métodos para outras opções do menu, seguindo a lógica do seu MenuAdministrador.java original
    @FXML
    private void handleGestaoAcessosButton(ActionEvent event) {
        System.out.println("Você escolheu Gestão de acessos");
        // Implemente a lógica ou abra uma nova tela
    }

    @FXML
    private void handleConsultarHorasButton(ActionEvent event) {
        System.out.println("Você escolheu Consultar horas");
        // Implemente a lógica, por exemplo, chamar ConsultarHoras e exibir em uma TableView
    }

    @FXML
    private void handleAlterarHoraButton(ActionEvent event) {
        System.out.println("Você escolheu Alterar hora");
        // Implemente a lógica ou abra uma nova tela
    }

    @FXML
    private void handleValidarOcorrenciasButton(ActionEvent event) {
        System.out.println("Você escolheu Validar ocorrências");
        // Implemente a lógica ou abra uma nova tela
    }

    @FXML
    private void handleExportarRelatorioButton(ActionEvent event) {
        System.out.println("Você escolheu Exportar relatório");
        // Implemente a lógica ou abra uma nova tela
    }

    @FXML
    private void handlePreferenciasButton(ActionEvent event) {
        System.out.println("Você escolheu Preferências");
        // Implemente a lógica ou abra uma nova tela (como você tinha Preferencias.java)
    }

    // Método para o botão "Sair do Sistema"
    @FXML
    private void handleSairButton(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close(); // Fecha a janela atual
    }
}