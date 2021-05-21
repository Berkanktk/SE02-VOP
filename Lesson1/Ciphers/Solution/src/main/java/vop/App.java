package vop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vop/primary.fxml"));

        stage.setTitle("Cipher");
        stage.setScene(new Scene(root, 640, 480)); //1024x768
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}