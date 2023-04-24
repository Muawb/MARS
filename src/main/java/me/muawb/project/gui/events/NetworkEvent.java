package me.muawb.project.gui.events;

import me.muawb.project.gui.components.Backgrounds;
import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.net.ActiveInterfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.NetworkInterface;

/**
 * Class action listener, implements interface {@link ActionListener} and contain of method for
 * handling a event. Method {@link #actionPerformed(ActionEvent)} invoked when user click mouse to screen.
 * When user click to screen, display panel which contain field for a set is configuration for
 * network interfaces. Specifically is name, ip address, mask and destination.
 */

public class NetworkEvent implements ActionListener{

    //Main frame.
    private JFrame frame;
    private String net;
    private CustomJButton butse;
    //Switch image.
    private Backgrounds bk;
    //Find is active a network interfaces.
    private ActiveInterfaces ic;

    public NetworkEvent(JFrame frame, CustomJButton interfaces, String addr){
        this.frame = frame;
        this.butse = interfaces;
        this.net = addr;
    }

    /**
     * Invoked when user click mouse on screen.
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        //Create sub thread
        new Thread(() -> {

            bk = new Backgrounds();
            ic = new ActiveInterfaces();
            //Set background.
            frame.setContentPane(bk.getPostStart());

            CustomJPanel panelExit = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                    120, 40, 20, 400);
            panelExit.build();
            frame.add(panelExit);

            CustomJPanel panelSaver = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                    120, 40, 590, 400);
            panelSaver.build();
            frame.add(panelSaver);

            CustomJPanel panelName = new CustomJPanel(new GridBagLayout(), new Color(255, 255, 255),
                    120, 30, 430, 172);
            panelName.build();
            frame.add(panelName);

            CustomJPanel panelAddress = new CustomJPanel(new GridBagLayout(), new Color(255, 255, 255),
                    120, 30, 260, 237);
            panelAddress.build();
            frame.add(panelAddress);

            CustomJPanel panelMask = new CustomJPanel(new GridBagLayout(), new Color(255, 255, 255),
                    120, 30, 260, 300);
            panelMask.build();
            frame.add(panelMask);

            JTextField fieldName = new JTextField();
            fieldName.setPreferredSize(new Dimension(120, 30));
            //If name button equals network interface name.
            if (butse.getText() == net) {
                //Set for field.
                fieldName.setText(butse.getText());
            }
            panelName.add(fieldName);

            JTextField fieldAddress = new JTextField();
            fieldAddress.setPreferredSize(new Dimension(120, 30));
            fieldAddress.setText(ic.findIpAddress().get(net));
            panelAddress.add(fieldAddress);

            JTextField fieldMask = new JTextField();
            fieldMask.setPreferredSize(new Dimension(120, 30));
            fieldMask.setText("255.255.255.0");
            panelMask.add(fieldMask);

            CustomJButton saver = new CustomJButton("Сохранить", new Color(255, 255, 255),
                    new Font("TimesRoman", Font.BOLD, 11), 100, 35);
            saver.build();
            saver.addActionListener(new SaveEvent(fieldName, fieldAddress,
                    fieldMask, saver));
            panelSaver.add(saver);

            CustomJButton exit = new CustomJButton("Назад", new Color(255, 255, 255),
                    new Font("TimesRoman", Font.BOLD, 11), 70, 35);
            exit.build();
            exit.addActionListener(new ExitEvent(frame));
            panelExit.add(exit);

            frame.validate();

        }).start();
    }
}
