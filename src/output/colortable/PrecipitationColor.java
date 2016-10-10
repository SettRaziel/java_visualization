package output.colortable;

import java.awt.*;

/**
 * color table to visualize the precipitation
 * @author Benjamin Held (06-10-2015)
 * @since 10-10-2016
 * @version 0.1.0
 */
public class PrecipitationColor extends ColorTable {

    /**
     * Constructor
     * @param f_min minimum value
     * @param f_max maximum value
     */
    public PrecipitationColor(double f_min, double f_max) {
        super(f_min, f_max);
        generate_color_table();
    }

    /**
     * creation of the color table; called in the constructor
     */
    protected void generate_color_table() {
        this.colorPalette.add(new Color(128,0,0));
        this.colorPalette.add(new Color(255,0,0));
        this.colorPalette.add(new Color(255,128,0));
        this.colorPalette.add(new Color(236,192,0));
        this.colorPalette.add(new Color(178,255,102));
        this.colorPalette.add(new Color(153,255,51));
        this.colorPalette.add(new Color(128,255,0));
        this.colorPalette.add(new Color(102,204,0));
        this.colorPalette.add(new Color(76,153,0));
        this.colorPalette.add(new Color(51,102,0));
        this.colorPalette.add(new Color(0,102,0));
        this.colorPalette.add(new Color(0,102,51));
        this.colorPalette.add(new Color(0,102,102));
        this.colorPalette.add(new Color(0,51,51));
        this.colorPalette.add(new Color(0,25,51));
        this.colorPalette.add(new Color(0,0,51));
        this.colorPalette.add(new Color(0x00006a));
        this.colorPalette.add(new Color(0x000083));
        this.colorPalette.add(new Color(0x00009c));
        this.colorPalette.add(new Color(0x0000b5));
    }
}