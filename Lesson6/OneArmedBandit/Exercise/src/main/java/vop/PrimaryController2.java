package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController2 implements Initializable {

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Button startSpinButton;

     @FXML
     private Button stopSpin1;

    @FXML
    private Button stopSpin2;

    @FXML
    private Button stopSpin3;

    @FXML
    private Label winLabel;

    Thread td1;
    Thread td2;
    Thread td3;
    private int spinsAlive;
    Image[] img;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img = new Image[10];
        String pre = "fruits";
        String post = ".png";
        for (int i = 0; i < img.length; i++) {
            String filename = pre + i + post;
            String file = null;
            try {
                file = getClass().getResource(filename).toURI().toString();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            img[i] = new Image(file);
        }
        img1.setImage(img[1]);
        img2.setImage(img[5]);
        img3.setImage(img[8]);
    }

    @FXML
    public void spinHandler(ActionEvent actionEvent) {
        if (actionEvent.getSource() == startSpinButton){

            BanditRunnable br1 = new BanditRunnable(1,100, img1);
            td1 = new Thread(br1);
            td1.setDaemon(true);
            td1.start();
            stopSpin1.setDisable(false);

            BanditRunnable br2 = new BanditRunnable(2,120, img2);
            td2 = new Thread(br2);
            td2.setDaemon(true);
            td2.start();
            stopSpin2.setDisable(false);

            BanditRunnable br3 = new BanditRunnable(3,140, img3);
            td3 = new Thread(br3);
            td3.setDaemon(true);
            td3.start();
            stopSpin3.setDisable(false);

            startSpinButton.setDisable(true);
            winLabel.setText("Running");
        }else if (actionEvent.getSource() == stopSpin1){
            td1.interrupt();
            stopSpin1.setDisable(true);
        }else if (actionEvent.getSource() == stopSpin2) {
            td2.interrupt();
            stopSpin2.setDisable(true);
        }else if (actionEvent.getSource() == stopSpin3) {
            td3.interrupt();
            stopSpin3.setDisable(true);
        }
    }
    private synchronized void aliveCount(boolean up) {
        if (up) {
            spinsAlive++;
        } else {
            spinsAlive--;
        }

        System.out.println("Alive: " + spinsAlive);
        if (spinsAlive == 0) {
            startSpinButton.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (img1.getImage() == img2.getImage() && img1.getImage() == img3.getImage()) {
                        winLabel.setText("All 3 equals! Congratulations");
                    } else if (img1.getImage() == img2.getImage()
                            || img1.getImage() == img2.getImage()
                            || img2.getImage() == img3.getImage()) {
                        winLabel.setText("2 equals! Congratulations");
                    } else {
                        winLabel.setText("You are a LOSER!");
                    }
                }
            });
        }
    }
    public class BanditRunnable implements Runnable {

        private int i; //Index of current picture
        private long sleepTime;
        private boolean running;
        private ImageView iw;

        public BanditRunnable(int i, long sleepTime, ImageView iw)   {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
        }

        @Override
        public void run() {
            running = true;
            aliveCount(true);
            System.out.println("Threads started: " + Thread.currentThread());

            while (running) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        iw.setImage(img[i]);
                        i = (i + 1) % img.length;
                    }
                });
                synchronized (this) {
                    try {
                        //Thread.sleep(sleepTime);
                        wait(sleepTime);
                    } catch (InterruptedException ex) {
                        System.out.println("Interrupted: " + Thread.currentThread());
                        running = false;
                        aliveCount(false);
                    }
                }
            }
        }
    }
}
