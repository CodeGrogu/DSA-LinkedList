package deleteContactModule;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class DeleteContact {
    public static void deleteContact(String firstName, String lastName) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Load contacts from CSV file
            List<String[]> contacts = CSVUtils.readCSV("data\\contacts.csv");
            System.out.println("Are you sure you want to delete the contact: " + firstName + " " + lastName + "? (yes/no)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                // Sort contacts
                contacts.sort(Comparator.comparing((String[] contact) -> contact[0])
                                        .thenComparing(contact -> contact[1]));

                // Create a key for binary search
                String[] key = {firstName, lastName};

                // Perform binary search
                int index = Arrays.binarySearch(contacts.toArray(new String[0][0]), key, Comparator.comparing((String[] contact) -> contact[0])
                                                                                                    .thenComparing(contact -> contact[1]));

                if (index >= 0) {
                    contacts.remove(index);
                    System.out.println("Contact deleted successfully.");
                    // Save updated contacts back to CSV file
                    CSVUtils.writeCSV("dsa-project-linked-list\\src\\data\\contacts.csv", contacts);
                } else {
                    System.out.println("Contact not found.");
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
