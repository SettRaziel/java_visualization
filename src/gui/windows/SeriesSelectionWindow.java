package gui.windows;

import data.entity.MetaData;
import data.repository.DataRepository;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Gui container to select a data series
 * @author Benjamin Held (06-11-2016)
 * @version 0.1.0
 * @since 08-31-2016
 */
public class SeriesSelectionWindow extends JFrame {
    private JComboBox<String> selector;

    public SeriesSelectionWindow() {
        super("Series Selector");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(320, 240));

        this.setLayout(new BorderLayout());
        JPanel yearSelectorPanel = new JPanel(new FlowLayout());

        yearSelectorPanel.add(new JLabel("Select data series:"));

        selector = createSeriesSelector();
        yearSelectorPanel.add(selector);

        yearSelectorPanel.setMaximumSize(new Dimension(320, 20));

        this.add(yearSelectorPanel, BorderLayout.CENTER);
    }

    private JComboBox<String> createSeriesSelector() {
        Set<MetaData> keys = DataRepository.getInstance().getAllMetaDataEntries();
        String[] entries = new String[keys.size()];
        int index = 0;

        for (MetaData metaData: keys) {
            entries[index] = metaData.getNameOfData().getDataName();
            index++;
        }

        JComboBox<String> selector = new JComboBox<>(entries);

        ((JLabel) selector.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        selector.setMaximumSize(new Dimension(1000, 20));

        ComboBoxEditor editor = selector.getEditor();
        JTextField textField = (JTextField) editor.getEditorComponent();
        textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        selector.setEditable(true);

        selector.addActionListener(e -> {
            JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
            String selectedMetaData = (String) comboBox.getSelectedItem();
            System.out.println("Select metadata: " + selectedMetaData);
        });

        return selector;
    }
}
