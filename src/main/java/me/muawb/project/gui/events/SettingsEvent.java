package me.muawb.project.gui.events;

import me.muawb.project.gui.components.Backgrounds;
import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class event, implements interface {@link ActionListener}, which contain
 * one method which invoked when user click mouse to button.
 * In method {@link this#actionPerformed(ActionEvent)} create {@link JComboBox}
 * which determine option language for application.
 *
 * ********* NOT WORK *********
 * Will be remake at linux in soon !
 */

public class SettingsEvent implements ActionListener {

    //Include in class logging.
    private static final Logger log = LoggerFactory.getLogger(SettingsEvent.class);

    //Main frame.
    private JFrame frame;
    //Switch between images.
    private Backgrounds bk;
    //Switch language for this application.
    private JComboBox<String> addLanguage;

    //Options chose language.
    private static final String[] language = new String[]{"English", "Russian"};

    public SettingsEvent(){

    }

    public SettingsEvent(JFrame frame){
        this.frame = frame;
    }

    /**
     * Invoked when user press button 'Settings'.
     * Here create window which contain panel, combo box and button for exit.
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        bk = new Backgrounds();
        frame.setContentPane(bk.getOptions());
        //Screen window before draw.
        frame.validate();

        //Panel for combo box.
        CustomJPanel workPanel = new CustomJPanel(new GridBagLayout(), new Color(127,127,127),
                90, 30, 315, 180);
        workPanel.build();
        frame.add(workPanel);

        //JComboBox enabled choose language for this application.
        addLanguage = new JComboBox<String>(language);
        addLanguage.setPreferredSize(new Dimension(90,30));
        addLanguage.addActionListener(new LangEvent());
        addLanguage.setBackground(new Color(255,255,255));
        workPanel.add(addLanguage);

        //panel for button exit.
        CustomJPanel panelExit = new CustomJPanel(new GridBagLayout(), new Color(57,57,57),
                120,40,20, 400);
        panelExit.build();
        frame.add(panelExit);

        //Button exit.
        CustomJButton exit = new CustomJButton("Назад", new Color(255,255,255),
                new Font("TimesRoman", Font.BOLD, 11), 70, 35);
        exit.build();
        exit.addActionListener(new SettingsExitEvent(frame));
        panelExit.add(exit);

        //Clear screen.
        frame.validate();
        log.info("Click button settings.");
    }
}
