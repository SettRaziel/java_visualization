package output.colortable;

import java.awt.*;

/**
 * color table to visualize the temperature
 * @author Benjamin Held (06-10-2015)
 * @since 10-07-2016
 * @version 0.1.0
 */
public class TemperatureColor extends ColorTable {

    /**
     * Constructor
     * @param f_min minimum value
     * @param f_max maximum value
     */
    public TemperatureColor(double f_min, double f_max) {
        super(f_min, f_max);
        generate_color_table();
    }

    /**
     * creation of the color table; called in the constructor
     */
    protected void generate_color_table() {
        this.colorPalette.add(new Color(224,102,255));
        this.colorPalette.add(new Color(128,0,128));
        this.colorPalette.add(new Color(0,0,205));
        this.colorPalette.add(new Color(0,0,139));
        this.colorPalette.add(new Color(25,25,112));
        this.colorPalette.add(new Color(65,105,225));
        this.colorPalette.add(new Color(32,178,170));
        this.colorPalette.add(new Color(0,238,118));
        this.colorPalette.add(new Color(118,238,0));
        this.colorPalette.add(new Color(192,255,62));
        this.colorPalette.add(new Color(255,255,0));
        this.colorPalette.add(new Color(255,215,0));
        this.colorPalette.add(new Color(237,145,33));
        this.colorPalette.add(new Color(255,97,3));
        this.colorPalette.add(new Color(255,0,0));
        this.colorPalette.add(new Color(128,0,0));
    }
}
