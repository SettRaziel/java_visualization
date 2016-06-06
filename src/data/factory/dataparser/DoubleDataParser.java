package data.factory.dataparser;

import data.entity.DataDomain;
import data.entity.DataSeries;
import data.entity.MetaData;
import data.entity.datanumber.DataDouble;
import data.entity.datanumber.DataNumber;
import data.entity.dataset.DataSetDouble;
import data.factory.DataFactory;

import java.util.ArrayList;

/**
 * Parser class to read a data set of double formatted data values
 * @author Benjamin Held (05-18-2016)
 * @version 0.1.1
 * @since 06-06-2016
 */
public class DoubleDataParser extends DataFactory {

    public DataSeries createDataSet(MetaData meta_data, ArrayList<String[]> data) {
        DataSeries series = new DataSeries();
        DataDouble[][] values = null;
        int j = 0;
        boolean starts_new_data_set = false;
        // variables for extreme values
        DataDouble maximum = DataDouble.getMax(), minimum = DataDouble.getMin();

        DataDomain y_domain = meta_data.getDomainObjectInY();
        double v1 = y_domain.getDelta();
        double delta = v1 / y_domain.getStepRange();
        int y_size = 1 + (int) Math.round(delta);
        DataNumber z_value = meta_data.getDomainObjectInZ().getLowerBoundary().clone();

        for (String[] strings : data) {
            if (strings.length < 2) {
                if (values != null) {

                    series.setData(z_value, new DataSetDouble(values));

                    z_value = z_value.clone();
                    z_value.increment();
                }
                starts_new_data_set = true;
                j = 0;
                System.out.println();
            } else {
                if (starts_new_data_set) {
                    values = new DataDouble[strings.length][y_size];
                    starts_new_data_set = false;
                }
                for (int i = 0; i < strings.length; i++) {
                    DataDouble parsed_value = new DataDouble(Double.parseDouble(strings[i]));
                    if (parsed_value.isLesser(minimum)) minimum = parsed_value; // checking for extreme values
                    if (parsed_value.isGreater(maximum)) maximum = parsed_value;
                    values[i][j] = parsed_value;
                }
                j++;
            }
        }
        series.setData(z_value, new DataSetDouble(values));

        return series;
    }

}
