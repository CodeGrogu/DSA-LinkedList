package SearchModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchContact {
    public static void main(String[] args) {
       
        String file = "src\\data\\contacts.csv"; // Path to your contacts CSV file
        BufferedReader reader = null;  // Initialize BufferedReader
        String line; // Read each line of the file 
        Scanner scan = new Scanner(System.in);
        String firstName, lastName;

        // Prompt user for first name and last name
        System.out.println("Enter the First name of the contact you want to search: ");
        firstName = scan.nextLine(); 
        System.out.println("Enter the Last name of the contact you want to search: ");
        lastName = scan.nextLine(); 

        boolean contactFound = false; 
        
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(","); // Split the line by commas
                
                // Assuming the first name is in the first column and last name in the second
                String contactFirstName = row[0]; 
                String contactLastName = row[1]; 
                
                // Check if both first and last names match
                if (contactFirstName.equalsIgnoreCase(firstName) && contactLastName.equalsIgnoreCase(lastName)) { 
                    System.out.println("Contact found: ");
                    System.out.println("Name: " + contactFirstName + " " + contactLastName);
                    for (int i = 2; i < row.length; i++) { // Start printing from the third column
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
