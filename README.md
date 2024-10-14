# DSA Group Project

Our project is a simple phonebook application implemented in Java. It allows users to insert, search, delete, update, and display contacts stored in a CSV file. The application uses various data structures and algorithms to manage and manipulate the contact data efficiently. We use Binary search for searching functions, deleting when finding the correct contact. When inserting, we append it to the end of the file, and then sort the file. 
We ensure the .csv is sorted at all times. So after any operation, which manipulates the file, we sort it.

**Contributors:**
`Jaden Awiseb`
`Rejoice Teca`
`Hileni Nghiishililwa`
`Adolf David`
`Andris Kaishungu`
`Uutshona Kaholongo`





## Features

- **Insert Contact**: Add a new contact to the phonebook.
- **Search Contact**: Search for a contact by first name and last name.
- **Delete Contact**: Remove a contact from the phonebook.
- **Update Contact**: Update the details of an existing contact.
- **Display All Contacts**: Display all contacts in the phonebook.

## Modules and Key Methods

### Main Module
- `displayMenu()`: Displays the main menu options.
- `getUserChoice(Scanner scanner)`: Gets the user's choice from the menu.
- `insertContact(Scanner scanner)`: Handles the insertion of a new contact.
- `searchContact(Scanner scanner)`: Handles the search for a contact.
- `deleteContact(Scanner scanner)`: Handles the deletion of a contact.

### InsertContact Module
- `addContact(String firstName, String lastName, String email, String phoneNumber, String company, String jobTitle, String city, String region, String country, String notes)`: Adds a new contact to the list and saves it to the CSV file.
- `saveContactToCSV(Contact contact)`: Saves the contact details to the CSV file.

### SearchContact Module
- `searchContact()`: Prompts the user for the first and last name of the contact to search for.
- `searchContact(String firstName, String lastName)`: Searches for a contact in the CSV file using the provided names.

### DeleteContact Module
- `deleteContact(String firstName, String lastName)`: Deletes a contact from the CSV file based on the provided names.

### DisplayContacts Module
- `displayContacts()`: Displays all contacts from the CSV file.
- `getColumnWidths(String[] headers)`: Calculates the column widths for display.
- `printRow(String[] row, int[] columnWidths)`: Prints a single row with aligned columns.
- `printSeparator(int[] columnWidths)`: Prints a separator line between header and data rows.

### BinarySearch Module
- `loadContacts(String filePath)`: Loads contacts from the CSV file.
- `sortContacts(List<String[]> contacts)`: Sorts the contacts by first name and last name.
- `binarySearch(List<String[]> contacts, String firstName, String lastName)`: Performs a binary search to find a contact by first name and last name.

### MergeSortFile Module
- `sortTheCsv()`: Sorts the contacts in the CSV file based on the first name using the Merge Sort algorithm.

## CSV File Structure

The contacts are stored in a CSV file with the following columns:
- First Name
- Last Name
- Email
- Phone Number
- Company
- Job Title
- City
- Region
- Country
- Notes

## How to Run

1. Ensure you have Java installed on your system.
2. Clone the repository.
3. Navigate to the project directory.
4. Compile the Java files.
5. Run the `Main` class to start the application.


