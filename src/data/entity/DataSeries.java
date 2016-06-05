package data.entity;

import data.entity.datanumber.DataNumber;
import data.entity.dataset.DataSet;
import java.util.HashMap;
import java.util.Set;

/**
 * Class to store a series of data sets.
 * @author Benjamin Held (04-30-2016)
 * @version 0.1.1
 * @since 06-05-2016
 */
public class DataSeries {
    /** HashMap to store a series of data */
    private HashMap<DataNumber, DataSet> dataList;
    private DataNumber max = null;
    private DataNumber min = null;

    /**
     * Constructor
     */
    public DataSeries() {
        dataList = new HashMap<>();
    }

    /**
     * Setter to add a data set to the series identified by key
     * @param key key value that identifies the data set
     * @param data data set which should be stored
     */
    public void setData(DataNumber key, DataSet data) {
        dataList.put(key, data);
        determineExtrema(data);
    }

    public DataSet getDataForKey(DataNumber key) {
        return dataList.get(key);
    }

    public Set<DataNumber> getKeyset() {
        return dataList.keySet();
    }

    public DataNumber getMax() {
        return max;
    }

    public DataNumber getMin() {
        return min;
    }

    private void determineExtrema(DataSet data) {
        if (max == null && min == null) {
            max = data.getMaxValue();
            min = data.getMinValue();
        } else {
            if (data.getMaxValue().isGreater(max)) {
                max = data.getMaxValue();
            }
            if (data.getMinValue().isLesser(min)) {
                min = data.getMinValue();
            }
        }

    }

}
