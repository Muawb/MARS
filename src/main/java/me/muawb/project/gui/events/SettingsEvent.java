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

public class SettingsEvent implements ActionListener {

    private static final Logger log = LoggerFactory.getLogger(SettingsEvent.class);

    private JFrame frame;
    private Backgrounds bk;
    private JComboBox<String> addLanguage;

    private static final String[] language = new String[]{"English", "Russian"};

    public SettingsEvent(){

    }

    public SettingsEvent(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("Click button settings.");
        bk = new Backgrounds();
        frame.setContentPane(bk.getOptions());
        frame.validate();

        CustomJPanel workPanel = new CustomJPanel(new GridBagLayout(), new Color(127,127,127),
                90, 30, 315, 180);
        workPanel.build();
        frame.add(workPanel);

        addLanguage = new JComboBox<String>(language);
        addLanguage.setPreferredSize(new Dimension(90,30));
        addLanguage.addActionListener(new LangEvent());
        addLanguage.setBackground(new Color(255,255,255));
        workPanel.add(addLanguage);

        CustomJPanel panelExit = new CustomJPanel(new GridBagLayout(), new Color(57,57,57),
                120,40,25, 400);
        panelExit.build();
        frame.add(panelExit);

        CustomJButton exit = new CustomJButton("Назад", new Color(255,255,255),
                new Font("TimesRoman", Font.BOLD, 13), 100, 40);
        exit.build();
        exit.addActionListener(new SettingsExitEvent(frame));
        panelExit.add(exit);

        frame.validate();
    }
}
