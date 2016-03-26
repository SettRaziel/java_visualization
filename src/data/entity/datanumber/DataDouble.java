package data.entity.datanumber;

/**
 * Wrapper class for Double
 * @author Benjamin Held
 */
public class DataDouble extends DataNumber<Double> {
    public DataDouble(Double attribute) {
        super(attribute);
    }

    public Double increment() {
        attribute++;
        return attribute;
    }
    public Double decrement() {
        attribute--;
        return attribute;
    }
    public Double add(Double value) {
        attribute += value;
        return attribute;
    }

    public Double subtract(Double value) {
        attribute -= value;
        return attribute;
    }

    public double getDelta(Double value) {
        return attribute - value;
    }

    public DataDouble clone() {
        return new DataDouble(attribute);
    }
}
