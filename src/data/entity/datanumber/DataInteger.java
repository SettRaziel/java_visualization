package data.entity.datanumber;

/**
 * Wrapper class for Integer
 * @author Benjamin Held (04-02-2016)
 * @version 0.2.2
 * @since 07-08-2016
 */
public class DataInteger extends DataNumber<Integer> {
    public DataInteger(Integer attribute) {
        super(attribute);
    }

    public DataInteger(String attribute) {
        super(Integer.parseInt(attribute));
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

    public static DataInteger getMax() {
        return new DataInteger(Integer.MAX_VALUE);
    }

    public static DataInteger getMin() {
        return new DataInteger(Integer.MIN_VALUE);
    }

    @Override
    public boolean isGreater(DataNumber<Integer> value) {
        return this.attribute > value.attribute;
    }

    @Override
    public boolean isLesser(DataNumber<Integer> value) {
        return this.attribute < value.attribute;
    }

    @Override
    public String toString() {
        return attribute.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DataInteger) {
            DataInteger integer = (DataInteger) o;
            return attribute.equals(integer.attribute);
        }
        return false;
    }

    public DataInteger clone() {
        return new DataInteger(attribute);
    }
}
