package me.muawb.project.gui.graphics;

import me.muawb.project.gui.components.Backgrounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;

public class Handling {

    private static final Logger log = LoggerFactory.getLogger(Handling.class);

    private Backgrounds back;

    private boolean bre;
    private boolean is = true;

    public boolean isActive(){
        if (is == false){
            return false;
        }
        return true;
    }

    public void turnOn(JFrame frame){
        back = new Backgrounds();
        try {
            bre = true;
            while (bre) {
                if (bre == false){
                    log.debug("Stop installing images !");
                    break;
                }
                frame.setContentPane(back.getStart());
                frame.validate();
                Thread.sleep(600);
                log.info("Image start.png loaded.");
                if (bre == false){
                    break;
                }
                frame.setContentPane(back.getUnstart());
                frame.validate();
                Thread.sleep(600);
                log.info("Image unstart.png loaded.");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void stop(){
        bre = false;
        log.debug("Stop installing images.");
    }

    public void update(JFrame frame){
        log.debug("Start installing images !");
        is = true;
        int n = 17; // количество картинок
        back = new Backgrounds();
        for (int i = 0; i <= n; i ++){
            switch (i) {
                case 0:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack());
                        frame.validate();
                        Thread.sleep(2000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack2());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack3());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack4());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack5());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack6());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack7());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack8());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack9());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack10());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack11());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack12());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 12:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack13());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 13:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack14());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 14:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack15());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 15:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack16());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 16:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack17());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 17:
                    try {
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack18());
                        frame.validate();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    is = false;
                    break;
            }
        }
    }
}
