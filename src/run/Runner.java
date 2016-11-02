package run;

import data.entity.MetaData;
import data.entity.datanumber.DataDate;
import data.repository.DataRepository;
import exception.MetaDataException;
import gui.windows.MainWindow;

/**
 * Main program to start the application
 * @author Benjamin Held (05-08-2015)
 * @since 11-02-2016
 * @version 0.1.1
 */
public class Runner {
    public static void main(String[] args) throws MetaDataException {
        readDefaultSet();
        startSwingGui();
    }

    private static void startSwingGui() {
        MainWindow main = MainWindow.getInstance();

        main.pack();
        main.setSize(800, 600);
        main.setVisible(true);

        main.getMenu().getLoadFileButton().doClick();
    }

    private static void readDefaultSet() throws MetaDataException {
        DataRepository repository = DataRepository.getInstance();
        MetaData metaData = repository.addDataSeries("./dev/RainDataSet.txt");
        repository.getDataSeriesToMetaData(metaData).getDataForKey(new DataDate("2024-01-01")).print();
        System.out.println("Finished.");

    }

}

