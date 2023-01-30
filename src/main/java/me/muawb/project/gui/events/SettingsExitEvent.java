package me.muawb.project.gui.events;

import me.muawb.project.gui.components.Backgrounds;
import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.net.Interfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsExitEvent implements ActionListener {

    private static final Logger log = LoggerFactory.getLogger(SettingsExitEvent.class);

    private Backgrounds bk;
    private JFrame frame;
    private Interfaces ic;
    private CustomJPanel panelSettings;
    private CustomJPanel panel;
    private CustomJButton settings;

    public SettingsExitEvent(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bk = new Backgrounds();
        ic = new Interfaces();
        frame.setContentPane(bk.getPreStart());
        frame.validate();

        panelSettings = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                50, 50, 650, 40);
        panelSettings.build();
        frame.add(panelSettings);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/image/icons/settings.png"));
        settings = new CustomJButton("", new Color(255,255,255), null, 50, 50);
        settings.build();
        settings.setIcon(icon);
        settings.addActionListener(new SettingsEvent(frame));
        panelSettings.add(settings);

        panel = new CustomJPanel(new GridBagLayout(), new Color(127, 127, 127),
                350, 180, 185, 150);
        panel.build();
        frame.add(panel);
        ic.showNetworkInterfaces(panel);
        frame.validate();
        log.info("Click button exit.");
    }
}
