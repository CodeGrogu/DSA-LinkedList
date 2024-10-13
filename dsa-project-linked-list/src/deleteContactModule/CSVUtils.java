package deleteContactModule;

import java.io.*;
import java.util.*;

public class CSVUtils {

    // Method to read CSV file and return data as a list of strings
    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    // Method to write data to a CSV file from a list of strings
    public static void writeCSV(String filePath, List<String[]> data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] line : data) {
                bw.write(String.join(",", line));
                bw.newLine();
            }
        }
    }
}