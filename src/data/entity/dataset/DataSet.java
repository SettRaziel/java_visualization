package data.entity.dataset;

import data.entity.datanumber.DataNumber;

/**
 * Basic entity class to represent a dataset.
 * @author Benjamin Held (04-17-2016)
 * @version 0.2.0
 * @since 06-04-2016
 */
public abstract class DataSet<T extends DataNumber> {
    T[][] values;
    T maxValue;
    T minValue;

    public DataSet(T[][] data) {
        this.values = data;
        determineExtrema();
    }

    public T getValueAtPosition(int i, int j) {
        return values[i][j];
    }

    public T getMaxValue() {
        return maxValue;
    }

    public T getMinValue() {
        return minValue;
    }

    public abstract void print();

    abstract void determineExtrema();
}
