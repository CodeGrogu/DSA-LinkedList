package searchModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class searchContact {
    public static void searchContact() {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter first name of the contact you want to search for: ");
        String firstName = scan.nextLine();

        System.out.print("Enter last name of the contact you want to search for: ");
        String lastName = scan.nextLine();

        // Call analyzeEfficiency to measure the search operation
        analyzeEfficiency(firstName, lastName);

        scan.close();
    }

    public static void searchContact(String firstName, String lastName) {
        String file = "dsa-project-linked-list\\src\\data\\contacts.csv"; // Path to your contacts CSV file
        BufferedReader reader = null;  // Initialize BufferedReader
        String line; // Read each line of the file 

        ArrayList<String[]> contacts = new ArrayList<>(); // List to store contacts

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(","); // Split the line by commas
                contacts.add(row); // Add each row to the contacts list
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

        // Sort the list of contacts based on first name and last name
        Collections.sort(contacts, new Comparator<String[]>() {
            @Override
            
            public int compare(String[] contact1, String[] contact2) {
                int firstNameComparison = contact1[0].compareToIgnoreCase(contact2[0]);
                if (firstNameComparison == 0) {
                    return contact1[1].compareToIgnoreCase(contact2[1]);
                }
                return firstNameComparison;
            }
        });

        // Perform binary search
        analyzeEfficiency(firstName, lastName);
        int index = binarySearch(contacts, firstName, lastName);

        if (index >= 0) {
            String[] contact = contacts.get(index);
            System.out.println("Contact found: ");
            System.out.println("Name: " + contact[0] + " " + contact[1]);
            System.out.println("Email: " + contact[2]);
            System.out.println("Phone Number: " + contact[3]);
            System.out.println("Company: " + contact[4]);
            System.out.println("Job Title: " + contact[5]);
            System.out.println("City: " + contact[6]);
            System.out.println("Region: " + contact[7]);
            System.out.println("Country: " + contact[8]);
            System.out.println("Notes: " + contact[9]);
            
            System.out.println();
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static int binarySearch(ArrayList<String[]> contacts, String firstName, String lastName) {
        
        int low = 0;
        int high = contacts.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String[] midContact = contacts.get(mid);

            int comparisonResult = compareNames(midContact, firstName, lastName);

            if (comparisonResult < 0) {
                low = mid + 1;
            } else if (comparisonResult > 0) {
                high = mid - 1;
            } else {
                return mid; // Found the contact
            }
        }

        return -1; // Contact not found
    }

    private static int compareNames(String[] contact, String firstName, String lastName) {
        int firstNameComparison = contact[0].compareToIgnoreCase(firstName);
        if (firstNameComparison == 0) {
            return contact[1].compareToIgnoreCase(lastName);
        }
        return firstNameComparison;
    }

    public static void analyzeEfficiency(String firstName, String lastName) {
        String file = "dsa-project-linked-list\\src\\data\\contacts.csv"; // Path to your contacts CSV file
        BufferedReader reader = null;  // Initialize BufferedReader
        String line; // Read each line of the file 

        ArrayList<String[]> contacts = new ArrayList<>(); // List to store contacts

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(","); // Split the line by commas
                contacts.add(row); // Add each row to the contacts list
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

        // Sort the list of contacts based on first name and last name
        Collections.sort(contacts, new Comparator<String[]>() {
            @Override
            public int compare(String[] contact1, String[] contact2) {
                int firstNameComparison = contact1[0].compareToIgnoreCase(contact2[0]);
                if (firstNameComparison == 0) {
                    return contact1[1].compareToIgnoreCase(contact2[1]);
                }
                return firstNameComparison;
            }
        });

        // Measure the time taken for binary search
        long startTime = System.nanoTime();
        int index = binarySearch(contacts, firstName, lastName);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Time taken for binary search: " + duration + " nanoseconds");

    
    }
}