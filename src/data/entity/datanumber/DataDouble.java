package data.entity.datanumber;

/**
 * Wrapper class for Double
 * @author Benjamin Held (03-26-2016)
 * @version 0.2.0
 * @since 06-2-2016
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

    public static DataDouble getMax() {
        return new DataDouble(Double.MAX_VALUE);
    }

    public static DataDouble getMin() {
        return new DataDouble(Double.MIN_VALUE);
    }

    @Override
    public boolean isGreater(DataNumber<Double> value) {
        return this.attribute > value.attribute;
    }

    @Override
    public boolean isLesser(DataNumber<Double> value) {
        return this.attribute < value.attribute;
    }

    @Override
    public boolean isEqual(DataNumber<Double> value) {
        return this.attribute.equals(value.attribute);
    }
}
