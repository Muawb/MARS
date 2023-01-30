package me.muawb.project.gui.components;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel implements Factory {

    private Color rgb;
    private int width;
    private int heigth;
    private int x;
    private int y;

    public CustomJPanel(LayoutManager layout, Color rgb, int width, int heigth, int x, int y){
        super(layout);
        this.rgb = rgb;
        this.width = width;
        this.heigth = heigth;
        this.x = x;
        this.y = y;
    }

    @Override
    public void build() {
        setBackground(rgb);
        setBounds(x, y, width, heigth);
    }
}
