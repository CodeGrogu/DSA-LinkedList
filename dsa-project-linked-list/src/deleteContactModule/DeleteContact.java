package deleteContactModule;

import java.util.*;
import java.io.IOException;

public class DeleteContact {
    public static void deleteContact(String firstName, String lastName) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Load contacts from CSV file
            List<String[]> contacts = CSVUtils.readCSV("data/contacts.csv");
            System.out.println("Are you sure you want to delete the contact: " + firstName + " " + lastName + "? (yes/no)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                Iterator<String[]> iterator = contacts.iterator();
                boolean contactFound = false;

                while (iterator.hasNext()) {
                    String[] contact = iterator.next();
                    if (contact[0].equals(firstName) && contact[1].equals(lastName)) {
                        iterator.remove();
                        contactFound = true;
                        System.out.println("Contact deleted successfully.");
                        break;
                    }
                }

                if (!contactFound) {
                    System.out.println("Contact not found.");
                } else {
                    // Save updated contacts back to CSV file
                    CSVUtils.writeCSV("data/contacts.csv", contacts);
                }
            } else {
                System.out.println("Deletion cancelled.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing the CSV file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}