import java.io.*;
import java.util.*;

public class InnitFile {
    public static void sortTheCsv() {
        String inputFilePath = "data/contacts.csv";
        String outputFilePath = "data/sorted_contacts.csv";
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
    
}
