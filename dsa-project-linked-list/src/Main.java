import BinarySearch.BinarySearch;
import Searchmodule.SearchContact;
import deleteContactModule.DeleteContact;

import java.io.IOException;
import java.util.Scanner;

import sortModule.MergeSortFile;


import displayContactModule.DisplayContacts;
import insertContactModule.InsertContact;

public class Main {
    public static void main(String[] args) throws IOException {

        MergeSortFile.sortTheCsv();

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
                    DisplayContacts.displayContacts();
                    break;
                case 5:
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                BinarySearch.searchAndUpdate("John", "Doe");
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
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Company: ");
        String company = scanner.nextLine();
        System.out.print("Enter Job Title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter Region: ");
        String region = scanner.nextLine();
        System.out.print("Enter Country: ");
        String country = scanner.nextLine();
        System.out.print("Enter Notes: ");
        String notes = scanner.nextLine();
        InsertContact.addContact(firstName, lastName, email, phoneNumber, company, jobTitle, city, region, country, notes);


        // InsertContact.addContact(firstName, lastName, phoneNumber, email);


    }
    

    private static void searchContact(Scanner scanner) {
        System.out.print("Enter first name of the contact you want to search for: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name of the contact you want to search for: ");
        String lastName = scanner.nextLine();
        SearchContact.searchContact(firstName, lastName);      
}



    private static void deleteContact(Scanner scanner) throws IOException {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        DeleteContact.deleteContact(firstName, lastName);
        
    }
}