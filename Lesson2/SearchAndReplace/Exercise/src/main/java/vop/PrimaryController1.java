package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PrimaryController1 implements Initializable {
    FileChooser filVælger;
    IOFacade facade;

    @FXML
    private Label søg;

    @FXML
    private Label erstat;

    @FXML
    private TextField søgefelt;

    @FXML
    private TextField erstatfelt;

    @FXML
    private TextArea text;

    public void replaceButton(ActionEvent actionEvent) {
        String søgTekst = søgefelt.getText();
        String erstatTekst = erstatfelt.getText();
        String originalTekst = text.getText();
        String nyTekst = originalTekst.replaceAll(søgTekst, erstatTekst);
        text.setText(nyTekst);
        Collections c;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filVælger = new FileChooser();
        filVælger.setInitialDirectory(new File("."));
        facade = new IOFacade();
    }

    public void ÅbenFil(ActionEvent actionEvent) {
        text.clear();
        File inFile = filVælger.showOpenDialog(text.getScene().getWindow());
        if (inFile == null)
            return;

        String txt = facade.readFile(inFile);
        text.setText(txt);
    }

    public void GemSom(ActionEvent actionEvent) {
        File gem = filVælger.showSaveDialog(text.getScene().getWindow());
        if (gem == null)
            return;

        facade.writeFile(text.getText(), gem);
    }
}
