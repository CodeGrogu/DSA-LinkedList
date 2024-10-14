package deleteContactModule;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import BinarySearch.*;

public class DeleteContact {

    public static void deleteContact(String firstName, String lastName) throws IOException {
        BinarySearch binary = new BinarySearch();
        
        // Load contacts from the CSV file
        List<String[]> contacts = BinarySearch.loadContacts("dsa-project-linked-list\\src\\data\\contacts.csv");
        binary.sortContacts(contacts);
        int resultIndex = binary.binarySearch(contacts, firstName, lastName);
        if (resultIndex != -1) {
            // Contact found, proceed to delete
            contacts.remove(resultIndex); // Remove the contact from the list
            BinarySearch.saveContacts("dsa-project-linked-list\\src\\data\\contacts.csv", contacts); // Save the updated contacts
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first name of the contact to delete: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the last name of the contact to delete: ");
        String lastName = scanner.nextLine();
        deleteContact(firstName, lastName);
        scanner.close();
    }
}