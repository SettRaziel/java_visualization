package output.colortable;

import java.awt.*;

/**
 * color table to visualize the wind speed
 * @author Benjamin Held (06-10-2015)
 * @since 10-09-2016
 * @version 0.1.0
 */
public class WindspeedColor extends ColorTable {

    /**
     * Constructor
     * @param f_min minimum value
     * @param f_max maximum value
     */
    public WindspeedColor(double f_min, double f_max) {
        super(f_min, f_max);
        generate_color_table();
    }

    /**
     * creation of the color table; called in the constructor
     */
    protected void generate_color_table() {
        this.colorPalette.add(new Color(0,0,153));
        this.colorPalette.add(new Color(0,0,204));
        this.colorPalette.add(new Color(0,0,255));
        this.colorPalette.add(new Color(0,128,255));
        this.colorPalette.add(new Color(51,153,255));
        this.colorPalette.add(new Color(51,255,255));
        this.colorPalette.add(new Color(51,255,153));
        this.colorPalette.add(new Color(51,255,51));
        this.colorPalette.add(new Color(153,255,51));
        this.colorPalette.add(new Color(255,255,51));
        this.colorPalette.add(new Color(255,128,0));
        this.colorPalette.add(new Color(255,51,51));
        this.colorPalette.add(new Color(255,0,0));
        this.colorPalette.add(new Color(255,0,127));
    }
}
