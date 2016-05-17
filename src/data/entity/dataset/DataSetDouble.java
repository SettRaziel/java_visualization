package data.entity.dataset;

/**
 * Entity class to implement a double dataset.
 * @author Benjamin Held
 */
public class DataSetDouble extends DataSet<Double>{

    public DataSetDouble(Double[][] data) {
        super(data);
    }

    public void print() {
        for (Double[] row : values) {
            for (Double value : row) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }
}
