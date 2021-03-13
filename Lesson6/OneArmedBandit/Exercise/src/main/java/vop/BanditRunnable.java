package vop;

import javafx.scene.image.ImageView;

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

    Thread td1 = new Thread();
    Thread td2 = new Thread();
    Thread td3 = new Thread();

    @Override
    public void run() {
        // Code the animation here....
    }
}