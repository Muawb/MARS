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
 * Event class, which implements interface {@link ActionListener}.
 * Contain one method {@link this#actionPerformed(ActionEvent)}, which invoked
 * when user click to button. At this time happen switch screen with settings
 * on main screen, it contains panel with network interfaces.
 */

public class ExitEvent implements ActionListener, NetworkButton {

    //Include in this class logging.
    private static final Logger log = LoggerFactory.getLogger(ExitEvent.class);

    //Main frame.
    private JFrame frame;
    //Switch images.
    private Backgrounds bk;
    private CustomJPanel panel;
    //Find active network interfaces.
    private ActiveInterfaces ic;
    private CustomJPanel panelSettings;
    private CustomJButton settings;

    public ExitEvent(JFrame frame){
        this.frame = frame;
    }

    /**
     * Invoked when user click to button.Here happen replace screen.
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        bk = new Backgrounds();
        //Set image for background.
        frame.setContentPane(bk.getPreStart());

        //Create panel on whose will be contains of button with a settings.
        panelSettings = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                50, 50, 650, 40);
        panelSettings.build();
        frame.add(panelSettings);

        //Set image icon for button.
        ImageIcon image = new ImageIcon(this.getClass().getResource("/image/icons/settings.png"));
        settings = new CustomJButton("", new Color(255,255,255), null, 50, 50);
        settings.build();
        settings.setIcon(image);
        settings.addActionListener(new SettingsEvent(frame));
        panelSettings.add(settings);

        //Create panel for button which contain name a active of network interfaces.
        panel = new CustomJPanel(new GridBagLayout(), new Color(127, 127, 127),
                350, 180, 185, 150);
        panel.build();
        frame.add(panel);
        //Create object.
        ic = new ActiveInterfaces();
        List<String> namesInterfaces = ic.findNames();

        addButtonOfNames(namesInterfaces);
        frame.validate();
        log.debug("Click button exit.");
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
     * Create button and addition configuration.
     *
     * @param name
     *          name is active of network interfaces.
     * @return
     *      created object.
     */

    @Override
    public CustomJButton createButtonOfNames(String name){
        CustomJButton button = new CustomJButton(name, new Color(255,102,102),
                new Font("TimesRoman", Font.BOLD, 10), 60, 26);
        button.build();
        button.addActionListener(new NetworkEvent(frame, button, name));

        return button;
    }
}
