package me.muawb.project.gui.events;

import me.muawb.project.gui.components.Backgrounds;
import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.gui.components.NetworkButton;
import me.muawb.project.net.ActiveInterfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Implements interface {@link ActionListener}, which describe press to button.
 * Here contain one method {@link this#actionPerformed(ActionEvent)}, invoked when
 * user press button. At press to button happen return to main screen.
 */

public class SettingsExitEvent implements ActionListener, NetworkButton {

    //Include in it method of logging.
    private static final Logger log = LoggerFactory.getLogger(SettingsExitEvent.class);

    //Switch between images.
    private Backgrounds bk;
    //Main frame.
    private JFrame frame;
    //Enable find the active a network interfaces and provide data about of their.
    private ActiveInterfaces ic;
    //Panel onto which located button called 'settings'.
    private CustomJPanel panelSettings;
    //Panel onto which located button, which contain name of active a network interfaces.
    private CustomJPanel panel;
    private CustomJButton settings;

    public SettingsExitEvent(JFrame frame){
        this.frame = frame;
    }

    /**
     * Invoked when user press button.
     * Here set background, create panel and button. Display names a network interfaces.
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        bk = new Backgrounds();
        //Set background.
        frame.setContentPane(bk.getPreStart());
        //Clear frame from component.
        frame.validate();

        panelSettings = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                50, 50, 650, 40);
        panelSettings.build();
        frame.add(panelSettings);

        //Set icon for button called 'settings'.
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

        ic = new ActiveInterfaces();
        List<String> names = ic.findNames();

        addButtonOfNames(names);
        frame.validate();
        log.info("Click button exit.");
    }

    /**
     * Make do iteration of {@param list} and put content onto arguments
     * {@link this#createButtonOfNames(String)}. Then add button on panel.
     *
     * @param list
     *      list of names.
     */

    @Override
    public void addButtonOfNames(List<String> list){
        for (String s : list){
            CustomJButton nButton = createButtonOfNames(s);
            panel.add(nButton);
        }
    }

    /**
     * Create button and addition configuration
     *
     * @param name
     *          names if active of network interfaces.
     * @return
     *       created object.
     */

    @Override
    public CustomJButton createButtonOfNames(String name){
        CustomJButton buttonOfNames = new CustomJButton(name, new Color(255,102,102),
                new Font("TimesRoman", Font.BOLD, 10), 60, 26);
        buttonOfNames.build();
        buttonOfNames.addActionListener(new NetworkEvent(frame, buttonOfNames, name));
        return buttonOfNames;
    }
}
