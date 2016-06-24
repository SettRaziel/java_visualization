package data.entity;

import data.DataType;

/**
 * Metadata for the HashMap of the DataRepository to provide keys for the available data
 * @author Benjamin Held (02-24-2016)
 * @version 0.1.1
 * @since 06-24-2016
 */
public class MetaData {
    /** name of the data set */
    private DataType dataType;
    /** meta data of the x-axis data */
    private DataDomain xDomain;
    /** meta data of the y-axis data */
    private DataDomain yDomain;
    /** meta data of the z-axis data */
    private DataDomain zDomain;

    /** global extreme values of the assigned data set  */
    private double minimalDataValue, maximalDataValue;

    /**
     * constructor
     * 
     * @param type information about the data type
     * @param x meta data of the x-axis
     * @param y meta data of the y-axis
     * @param z meta data of the z-axis
     */
    public MetaData(DataType type, DataDomain x, DataDomain y, DataDomain z) {
        this.dataType = type;
        this.xDomain = x;
        this.yDomain = y;
        this.zDomain = z;
        this.minimalDataValue = 0;
        this.maximalDataValue = 0;
    }

    public DataType getNameOfData() {
        return dataType;
    }

    public DataDomain getDomainObjectInX() {
        return xDomain;
    }

    public DataDomain getDomainObjectInY() {
        return yDomain;
    }

    public DataDomain getDomainObjectInZ() {
        return zDomain;
    }

    public void setMinimalValue(double value) {
        this.minimalDataValue = value;
    }

    public double getMinimalValue() {
        return minimalDataValue;
    }

    public void setMaximalValue(double value) {
        this.maximalDataValue = value;
    }

    public double getMaximalValue() {
        return maximalDataValue;
    }
}
