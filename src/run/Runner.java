package run;

import data.repository.DataRepository;
import exception.MetaDataException;

/**
 * Main program to start the application
 * @author Benjamin Held (05-08-2015)
 * @since 06-07-2016
 * @version 0.1.0
 */
public class Runner {
    public static void main(String[] args) throws MetaDataException {
        DataRepository repository = DataRepository.getInstance();
        repository.addDataSeries("/path/to/csv");

        System.out.println("Finished.");
    }
}

