package me.muawb.project.gui.graphics;

import me.muawb.project.gui.components.Backgrounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;

/**
 * Here has methods for replace frame and stop replace,
 * method {@link this#turnOn(JFrame)} allows appear and disappear text
 * for background until user not click about screen.
 * Have logging.
 */

public class Handling {

    //Create logging.
    private static final Logger log = LoggerFactory.getLogger(Handling.class);

    //Provide kit a image for replace on frame.
    private Backgrounds back;

    //Determine when can appear text.
    //If bre equals false, leave from while, and show
    //network manager menu.
    private boolean bre;

    //Determine know is performed now replace frame or not.
    private boolean is = true;

    /**
     * This method check, active {@link this#update(JFrame)}
     * or not.
     *
     * @return
     *      true or false.
     */

    public boolean isActive(){
        if (is == false){
            return false;
        }
        return true;
    }

    /**
     * Start cycle which replace image on frame.
     *
     * @param frame
     *        main frame.
     */

    public void turnOn(JFrame frame){
        //Create a new object Backgrounds.
        back = new Backgrounds();
        try {
            //int type variable set.
            bre = true;
            //until equals true.
            while (bre) {
                //if variable 'bre' have value 'false'.
                //Strop cycle and exit.
                if (bre == false){
                    log.debug("Stop installing images !");
                    break;
                }
                //Set new image background.
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

    /**
     * Stop cycle which defined in method {@link this#turnOn(JFrame)}
     * and exit from it.
     */

    public void stop(){
        //Set value for variable.
        bre = false;
        log.debug("Stop installing images.");
    }

    /**
     * Here happens replace image for background in main frame.
     * Into create cycle for, which do iteration at switch.
     * In each block switch have set image.
     * Which cycle for approach in last image, method finished and close.
     *
     * @param frame
     *      main frame.
     */

    public void update(JFrame frame){
        log.debug("Start installing images !");
        //Set value for variable is true.
        is = true;
        int n = 17; // Count image.
        back = new Backgrounds();
        for (int i = 0; i <= n; i ++){
            switch (i) {
                case 0:
                    try {
                        //Set first image.
                        log.debug("Set image: " + i);
                        frame.setContentPane(back.getBack());
                        frame.validate();
                        //Wait 2000 milliseconds.
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
                    //out of cycle.
                    break;
            }
        }
    }
}
