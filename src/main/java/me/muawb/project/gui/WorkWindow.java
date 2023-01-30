package me.muawb.project.gui;

import me.muawb.project.gui.components.Backgrounds;
import me.muawb.project.gui.events.ClickEvent;
import me.muawb.project.gui.events.SettingsEvent;
import me.muawb.project.gui.graphics.Handling;
import me.muawb.project.sound.Turntable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;

public class WorkWindow {

    private static final Logger log = LoggerFactory.getLogger(WorkWindow.class);

    private static final int WIDTH = 750;
    private static final int HEIGH = 500;
    private static final String TITLE = "MARS";

    private static JFrame frame;
    private static Handling back;
    private static Turntable play;
    private static Backgrounds screen;
    private static SettingsEvent lang;

    public void createFrame(){
        frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WIDTH, HEIGH));
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon(this.getClass().getResource("/image/icons/icon.png")).getImage());
        frame.setVisible(true);
        log.info("Frame is created");
    }

    public JFrame getFrame(){
        return frame;
    }

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        WorkWindow work = new WorkWindow();
        work.createFrame();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                play = new Turntable("/sound/vavilov.mp3");
                play.play();
                play.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            back = new Handling();
            back.update(frame);
            back.turnOn(frame);
        }).start();

        new Thread(() -> {
            screen = new Backgrounds();
            frame.addMouseListener(new ClickEvent(frame, screen.getPreStart(), back));
        }).start();
    }
}
