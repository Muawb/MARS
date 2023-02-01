package me.muawb.project.gui.events;

import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.gui.graphics.Handling;
import me.muawb.project.net.Interfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickEvent implements MouseListener {

    private static final Logger log = LoggerFactory.getLogger(ClickEvent.class);

    private JFrame frame;
    private JComponent component;
    private Handling playing;
    private CustomJPanel panelNetwork;
    private CustomJPanel panelSettings;
    private CustomJButton settings;
    private Interfaces ic;

    private boolean stop = true;

    public ClickEvent(JFrame frame, JComponent comp, Handling h){
        this.frame = frame;
        this.component = comp;
        this.playing = h;
    }

    public void stop(){
        stop = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!playing.isActive()) {
            if (stop) {
                ic = new Interfaces();
                playing.stop();
                frame.setContentPane(component);

                panelSettings = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                        50, 50, 650, 40);
                panelSettings.build();
                frame.add(panelSettings);
                ImageIcon image = new ImageIcon(this.getClass().getResource("/image/icons/settings.png"));
                settings = new CustomJButton("", new Color(255,255,255), null, 50, 50);
                settings.build();
                settings.setIcon(image);
                settings.addActionListener(new SettingsEvent(frame));
                panelSettings.add(settings);
                panelNetwork = new CustomJPanel(new GridBagLayout(), new Color(127, 127, 127),
                        350, 180, 185, 150);
                panelNetwork.build();
                frame.add(panelNetwork);
                ic.showNetworkInterfaces(panelNetwork);
                frame.validate();
                log.debug("Click by frame !");
            }
            stop();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
