package data.repository;

import data.entity.MetaData;
import data.entity.DataSeries;
import data.factory.DataFactory;
import data.factory.MetaDataFactory;
import data.loader.CSV_Loader;
import exception.MetaDataException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Singleton class to serve as a storage for the data series
 * @author Benjamin Held (05-16-2016)
 * @since 06-30-2016
 * @version 0.1.3
 */
public class DataRepository {
    private volatile static DataRepository instance;
    private volatile HashMap<MetaData, DataSeries> repository;

    /** private constructor which initialized the HashMap */
    private DataRepository() {
        repository = new HashMap<>();
    }

    /**
     * singleton method for the instance
     * @return singleton instance
     */
    public synchronized static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    /**
     * method to add the content of the provided filename as a new {@link DataSeries}
     * @param filename the filepath
     * @return the {@link MetaData} object that was created for the {@link DataSeries}
     */
    public MetaData addDataSeries(String filename) throws MetaDataException {
        try {
            ArrayList<String[]> raw_data = CSV_Loader.loadSingleLine(filename);
            MetaData metaData = MetaDataFactory.parseMetaData(extractMetaData(raw_data));
            raw_data.subList(0,4).clear();
            DataSeries data = DataFactory.parseData(metaData, raw_data);

            repository.put(metaData, data);

            System.out.println("Data was added to repository.");
            return metaData;
        } catch (IOException | ReflectiveOperationException e) {
            System.out.println(e.getMessage());
            System.out.println("Data was not added to repository.");
        }
        return null;
    }

    /**
     * method to retrieve the {@link DataSeries} to the corresponding {@link MetaData}
     * @param metaData the provided {@link MetaData}
     * @return the {@link DataSeries} that belongs to the provided meta data or null if no object can be found
     */
    public DataSeries getDataSeriesToMetaData(MetaData metaData) {
        return this.repository.get(metaData);
    }

    /**
     * method to retrieve all {@link MetaData} objects currently stored in the repository
     * @return a set of all currently stored {@link MetaData} objects
     */
    public Set<MetaData> getAllMetaDataEntries() {
        return repository.keySet();
    }

    /**
     * helper method to read the meta data from the beginning of a file
     * @param data the string list with the meta data information
     * @return the arraylist with the required entries for a {@link MetaData} object
     */
    private ArrayList<String[]> extractMetaData(ArrayList<String[]> data) {
        ArrayList<String[]> subData = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            subData.add(data.get(i));
        }

        return subData;
    }
}
