package data.entity.dataset;

/**
 * Basic entity class to represent a dataset.
 * @author Benjamin Held.
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
