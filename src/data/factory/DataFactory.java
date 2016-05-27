package data.factory;

import data.entity.DataSeries;
import data.entity.MetaData;

import java.util.ArrayList;

/**
 * Static Factory to parse the read data
 * @author Benjamin Held (05-13-2016)
 * @version 0.1.0
 * @since 05-27-2016
 */
public abstract class DataFactory {
    public static DataSeries parseData(MetaData meta_data, ArrayList<String[]> input)
                                                                                throws ReflectiveOperationException {
        String pack = DataFactory.class.getPackage().getName();
        String className = pack + ".dataparser." + meta_data.getNameOfData().getType()
                + "DataParser";
        try {
            Class<?> clazz = Class.forName(className);
            DataFactory r = (DataFactory) clazz.newInstance();

            return r.createDataSet(meta_data, input);

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error! Could not load given Class:" + className);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalAccessException("Error! Could not load given Data.");
        }
    }

    public abstract DataSeries createDataSet(MetaData meta_data, ArrayList<String[]> data);
}
