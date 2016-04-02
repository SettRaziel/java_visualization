package data.entity.datanumber;

/**
 * Wrapper class for Integer
 * @author Benjamin Held
 */
public class DataInteger extends DataNumber<Integer> {
    public DataInteger(Integer attribute) {
        super(attribute);
    }

    public Integer increment() {
        attribute++;
        return attribute;
    }
    public Integer decrement() {
        attribute--;
        return attribute;
    }
    public Integer add(Integer value) {
        attribute += value;
        return attribute;
    }

    public Integer subtract(Integer value) {
        attribute -= value;
        return attribute;
    }

    public double getDelta(Integer value) {
        return attribute - value;
    }

    public DataInteger clone() {
        return new DataInteger(attribute);
    }
}
