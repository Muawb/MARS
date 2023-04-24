package me.muawb.project.gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Custom class, contain a methods to create the custom button.
 * Inheritance {@link JButton} class, which describe button.
 */

public class CustomJButton extends JButton implements Factory {

    //Determine font to text for button.
    private Font size;
    //Let set color for button background.
    private Color rgb;
    //Height for button.
    private int height;
    //Width for button.
    private int width;

    public CustomJButton(String text, Color rgb, Font font, int width, int height){
        //Call constructor super class with parameter 'text'.
        super(text);
        this.rgb = rgb;
        this.size = font;
        this.width = width;
        this.height = height;
    }

    /**
     * Performing create is button with configuration which been set
     * in arguments constructor.
     */

    @Override
    public void build(){
        setFont(size);
        setBackground(rgb);
        setPreferredSize(new Dimension(width, height));

    }
}
