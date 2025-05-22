package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuUsuarioController {

    // Se você tiver elementos com fx:id no FXML, declare-os aqui:
    // @FXML private Label welcomeLabel;

    // Método para o botão "Bater Ponto"
    @FXML
    private void handleBaterPontoButton(ActionEvent event) {
        System.out.println("Botão Bater Ponto clicado!");
        // Lógica para bater o ponto
        BaterPonto baterPonto = new BaterPonto();
        baterPonto.baterPonto(); // Chame seu método existente
        // Feedback ao usuário na GUI (ex: uma mensagem em um Label)
        // Lembre-se que baterPonto() imprime no console, você pode refatorá-lo para retornar um boolean ou String de status.
        // Por exemplo: if (baterPonto.baterPontoGUI()) { messageLabel.setText("Ponto batido!"); }
    }

    // Método para o botão "Consultar Horas"
    @FXML
    private void handleConsultarHorasButton(ActionEvent event) {
        System.out.println("Botão Consultar Horas clicado!");
        // Lógica para consultar horas
        ConsultarHoras consultarHoras = new ConsultarHoras();
        // A classe ConsultarHoras precisa ser refatorada para retornar uma lista de pontos em vez de imprimir.
        // List<String> pontos = consultarHoras.getHorasRegistradas(); // Exemplo
        // Então, você exibiria essa lista em uma TableView ou TextArea na sua GUI.
    }

    // Método para o botão "Sair do Sistema"
    @FXML
    private void handleSairButton(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close(); // Fecha a janela atual
    }
}