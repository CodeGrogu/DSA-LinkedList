package displayContactModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayContacts {
    public static void displayContacts(){
        String filePath = "dsa-project-linked-list\\src\\data\\contacts.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = br.readLine().split(",");  // Read the header line

            // Define the column widths based on the maximum length of the header or data
            int[] columnWidths = getColumnWidths(headers);

            // Print the formatted header
            printRow(headers, columnWidths);
            printSeparator(columnWidths);  // Print separator line

            // Read and print each data row, applying formatting
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                printRow(fields, columnWidths);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // A Method to get column widths based on the maximum length of data or headers
    public static int[] getColumnWidths(String[] headers) {
        int[] widths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            widths[i] = headers[i].length();  // Start with header lengths

            // Set the maximum width based on the headers and data
            // Here you could dynamically adjust the widths by reading the data
        }
        return widths;
    }

    // A Method to print a single row with aligned columns
    public static void printRow(String[] row, int[] columnWidths) {
        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            rowString.append(String.format("%-" + columnWidths[i] + "s", row[i]));  // Left-align text within the column width
            if (i < row.length - 1) {
                rowString.append(" | ");  // Separator between columns
            }
        }
        System.out.println(rowString.toString());
    }

    // A Method to print a separator line between header and data rows
    public static void printSeparator(int[] columnWidths) {
        StringBuilder separator = new StringBuilder();
        for (int width : columnWidths) {
            for (int i = 0; i < width + 2; i++) {  // Add extra space around each column for separation
                separator.append("-");
            }
            separator.append("+");
        }
        System.out.println(separator.toString());
    }
}