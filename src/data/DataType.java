package data;

/**
 * Entityclass to store information about the data type
 * @author Benjamin Held (02-14-2016)
 * @since 05-31-2016
 * @version 0.1.0
 */
public class DataType {
    /** name of data measuring type */
    private String dataName;
    /** attribute to describe the type of the unit */
    private String dataType;
    /** the measuring unit belonging to the data type; in SI-units if possible */
    private String measuringUnit;

    /**
     * constructor
     * @param name the name of the data unit
     * @param type the type of the data unit
     * @param unit the measuring unit of the data type
     */
    public DataType(String name, String type, String unit) {
        this.dataName = name;
        this.dataType = type;
        this.measuringUnit = unit;
    }

    public String getDataName() {
        return dataName;
    }

    public String getType() {
        return dataType;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }
}
