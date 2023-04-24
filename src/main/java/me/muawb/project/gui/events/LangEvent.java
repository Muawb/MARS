package me.muawb.project.gui.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Future is class of event, here will be happen replace language for this is application.
 */

public class LangEvent implements ActionListener {

    private static final Logger log = LoggerFactory.getLogger(LangEvent.class);

    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("Event");
    }
}
