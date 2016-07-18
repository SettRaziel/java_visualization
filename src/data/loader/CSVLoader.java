package data.loader;

import java.io.*;
import java.util.ArrayList;

/**
 * Static class to read content from an external csv-file or csv-resource.
 * @author Benjamin Held (02-07-2016)
 * @since 07-18-2016
 * @version 0.2.0
 */
public class CSVLoader {

    /**
     * Static method to load a csv-file with comma separator
     * @param csvFile filename
     * @return Arraylist of String[] where each line is stores in one String[]
     * @throws FileNotFoundException if the given file could not be found
     * @throws IOException if an error occurs while opening or reading the content of the file
     */
    public static ArrayList<String[]> loadSingleLine(String csvFile) throws IOException {

        BufferedReader br = null;
        String line;
        String cvsSplitBy = ","; // line separator
        ArrayList<String[]> result = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                result.add(line.split(cvsSplitBy));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("Error [CSVLoader]: File " + csvFile + " not found.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("IOError [CSVLoader] while trying to read: "+ csvFile);
        } finally {
            closeBufferedReader(br, csvFile);
        }

        return result;
    }

    /**
     * Static method to load a csv-resource with comma separator
     * @param csvResource resource name
     * @return Arraylist of String[] where each line is stores in one String[]
     * @throws FileNotFoundException if the given file could not be found
     * @throws IOException if an error occurs while opening or reading the content of the file
     */
    public static ArrayList<String[]> loadSingleLine(InputStream csvResource) throws IOException {

        BufferedReader br = null;
        String line;
        String cvsSplitBy = ","; // line separator
        ArrayList<String[]> result = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(csvResource));
            while ((line = br.readLine()) != null) {
                result.add(line.split(cvsSplitBy));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("Error [CSVLoader]: Resource " + csvResource + " not found.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("IOError [CSVLoader] while trying to read: "+ csvResource);
        } finally {
            closeBufferedReader(br, csvResource.toString());
        }

        return result;
    }

    /**
     * Static method to close a used BufferedReader
     * @param br the BufferedReader that should be closed
     * @param resource a string with the name of the resource
     */
    private static void closeBufferedReader(BufferedReader br, String resource) {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOError [CSVLoader] while trying to close resource: " + resource);
            }
        }
    }
}
