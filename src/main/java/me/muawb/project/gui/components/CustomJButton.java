package me.muawb.project.gui.components;

import javax.swing.*;
import java.awt.*;

public class CustomJButton extends JButton implements Factory {

    private Font size;
    private Color rgb;
    private int heigh;
    private int width;

    public CustomJButton(String text, Color rgb, Font font, int width, int heigh){
        super(text);
        this.rgb = rgb;
        this.size = font;
        this.width = width;
        this.heigh = heigh;
    }

    @Override
    public void build(){
        setFont(size);
        setBackground(rgb);
        setPreferredSize(new Dimension(width, heigh));

    }
}
