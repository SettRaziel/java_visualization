package output.colortable;

import java.awt.*;
import java.util.ArrayList;

/**
 * Abstract class to create different color tables
 * @author Benjamin Held (06-10-2015)
 * @since 06-10-2016
 * @version 0.1.0
 */
public abstract class ColorTable {
    private double minValue, maxValue;
    ArrayList<Color> colorPalette;

    /**
     * Constructor
     * @param fMin minimum value
     * @param fMax maximum value
     */
    public ColorTable(double fMin, double fMax) {
        this.minValue = fMin;
        this.maxValue = fMax;
        this.colorPalette = new ArrayList<>();
    }


    public Color getColor(double value) {

        int index =(int) (get_table_size() * ((value - minValue)/(maxValue - minValue)) + 0.5);

        if (index < 0 || index > get_table_size() - 1) {
            throw new IndexOutOfBoundsException("Error in Colortable: Provided value results in an " +
                                                "index that is out of bounds");
        }
        return colorPalette.get(index);
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public int get_table_size() {
        return colorPalette.size();
    }

    /**
     * abstract method where deriving classes specify their color table
     */
    protected abstract void generate_color_table();
}
