package searchmodule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class searchContact {
    public static void main(String[] args) {
       
        String file = "src\\data\\contacts.csv"; // Path to your contacts CSV file
        BufferedReader reader = null;  // Initialize BufferedReader
        String line = ""; // Read each line of the file 
        Scanner scan = new Scanner(System.in);
        String name;

        System.out.println("Enter the name of the contact you want to search: ");
        name = scan.nextLine(); 
        
        boolean contactFound = false; 
        
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(","); // Split the line by commas
                String contactName = row[0]; // Assuming the name is the first column

                
                if (contactName.equalsIgnoreCase(name)) { 
                    System.out.println("Contact found: ");
                    System.out.println("Name: " + contactName);
                    for (int i = 1; i < row.length; i++) { 
                        System.out.print(row[i] + " "); 
                    }
                    System.out.println(); 
                    contactFound = true; 
                    break; 
                }
            }
        } catch (IOException e) { // Handle file reading errors
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) { 
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle potential IOException during close
            }
        }

        // If contact was not found, notify the user
        if (!contactFound) {
            System.out.println("Contact not found.");
        }

        scan.close(); // Close the scanner
    }
}
