package data.repository;

import data.entity.MetaData;
import data.entity.DataSeries;
import data.factory.DataFactory;
import data.factory.MetaDataFactory;
import data.loader.CSV_Loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton class to serve as a storage for the data series
 * @author Benjamin Held
 */
public class DataRepository {
    private volatile static DataRepository instance;
    private volatile HashMap<MetaData, DataSeries> repository;

    /** private constructor which initialized the HashMap */
    private DataRepository() {
        repository = new HashMap<>();
    }

    /**
     * Singletonmethod for the instance
     * @return singleton instance
     */
    public synchronized static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    public void addDataSeries(String filename) {
        try {
            ArrayList<String[]> raw_data = CSV_Loader.load_single_line(filename);
            MetaData meta_data = MetaDataFactory.parseMetaData(extractMetaData(raw_data));
            raw_data.subList(0,4).clear();
            DataSeries data = DataFactory.parseData(meta_data, raw_data);

            repository.put(meta_data, data);

            System.out.println("Data was added to repository.");
        } catch (IOException | ReflectiveOperationException e) {
            System.out.println(e.getMessage());
            System.out.println("Data was not added to repository.");
        }
    }

    private ArrayList<String[]> extractMetaData(ArrayList<String[]> data) {
        ArrayList<String[]> sub_data = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sub_data.add(data.get(i));
        }

        return sub_data;
    }
}
