package gui.menu.menuitems;

import javax.swing.*;

/**
 * menu button to exit the application
 * @author Benjamin Held (08-18-2015)
 * @since 08-18-2016
 * @version 0.1.0
 */
public class ExitButton extends JMenuItem {

    public ExitButton() {
        super("Exit");
        this.addActionListener(e -> {
            if (e.getSource().equals(this)) {
                System.exit(0);
            }
        });
    }
}
