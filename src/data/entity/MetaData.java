package data.entity;

import data.DataType;

/**
 * Metadata for the HashMap of the DataRepository to provide keys for the
 * available data.
 * @author Benjamin Held (02-24-2016)
 * @version 0.1.0
 * @since 05-25-2016
 */
public class MetaData {
    /** name of the data set */
    private DataType data_type;
    /** meta data of the x-axis data */
    private DataDomain x_domain;
    /** meta data of the y-axis data */
    private DataDomain y_domain;
    /** meta data of the z-axis data */
    private DataDomain z_domain;

    /** global extreme values of the assigned data set  */
    private double minimal_data_value, maximal_data_value;

    /**
     * constructor
     * 
     * @param type information about the data type
     * @param x meta data of the x-axis
     * @param y meta data of the y-axis
     * @param z meta data of the z-axis
     */
    public MetaData(DataType type, DataDomain x, DataDomain y, DataDomain z) {
        this.data_type = type;
        this.x_domain = x;
        this.y_domain = y;
        this.z_domain = z;
        this.minimal_data_value = 0;
        this.maximal_data_value = 0;
    }

    public DataType getNameOfData() {
        return data_type;
    }

    public DataDomain getDomainObjectInX() {
        return x_domain;
    }

    public DataDomain getDomainObjectInY() {
        return y_domain;
    }

    public DataDomain getDomainObjectInZ() {
        return z_domain;
    }

    public void setMinimalValue(double value) {
        this.minimal_data_value = value;
    }

    public double getMinimalValue() {
        return minimal_data_value;
    }

    public void setMaximalValue(double value) {
        this.maximal_data_value = value;
    }

    public double getMaximalValue() {
        return maximal_data_value;
    }
}
