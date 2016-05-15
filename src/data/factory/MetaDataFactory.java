package data.factory;

import data.DataType;
import data.entity.DataDomain;
import data.entity.MetaData;
import data.entity.datanumber.DataDate;
import data.entity.datanumber.DataDouble;
import data.entity.datanumber.DataInteger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Static factory class to create meta data from given input data
 * @author Benjamin Held
 */
public class MetaDataFactory {
    public static MetaData parseMetaData(ArrayList<String[]> input) throws IllegalArgumentException {
        return new MetaData(createDataType(input.get(0)), // data type
                            createDomain(input.get(1)),   // domain in x
                            createDomain(input.get(2)),   // domain in y
                            createDomain(input.get(3)));  // domain in z
    }

    private static DataDomain createDomain(String[] line) {
        switch (line[0]) {
            case "Double":
                return new DataDomain<>(
                        line[1].trim(),
                        new DataDouble(Double.parseDouble(line[2].trim())),
                        new DataDouble(Double.parseDouble(line[3].trim())),
                        Double.parseDouble(line[4].trim()));
            case "Integer":
                return new DataDomain<>(
                        line[1].trim(),
                        new DataInteger(Integer.parseInt(line[2].trim())),
                        new DataInteger(Integer.parseInt(line[3].trim())),
                        Integer.parseInt(line[4].trim()));
            case "LocalDate":
                return new DataDomain<>(
                        line[1].trim(),
                        new DataDate(LocalDate.parse(line[2].trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"))),
                        new DataDate(LocalDate.parse(line[3].trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"))),
                        Integer.parseInt(line[4].trim()));
            default:
                throw new IllegalArgumentException("Error while parsing metadata: no valid type.");
        }
    }

    private static DataType createDataType(String[] line) {
        return new DataType(line[0].trim(), line[1].trim(), line[2].trim());
    }
}
