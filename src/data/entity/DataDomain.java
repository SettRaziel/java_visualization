package data.entity;

import data.entity.datanumber.DataNumber;

/**
 * Helperclass to provide Information of the Datadomain und Data Range Created
 * @author Benjamin Held
 */
public class DataDomain<T extends DataNumber> {
    /** name of the data variable / label for the axis annotation */
    private String data_label;
    /** lower interval value of the data */
    private T lower_boundary;
    /** upper interval value of the data */
    private T upper_boundary;
    /** step range between the data */
    private Double step_range;

    /**
     * constructor
     * 
     * @param data_label data name
     * @param lower_boundary lower boundary
     * @param upper_boundary upper boundary
     * @param step_range step range
     */
    public DataDomain(String data_label, T lower_boundary, T upper_boundary, double step_range) {
        this.data_label = data_label;
        this.lower_boundary = lower_boundary;
        this.upper_boundary = upper_boundary;
        this.step_range = step_range;
    }

    public String getDataLabel() {
        return data_label;
    }

    public Class getDomainClass() {
        return lower_boundary.getClass();
    }

    public Class getStepClass() {
        return step_range.getClass();
    }

    public T getLowerBoundary() {
        return lower_boundary;
    }

    public T getUpperBoundary() {
        return upper_boundary;
    }

    public Double getDelta() {
        return upper_boundary.getDelta(lower_boundary.getNumber());
    }

    public Double getStepRange() {
        return step_range;
    }
}
