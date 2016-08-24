package gui.menu.menuitems;

import data.repository.DataRepository;

import javax.swing.*;

/**
 * menu button to open a file choose and load a file
 * @author Benjamin Held (08-24-2015)
 * @since 08-24-2016
 * @version 0.1.0
 */
public class LoadFileButton extends JMenuItem {
	
	private static final long serialVersionUID = -4098372190088516766L;

	public LoadFileButton() {
		super("Load File");
		this.addActionListener(e -> {

			JFileChooser fileChooser = new JFileChooser("./");
			fileChooser.setMultiSelectionEnabled(true);
			int returnval = fileChooser.showOpenDialog(this);
			if (returnval == JFileChooser.APPROVE_OPTION) {

				String fileName = fileChooser.getSelectedFile().getAbsolutePath();

				if (fileName.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Invalid File Name",
							"Invalid File Name", JOptionPane.ERROR_MESSAGE);
				}
				try {
					DataRepository.getInstance().addDataSeries(fileName);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, ex.getMessage(),
							"Error while trying to load file.", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
	}
}
