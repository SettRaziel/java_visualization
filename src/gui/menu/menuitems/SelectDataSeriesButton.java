package gui.menu.menuitems;

import gui.windows.SeriesSelectionWindow;

import javax.swing.*;

/**
 * menu button to select one of the processed data series
 * @author Benjamin Held (08-24-2015)
 * @since 10-11-2016
 * @version 0.1.0
 */
public class SelectDataSeriesButton extends JMenuItem {

    public SelectDataSeriesButton() {
        super("Select DataSeries");
        this.addActionListener(e -> {

            SeriesSelectionWindow seriesSelectionWindow = new SeriesSelectionWindow();
            seriesSelectionWindow.pack();
            seriesSelectionWindow.setVisible(true);
        });
    }
}
