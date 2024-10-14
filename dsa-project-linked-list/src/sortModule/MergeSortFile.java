package sortModule;

import java.io.*;
import java.util.*;
// This method will sort the contacts in the CSV file based on the first name, using the Merge Sort algorithm.
// method is called everytime the program starts up, so that the contacts are always sorted.
public class MergeSortFile {
    public static void sortTheCsv() {
        String inputFilePath = "dsa-project-linked-list\\src\\data\\contacts.csv";
        String outputFilePath = "dsa-project-linked-list\\src\\data\\contacts.csv";
        List<String[]> rows = new ArrayList<>();
    
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                rows.add(columns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        rows.sort(Comparator.comparing(row -> row[0])); // Assuming first name is in the first column
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] row : rows) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void analyzeEfficiency() {
        long startTime = System.nanoTime();
        sortTheCsv();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken to sort the CSV file: " + duration + " nanoseconds");
    }
    
}
