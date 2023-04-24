package me.muawb.project.gui.events;

import me.muawb.project.gui.components.CustomJButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class implements interface the ActionListener which contain one method.
 * Method {@link this#actionPerformed(ActionEvent)} invoked when user pressed save button.
 * Here happen receive data which contain in field and put their in command, than run command in console.
 */

public class SaveEvent implements ActionListener{

    //Include logging in this class.
    private static final Logger log = LoggerFactory.getLogger(SaveEvent.class);

    //Filed contain name active network interface.
    private JTextField networkInterface;
    //Field contain ip address active network interface.
    private JTextField address;
    //Mask the network interface.
    private JTextField mask;
    //Put data from field in command line and run at console.
    private CustomJButton saver;

    //Check, fill all field or not.
    private static boolean empty = true;

    public SaveEvent(JTextField net, JTextField ip, JTextField mask, CustomJButton saver){
        this.networkInterface = net;
        this.address = ip;
        this.mask = mask;
        this.saver = saver;
    }

    /**
     * Invoked when user pressed save button.
     * @param e
     */

    /*
    No administrator rights :)
    Not Work :D
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        //Make sub thread for under process.
        new Thread(() -> {
            try {
                //If field empty, we set color for field - red. What tell about error.
                if (networkInterface.getText().isEmpty() | address.getText().isEmpty() |
                        mask.getText().isEmpty()) {
                    log.debug("null");
                    while (empty){
                        //If empty, set color - red, to field.
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

                        //Determine, what color been set.
                        empty = false;
                    }
                } else {
                    //Field not empty. Start process perform command.
                    log.debug("Execute command.");
                    //Run command in console.
                    Runtime.getRuntime().exec("sudo ifconfig" + " " + networkInterface.getText() +
                            " " + address.getText() + " " + "netmask" + " " + mask.getText());

                    //Set default color to field.
                    networkInterface.setBackground(new Color(255,255,255));
                    address.setBackground(new Color(255,255,255));
                    mask.setBackground(new Color(255,255,255));
                    log.debug("Clear color for all TextField");
                    try {
                        //Reset button
                        saver.setBackground(new Color(0, 255, 0));
                        log.debug("Button - active.");
                        Thread.sleep(1500);
                        saver.setBackground(new Color(255,255,255));
                        log.debug("Button shutdown.");
                        //Can restart set value for field.
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
