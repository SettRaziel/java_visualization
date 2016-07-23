package data.entity.dataset;

import data.entity.datanumber.DataInteger;

/**
 * Entity class to implement a integer dataset.
 * @author Benjamin Held (07-18-2016)
 * @version 0.1.0
 * @since 07-23-2016
 */
public class DataSetInteger extends DataSet<DataInteger> {

    public DataSetInteger(DataInteger[][] data) {
        super(data);
    }

    public void print() {
        for (DataInteger[] row : values) {
            for (DataInteger value : row) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }

    @Override
    void determineExtrema() {
        maxValue = values[0][0];
        minValue = values[0][0];
        for (DataInteger[] row: values) {
            for (DataInteger value: row) {
                if (value.isGreater(maxValue)) {
                    maxValue = value;
                }
                if (value.isLesser(minValue)) {
                    minValue = value;
                }
            }
        }
    }
}
