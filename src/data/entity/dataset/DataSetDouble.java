package data.entity.dataset;

import data.entity.datanumber.DataDouble;

/**
 * Entity class to implement a double dataset.
 * @author Benjamin Held (05-15-2016)
 * @version 0.2.0
 * @since 06-04-2016
 */
public class DataSetDouble extends DataSet<DataDouble>{

    public DataSetDouble(DataDouble[][] data) {
        super(data);
    }

    public void print() {
        for (DataDouble[] row : values) {
            for (DataDouble value : row) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }

    @Override
    void determineExtrema() {
        maxValue = values[0][0];
        minValue = values[0][0];
        for (DataDouble[] row: values) {
            for (DataDouble value: row) {
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
