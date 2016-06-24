package data.entity;

import data.entity.datanumber.DataNumber;

/**
 * Helperclass to provide Information of the data domain und data range
 * @author Benjamin Held (02-25-2016)
 * @version 0.1.1
 * @since 06-24-2016
 */
public class DataDomain<T extends DataNumber> {
    /** name of the data variable / label for the axis annotation */
    private String dataLabel;
    /** lower interval value of the data */
    private T lowerBoundary;
    /** upper interval value of the data */
    private T upperBoundary;
    /** step range between the data */
    private Double stepRange;

    /**
     * constructor
     * 
     * @param dataLabel data name
     * @param lowerBoundary lower boundary
     * @param upperBoundary upper boundary
     * @param stepRange step range
     */
    public DataDomain(String dataLabel, T lowerBoundary, T upperBoundary, double stepRange) {
        this.dataLabel = dataLabel;
        this.lowerBoundary = lowerBoundary;
        this.upperBoundary = upperBoundary;
        this.stepRange = stepRange;
    }

    public String getDataLabel() {
        return dataLabel;
    }

    public Class getDomainClass() {
        return lowerBoundary.getClass();
    }

    public Class getStepClass() {
        return stepRange.getClass();
    }

    public T getLowerBoundary() {
        return lowerBoundary;
    }

    public T getUpperBoundary() {
        return upperBoundary;
    }

    public Double getDelta() {
        return upperBoundary.getDelta(lowerBoundary.getNumber());
    }

    public Double getStepRange() {
        return stepRange;
    }
}
