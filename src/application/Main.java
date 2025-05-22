package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega a tela de login
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml")); // Você criará Login.fxml
        primaryStage.setTitle("OnClock - Login");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}