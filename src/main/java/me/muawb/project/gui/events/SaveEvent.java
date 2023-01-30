package me.muawb.project.gui.events;

import me.muawb.project.gui.components.CustomJButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveEvent implements ActionListener{

    private static final Logger log = LoggerFactory.getLogger(SaveEvent.class);

    private JTextField networkInterface;
    private JTextField address;
    private JTextField mask;
    private JTextField gateAway;
    private CustomJButton saver;

    private static boolean empty = true;

    public SaveEvent(JTextField net, JTextField ip, JTextField mask, JTextField gateAway, CustomJButton saver){
        this.networkInterface = net;
        this.address = ip;
        this.mask = mask;
        this.gateAway = gateAway;
        this.saver = saver;
    }

    /*
    No administrator rights :)
    Not Work :D
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(() -> {
            try {
                if (networkInterface.getText().isEmpty() | address.getText().isEmpty() |
                        mask.getText().isEmpty() | gateAway.getText().isEmpty()) {
                    log.debug("null");
                    while (empty){
                        if (networkInterface.getText().isEmpty()){
                            networkInterface.setBackground(new Color(225,0,0));
                            log.debug("Set color red for networkInterface.");
                        }

                        if (address.getText().isEmpty()){
                            address.setBackground(new Color(225,0,0));
                            log.debug("Set color red for address.");
                        }

                        if (mask.getText().isEmpty()){
                            mask.setBackground(new Color(225,0,0));
                            log.debug("Set color red for mask.");
                        }

                        if (gateAway.getText().isEmpty()){
                            gateAway.setBackground(new Color(225,0,0));
                            log.debug("Set color red for gateAway.");
                        }
                        empty = false;
                    }
                } else {
                    log.debug("Execute command.");
                    Runtime.getRuntime().exec("netsh interface ip set address" + " " + networkInterface.getText() +
                            " " + "static" + " " + address.getText() + " " + mask.getText() + " " + gateAway.getText());

                    networkInterface.setBackground(new Color(255,255,255));
                    address.setBackground(new Color(255,255,255));
                    mask.setBackground(new Color(255,255,255));
                    gateAway.setBackground(new Color(255,255,255));
                    log.debug("Clear color for all TextField");
                    try {
                        saver.setBackground(new Color(0, 255, 0));
                        log.debug("Button - active.");
                        Thread.sleep(1500);
                        saver.setBackground(new Color(255,255,255));
                        log.debug("Button shutdown.");
                        empty = true;
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }).start();
    }
}
