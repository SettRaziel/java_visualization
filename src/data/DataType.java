package data;

/**
 * Entityclass to store informations about the data type
 * @author Benjamin Held
 */
public class DataType {
    /** name of data measuring type */
    private String data_name;
    /** attribute to describe the type of the unit */
    private String data_type;
    /** the measuring unit belonging to the data type; in SI-units if possible */
    private String measuring_unit;

    /**
     * constructor
     * @param name the name of the data unit
     * @param type the type of the data unit
     * @param unit the measuring unit of the data type
     */
    public DataType(String name, String type, String unit) {
        this.data_name = name;
        this.data_type = type;
        this.measuring_unit = unit;
    }

    public String getDataName() {
        return data_name;
    }

    public String getType() {
        return data_type;
    }

    public String getMeasuringUnit() {
        return measuring_unit;
    }
}
