package me.muawb.project.gui;

import me.muawb.project.gui.components.Backgrounds;
import me.muawb.project.gui.events.ClickEvent;
import me.muawb.project.gui.graphics.Handling;
import me.muawb.project.sound.MusicPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Main class, create main Frame and settings. Also here
 * start three threads, first play audio file. Second thread start
 * replace frame each 0.600 seconds. Last Thread control event listener,
 * create mouse listener which pull branch class.
 *
 */

public class WorkWindow {

    //Add logging in class.
    private static final Logger log = LoggerFactory.getLogger(WorkWindow.class);

    //Determine width, height and title it application.
    private static final int WIDTH = 750;
    private static final int HEIGHT = 500;
    private static final String TITLE = "MARS";

    //Main frame.
    private static JFrame frame;
    //Activation replace frame.
    private static Handling back;
    //Plays audio file.
    private static MusicPlayer player;
    //Class which have images for replace frame.
    private static Backgrounds screen;

    private static int checkSound = 0;

    /**
     * This methods allows create frame and settings configuration.
     */

    public void createFrame(){
        //Create and set configurations frame.
        frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon(this.getClass().getResource("/image/icons/icon.png")).getImage());
        frame.setVisible(true);

        log.info("Frame is created !");
    }

    /**
     * Main method it application.
     *
     * @param args
     *          argument which send in console this application.
     */

    public static void main(String[] args) {
        //Set look and feel this application.
        setLookAndFeel("Nimbus");

        //Create instance this class, and call method for create frame.
        WorkWindow work = new WorkWindow();
        work.createFrame();

        //Play sound file.
        player = MusicPlayer.init();
        playMusic();

        //Draw pre-views.
        back = new Handling();
        drawViews();

        //Call mouse listener.
        screen = new Backgrounds();
        frame.addMouseListener(new ClickEvent(frame, screen.getPreStart(), back, player));

    }

    public static void drawViews(){
        new Thread(() -> {
            //Start draw.
            back.update(frame);
            //Stop animation and start appear and disappear text.
            back.turnOn(frame);
        }).start();
    }


    /**
     * Alter look and feel it is applications onto that {@param param}.
     *
     * @param param
     *          names look and feel which you want set.
     */

    private static void setLookAndFeel(String param) {
        try {
            //Iteration on list look end feel.
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                //If param equals value of list.
                if (param.equals(info.getName())){
                    //Set look and feel.
                    UIManager.setLookAndFeel(info.getClassName());
                    log.info("Set of look and feel: \"" + param + "\"");
                }
            }
        } catch (Exception e) {
            log.info("Can't set of look and feel: \"" + param + "\"");
        }
    }

    /**
     * There happen invoked method to set volume and play music in sub thread.
     */

    private static void playMusic(){
        //Create sub thread.
        new Thread(() -> {
            log.info("Start play is music.");
            sleep(1500);
            player.setVolume(-25f);
            player.play();
            player.join();
            player.close();
            log.info("Stop play is music.");
        }).start();
    }

    /**
     * Stop active thread on definitely quantity milli seconds.
     *
     * @param millis
     *      milli second on whose must stop thread.
     */

    private static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex){
            log.error("Not invoked method sleep.", ex);
        }
    }

}
