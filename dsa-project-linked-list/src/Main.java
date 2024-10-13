import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import deleteContactModule.DeleteContact;
import sortModule.MergeSortFile;

import BinarySearch.updateContact;
import searchModule.searchContact;

import displayContactModule.DisplayContacts;
import insertContactModule.InsertContact;

public class Main {
    public static void main(String[] args) {
        // Ensure the file exists
        ensureFileExists("dsa-project-linked-list\\src\\data\\contacts.csv");

        MergeSortFile.sortTheCsv();
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Phonebook Menu:");
            System.out.println("1. Insert Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Update Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = getUserChoice(scanner);
            
            switch (choice) {
                case 1:
                    insertContact(scanner);
                    break;
                case 2:
                    searchContact(scanner);
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    DisplayContacts.displayContacts();
                    break;
                case 5:
                    updateContact(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void ensureFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
            }
        }
        return choice;
    }

    private static void insertContact(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        InsertContact.addContact(firstName, lastName, phoneNumber, email, email, email, email, email, email, email);
    }

    private static void searchContact(Scanner scanner) {
        System.out.print("Enter first name of the contact you want to search for: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name of the contact you want to search for: ");
        String lastName = scanner.nextLine();
        searchContact.findContact(firstName, lastName);
    }

    private static void updateContact(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        updateContact.searchAndUpdate(firstName, lastName);
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        DeleteContact.deleteContact(firstName, lastName);
    }
}
