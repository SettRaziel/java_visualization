package data.entity;

import data.entity.datanumber.DataNumber;
import data.entity.dataset.DataSet;
import java.util.HashMap;
import java.util.Set;

/**
 * Class to store a series of data sets.
 * @author Benjamin Held
 */
public class DataSeries {
    /** HashMap to store a series of data */
    private HashMap<DataNumber,DataSet> data_list;

    /**
     * Constructor
     */
    public DataSeries() {
        data_list = new HashMap<>();
    }

    /**
     * Setter to add a data set to the series identified by key
     * @param key key value that identifies the data set
     * @param data data set which should be stored
     */
    public void setData(DataNumber key, DataSet data) {
        data_list.put(key, data);
    }


    public DataSet getDataForKey(DataNumber key) {
        return data_list.get(key);
    }

    public Set<DataNumber> getKeyset() {
        return data_list.keySet();
    }

    public void printDatasetForKey(DataNumber key) {
        DataSet data = data_list.get(key);
        data.print();
    }
}
