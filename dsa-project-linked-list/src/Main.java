import java.util.Scanner;

import BinarySearch.BinarySearch;
import SearchModule.SearchContact;
import deleteContactModule.DeleteContact;
import insertContactModule.InsertContact;
import sortModule.MergeSortFile;
// import updateModule.UpdateContact;
import displayContactModule.DisplayContacts;

public class Main {
    public static void main(String[] args) {
        MergeSortFile mergeSort = new MergeSortFile();
        // UpdateContact updateContact = new UpdateContact();
        // sort the list before using it
        
        mergeSort.sortTheCsv();

        DisplayContacts display = new DisplayContacts();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = getUserChoice(scanner);

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
                    display.displayContacts();
                    break;
                case 5:
                    //UpdateContact.searchAndUpdate("John", "Doe");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nPhonebook Menu:");
        System.out.println("1. Insert Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Display All Contacts");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }


    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            scanner.next(); // Consume invalid input
            System.out.print("Enter your choice: ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
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
        InsertContact.insertContact(firstName, lastName, phoneNumber, email);

    }
    

    private static void searchContact(Scanner scanner) {
        System.out.print("Enter first name of the contact you want to search for: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name of the contact you want to search for: ");
        String lastName = scanner.nextLine();
        SearchContact.searchContact(firstName, lastName);
}

private static void updateContact(Scanner scanner) {
    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine();
    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine();
    SearchContact.searchContact(firstName, lastName);
}

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        DeleteContact.deleteContact(firstName, lastName);
    }
}