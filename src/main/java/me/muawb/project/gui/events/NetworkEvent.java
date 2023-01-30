package me.muawb.project.gui.events;

import me.muawb.project.gui.components.Backgrounds;
import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.net.Interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.NetworkInterface;

public class NetworkEvent implements ActionListener{

    private JFrame frame;
    private NetworkInterface net;
    private CustomJButton butse;
    private Backgrounds bk;
    private Interfaces ic;

    public NetworkEvent(JFrame frame, CustomJButton interfaces, NetworkInterface addr){
        this.frame = frame;
        this.butse = interfaces;
        this.net = addr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(() -> {

            bk = new Backgrounds();
            ic = new Interfaces();
            frame.setContentPane(bk.getPostStart());

            CustomJPanel panelExit = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                    120, 40, 25, 400);
            panelExit.build();
            frame.add(panelExit);

            CustomJPanel panelSaver = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                    120, 40, 600, 400);
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
                    120, 30, 260, 286);
            panelMask.build();
            frame.add(panelMask);

            CustomJPanel panelGateaway = new CustomJPanel(new GridBagLayout(), new Color(255, 255, 255),
                    120, 30, 260, 333);
            panelGateaway.build();
            frame.add(panelGateaway);

            JTextField fieldName = new JTextField();
            fieldName.setPreferredSize(new Dimension(120, 30));
            if (butse.getText() == net.getName()) {
                fieldName.setText(butse.getText());
            }
            panelName.add(fieldName);

            JTextField fieldAddress = new JTextField();
            fieldAddress.setPreferredSize(new Dimension(120, 30));
            fieldAddress.setText(ic.getInterfaces().get(net.getName()));
            panelAddress.add(fieldAddress);

            JTextField fieldMask = new JTextField();
            fieldMask.setPreferredSize(new Dimension(120, 30));
            fieldMask.setText("255.255.255.0");
            panelMask.add(fieldMask);

            JTextField fieldGateaway = new JTextField();
            fieldGateaway.setPreferredSize(new Dimension(120, 30));
            panelGateaway.add(fieldGateaway);

            CustomJButton saver = new CustomJButton("Сохранить", new Color(255, 255, 255),
                    new Font("TimesRoman", Font.BOLD, 13), 100, 40);
            saver.build();
            saver.addActionListener(new SaveEvent(fieldName, fieldAddress,
                    fieldMask, fieldGateaway, saver));
            panelSaver.add(saver);

            CustomJButton exit = new CustomJButton("Назад", new Color(255, 255, 255),
                    new Font("TimesRoman", Font.BOLD, 13), 100, 40);
            exit.build();
            exit.addActionListener(new ExitEvent(frame));
            panelExit.add(exit);

            frame.validate();

        }).start();
    }
}
