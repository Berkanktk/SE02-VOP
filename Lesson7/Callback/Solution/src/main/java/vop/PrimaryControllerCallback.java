package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryControllerCallback implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) throws URISyntaxException {
        if (event.getSource() == startButton) {
            facade = new FacadeWithCallback(this); //Creates a new instance of FacadeWithCallBack and passes PrimaryController as a parameter.
            facade.start(); //Starts the new instance of the FacadeWithCallBack thread
            startButton.setDisable(true); //Disables the startButton
            stopButton.setDisable(false); //Enables the stopButton
        } else {
            facade.interrupt(); //Calls Interrupt() on the FacadeWithCallBack instance
            startButton.setDisable(false);
            stopButton.setDisable(true);
        }
    }

    @Override
    public void updateMessage(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textArea.appendText(message + "\n");
                if (!facade.isAlive()) {
                    stopButton.fire();
                }
            }
        });
    }

    @Override
    public void updateImages(File i1, File i2) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                die1view.setImage(new Image(i1.toURI().toString()));
                die2view.setImage(new Image(i2.toURI().toString()));
            }
        });
    }
}