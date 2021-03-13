package vop;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController2 implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image[] img = {
                new Image(getClass().getResource("fruits0.png").toString()),
                new Image(getClass().getResource("fruits1.png").toString()),
                new Image(getClass().getResource("fruits2.png").toString()),
                new Image(getClass().getResource("fruits3.png").toString()),
                new Image(getClass().getResource("fruits4.png").toString()),
                new Image(getClass().getResource("fruits5.png").toString()),
                new Image(getClass().getResource("fruits6.png").toString()),
                new Image(getClass().getResource("fruits7.png").toString()),
                new Image(getClass().getResource("fruits8.png").toString()),
                new Image(getClass().getResource("fruits9.png").toString())
        };
    }

    public void stop1(ActionEvent actionEvent) {

    }

    public void stop2(ActionEvent actionEvent) {

    }

    public void stop3(ActionEvent actionEvent) {

    }

    public void start(ActionEvent actionEvent) {

    }
}
