package gui.menu;

import gui.menu.menuitems.*;

import javax.swing.*;

/**
 * swing object to generate the menu bar for the main window
 * @author Benjamin Held (08-24-2015)
 * @since 10-12-2016
 * @version 0.1.0
 */
public class MainMenuBar extends JMenuBar{

    private LoadFileButton loadFileButton;

    public MainMenuBar() {
        JMenu fileMenu = new JMenu("File");

        loadFileButton = new LoadFileButton();

        fileMenu.add(loadFileButton);
        fileMenu.add(new SelectDataSeriesButton());
        fileMenu.add(new ExitButton());
        this.add(fileMenu);
    }

    public LoadFileButton getLoadFileButton() {
        return loadFileButton;
    }

}