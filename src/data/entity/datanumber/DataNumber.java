package data.entity.datanumber;

/**
 * Wrapper class for the possible number formats of the dimensions of the data sets
 * @author Benjamin Held (03-03-2016)
 * @version 0.2.0
 * @since 06-2-2016
 */
public abstract class DataNumber<T> {
    /** wrapped attribute */
    protected T attribute;

    /**
     * Constructor
     * @param attribute number attribute
     */
    public DataNumber(T attribute) {
        setNumber(attribute);
    }

    /**
     * Getter for the attribute
     * @return the stored attribute
     */
    public T getNumber() {
        return attribute;
    }

    /**
     * Setter for the attribute
     * @param attribute
     */
    public void setNumber(T attribute) {
        this.attribute = attribute;
    }

    /**
     * Abstract method to create a deep copy
     * @return a deep copy of the object
     */
    public abstract DataNumber<T> clone();

    /**
     * Abstract method the increase the value of the attribute by one
     * @return the incremented attribute
     */
    public abstract T increment();

    /**
     * Abstract method the decrease the value of the attribute by one
     * @return the decreased attribute
     */
    public abstract T decrement();

    /**
     * Abstract method to calculate the value between the given attribute value
     * and the other one
     * @param value attribute value which should be subtracted
     * @return the subtracted delta value
     */
    public abstract double getDelta(T value);

    public abstract boolean isGreater(DataNumber<T> value);

    public abstract boolean isLesser(DataNumber<T> value);

    public abstract boolean isEqual(DataNumber<T> value);
}
