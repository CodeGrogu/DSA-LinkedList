import BinarySearch.BinarySearch;
import java.util.Scanner;

import deleteContactModule.DeleteContact;
import sortModule.MergeSortFile;

import updateModule.UpdateContact;
import SearchModule.SearchContact;

import displayContactModule.DisplayContacts;
import insertContactModule.InsertContact;

public class Main {
    public static void main(String[] args) {

        MergeSortFile.sortTheCsv();
        

        Scanner scanner = new Scanner(System.in);
        int choice;

        displayMenu();
        choice = getUserChoice(scanner);

        do {
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
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    BinarySearch.searchAndUpdate(firstName, lastName);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            displayMenu();
            choice = getUserChoice(scanner);
        } while (choice != 6);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nPhonebook Menu:");
        System.out.println("1. Insert Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Display All Contacts");
        System.out.println("5. Update Contact");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 6.");
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
        InsertContact.addContact(firstName, lastName, phoneNumber, email);


    }

    private static void searchContact(Scanner scanner) {
        System.out.print("Enter first name of the contact you want to search for: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name of the contact you want to search for: ");
        String lastName = scanner.nextLine();
        SearchContact.searchContact(firstName, lastName);
}



    private static void UpdateContact(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
    }
}