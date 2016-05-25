package data.entity.dataset;

/**
 * Basic entity class to represent a dataset.
 * @author Benjamin Held (04-17-2016)
 * @version 0.1.0
 * @since 05-25-2016
 */
public abstract class DataSet<T> {
    T[][] values;

    public DataSet(T[][] data) {
        this.values = data;
    }

    public T getValueAtPosition(int i, int j) {
        return values[i][j];
    }

    public abstract void print();
}
