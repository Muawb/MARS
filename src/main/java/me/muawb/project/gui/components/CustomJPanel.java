package me.muawb.project.gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Inheritance class {@link JPanel} extends his.
 * Additional custom panel with use {@link this#build()}.
 */

public class CustomJPanel extends JPanel implements Factory {

    //Happen set color for panel.
    private Color rgb;
    //Width for panel.
    private int width;
    //Height for panel.
    private int height;

    //Coordinates for placed is panel.
    private int x;
    private int y;

    /**
     * Initializing a variables and give layout in keywords super is arguments
     * what would call constructor is super class.
     *
     * @param layout
     *          determine is mesh for put a component.
     * @param rgb
     *          determine color for panel
     * @param width
     *          width is panel
     * @param height
     *          height is panel
     * @param x
     *          coordinates for put panel
     * @param y
     *          coordinates for put panel
     */

    public CustomJPanel(LayoutManager layout, Color rgb, int width, int height, int x, int y){
        super(layout);  //Call constructor is super class.
        this.rgb = rgb;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    /**
     * Performing set is configuration for create panel.
     */

    @Override
    public void build() {
        setBackground(rgb);
        setBounds(x, y, width, height);
    }
}
