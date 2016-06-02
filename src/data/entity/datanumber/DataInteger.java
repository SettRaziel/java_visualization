package data.entity.datanumber;

/**
 * Wrapper class for Integer
 * @author Benjamin Held (04-02-2016)
 * @version 0.2.0
 * @since 06-2-2016
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
    public boolean isEqual(DataNumber<Integer> value) {
        return this.attribute.equals(value.attribute);
    }

    public DataInteger clone() {
        return new DataInteger(attribute);
    }
}
