package BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

    // Load contacts from the CSV file
    public static List<String[]> loadContacts(String filePath) throws IOException {
        List<String[]> contacts = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        
        // Skip the header line
        br.readLine();
        
        // Read each line and store contact info in the list
        while ((line = br.readLine()) != null) {
            String[] contact = line.split(",");
            contacts.add(contact);
        }
        br.close();
        return contacts;
    }

    // Sort contacts by firstName and lastName
    public static void sortContacts(List<String[]> contacts) {
        Collections.sort(contacts, new Comparator<String[]>() {
            @Override
            public int compare(String[] c1, String[] c2) {
                int firstNameCompare = c1[0].compareToIgnoreCase(c2[0]);
                if (firstNameCompare != 0) {
                    return firstNameCompare;
                } else {
                    return c1[1].compareToIgnoreCase(c2[1]);
                }
            }
        });
    }

    // Perform binary search to find contact by firstName and lastName
    public static int binarySearch(List<String[]> contacts, String firstName, String lastName) {
        int left = 0;
        int right = contacts.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            String[] contact = contacts.get(mid);
            String midFirstName = contact[0];
            String midLastName = contact[1];
            
            int firstNameCompare = firstName.compareToIgnoreCase(midFirstName);
            if (firstNameCompare == 0) {
                int lastNameCompare = lastName.compareToIgnoreCase(midLastName);
                if (lastNameCompare == 0) {
                    return mid;  // Contact found
                } else if (lastNameCompare < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (firstNameCompare < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;  // Contact not found
    }

    // Method to prompt user for updated contact details
    public static String[] promptForNewDetails(String[] contact) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter new details (press Enter to keep the current value):");
            System.out.print("First Name (" + contact[0] + "): ");
            String firstName = scanner.nextLine();
            if (firstName.isEmpty()) firstName = contact[0];

            System.out.print("Last Name (" + contact[1] + "): ");
            String lastName = scanner.nextLine();
            if (lastName.isEmpty()) lastName = contact[1];

            System.out.print("Email (" + contact[2] + "): ");
            String email = scanner.nextLine();
            if (email.isEmpty()) email = contact[2];

            System.out.print("Phone Number (" + contact[3] + "): ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) phoneNumber = contact[3];

            System.out.print("Company (" + contact[4] + "): ");
            String company = scanner.nextLine();
            if (company.isEmpty()) company = contact[4];

            System.out.print("Job Title (" + contact[5] + "): ");
            String jobTitle = scanner.nextLine();
            if (jobTitle.isEmpty()) jobTitle = contact[5];

            System.out.print("City (" + contact[6] + "): ");
            String city = scanner.nextLine();
            if (city.isEmpty()) city = contact[6];

            System.out.print("Region (" + contact[7] + "): ");
            String region = scanner.nextLine();
            if (region.isEmpty()) region = contact[7];

            System.out.print("Country (" + contact[8] + "): ");
            String country = scanner.nextLine();
            if (country.isEmpty()) country = contact[8];

            System.out.print("Notes (" + contact[9] + "): ");
            String notes = scanner.nextLine();
            if (notes.isEmpty()) notes = contact[9];

            return new String[] { firstName, lastName, email, phoneNumber, company, jobTitle, city, region, country, notes };
        }
    }

    // Save the updated contacts list back to the CSV file
    public static void saveContacts(String filePath, List<String[]> contacts) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        // Write header
        bw.write("firstName,lastName,email,phoneNumber,company,jobTitle,city,region,country,notes\n");
        
        // Write each contact back to the file
        for (String[] contact : contacts) {
            bw.write(String.join(",", contact) + "\n");
        }
        bw.close();
    }

    // Method to search and update a contact
    public static void searchAndUpdate(String firstName, String lastName) {
        try {
            // Load contacts from CSV
            List<String[]> contacts = loadContacts("dsa-project-linked-list\\src\\data\\contacts.csv");

            // Sort contacts before performing binary search
            sortContacts(contacts);

            // Perform binary search for a specific contact
            int resultIndex = binarySearch(contacts, firstName, lastName);

            if (resultIndex != -1) {
                String[] foundContact = contacts.get(resultIndex);
                System.out.println("Contact found: " + String.join(", ", foundContact));

                // Prompt user for new details and update the contact
                String[] updatedContact = promptForNewDetails(foundContact);
                contacts.set(resultIndex, updatedContact);

                // Save the updated contacts list back to the CSV
                saveContacts("dsa-project-linked-list\\src\\data\\contacts.csv", contacts);
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Contact not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     // Example usage
    //     searchAndUpdate("John", "Doe");
    // }
}
