package me.muawb.project.gui.events;

import me.muawb.project.gui.WorkWindow;
import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.gui.components.NetworkButton;
import me.muawb.project.gui.graphics.Handling;
import me.muawb.project.net.ActiveInterfaces;
import me.muawb.project.sound.MusicPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * This class let set action where happen press on screen.
 * Implements {@link MouseListener}, which has five methods
 * for describe action where user press on screen.
 * {@link #mouseClicked(MouseEvent)} describe all press on screen,
 * {@link #mousePressed(MouseEvent)} describe press on screen,
 * {@link #mouseReleased(MouseEvent)} describe release from press on screen,
 * {@link #mouseEntered(MouseEvent)} describe input mouse in component,
 * {@link #mouseExited(MouseEvent)} describe out mouse with component.
 * Note: Component it is such area in active screen.
 */

public class ClickEvent implements MouseListener, NetworkButton {

    //Set logging in this is class.
    private static final Logger log = LoggerFactory.getLogger(ClickEvent.class);

    //Main frame.
    private JFrame frame;
    //Abstract class JComponent, describe such component. It is can be image.
    private JComponent component;
    //Control start and stop replace image on screen.
    private Handling playing;
    //Component panel on which put button. Button has active network interface name.
    private CustomJPanel panelNetwork;
    //This component have button with a settings.
    private CustomJPanel panelSettings;
    //Button for move to new page.
    private CustomJButton settings;
    //Active network interface.
    private ActiveInterfaces ic;
    private MusicPlayer player;

    //Determine check for start find active network interfaces.
    private boolean stop = true;

    /**
     * Parametrized constructor. With help his we dependency injection
     * in class {@link WorkWindow} and leverage his field end methods.
     *
     * @param frame
     *          main frame.
     * @param comp
     *        class with component.
     * @param h
     *      replace image on frame.
     */

    public ClickEvent(JFrame frame, JComponent comp, Handling h, MusicPlayer player){
        this.frame = frame;
        this.component = comp;
        this.playing = h;
        this.player = player;
    }

    /**
     * Check, what be event not work after activity page,
     * which show active network interfaces.
     */

    public void stop(){
        //Change variable value.
        stop = false;
    }

    /**
     * Whenever user press on screen, press blocked and
     * show page with active network interfaces.
     * Also here create button and panel, happen set image.
     *
     * @param e
     *      interface
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        //If replace image not active.
        if (!playing.isActive()) {
            //If variable value stop equals true, show new page.
            if (stop) {
                //Stop play is music.
                player.stop();
                //Set variable value to false, more will be not work this event.
                playing.stop();
                //Set component, image for background.
                frame.setContentPane(component);

                //Create panel on which will be placed button for move to new page.
                panelSettings = new CustomJPanel(new GridBagLayout(), new Color(57, 57, 57),
                        50, 50, 650, 40);
                panelSettings.build();
                frame.add(panelSettings);

                //Set icon for button.
                ImageIcon image = new ImageIcon(this.getClass().getResource("/image/icons/settings.png"));
                settings = new CustomJButton("", new Color(255,255,255), null, 50, 50);
                settings.build();
                settings.setIcon(image);
                //Set action for button.
                settings.addActionListener(new SettingsEvent(frame));
                panelSettings.add(settings);

                //Create panel for placed network interfaces.
                panelNetwork = new CustomJPanel(new GridBagLayout(), new Color(127, 127, 127),
                        350, 180, 185, 150);
                panelNetwork.build();
                frame.add(panelNetwork);
                //References to a new Object, or create object.
                ic = new ActiveInterfaces();
                List<String> namesInterfaces = ic.findNames();

                addButtonOfNames(namesInterfaces);
                frame.validate();
                log.debug("Click by frame !");
            }
            stop(); //More event don't work !
        }
    }

    /**
     * Make do iteration of {@param list} and put content onto arguments
     * {@link this#createButtonOfNames(String)}. Then add button on panel.
     *
     * @param list
     *          list of names.
     */

    @Override
    public void addButtonOfNames(List<String> list){
        for (String s : list){
            CustomJButton nButton = createButtonOfNames(s);
            panelNetwork.add(nButton);
        }
    }

    /**
     * Create button with addition configuration.
     *
     * @param name
     *      name is active of network interface.
     * @return
     *      created object.
     */

    @Override
    public CustomJButton createButtonOfNames(String name){
        CustomJButton namesButton = new CustomJButton(name, new Color(255,102,102),
                new Font("TimesRoman", Font.BOLD, 10), 60, 26);
        namesButton.build();
        namesButton.addActionListener(new NetworkEvent(frame, namesButton, name));
        return namesButton;
    }

    /**
     * Invoked which user clicked mouse on screen.
     * @param e
     */

    @Override
    public void mousePressed(MouseEvent e) { }

    /**
     * Invoked which user release press mouse from screen.
     * @param e
     */

    @Override
    public void mouseReleased(MouseEvent e) { }

    /**
     * Invoked which mouse entry in is component.
     * @param e
     */

    @Override
    public void mouseEntered(MouseEvent e) { }

    /**
     * Invoked which mouse entry in is component.
     * @param e
     */

    @Override
    public void mouseExited(MouseEvent e) { }
}
