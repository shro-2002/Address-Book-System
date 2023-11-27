package com.bridgeLabs.Master;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Class Variables: HashMap, AddressBookBuilder
 * 
 * Class Methods: createAddressBook, selectAddressBook, displayAllAddressBooks, manageAddressBook
 * 
 * Description: This class is used to create, select and display all the address books.
 */

public class AddressBookManager {

	private Map<String, AddressBookBuilder> addressBooks = new HashMap<>();
	private AddressBookBuilder currentAddressBook;

	/*
	 * @param: String
	 * 
	 * @return: void
	 * 
	 * @Description: This method is used to create a new address book.
	 */

	void createAddressBook(String Name) {

		if (!addressBooks.containsKey(Name)) {
			AddressBookBuilder newAddressBook = new AddressBookBuilder();
			addressBooks.put(Name, newAddressBook);
			System.out.println("Address Book '" + Name + "' created successfully.");
		} else {
			System.out.println("Address Book '" + Name + "' already exists. Please choose a different name.");
		}
	}

	/*
	 * @param: String
	 * 
	 * @return: void
	 * 
	 * @Description: This method is used to select an existing address book.
	 */

	void selectAddressBook(String Name) {
		if (addressBooks.containsKey(Name)) {
			currentAddressBook = addressBooks.get(Name);
			System.out.println("Selected Address Book: " + Name);
			manageAddressBook();
		} else {
			System.out.println("Address Book not found: " + Name);
		}
	}

	/*
	 * @param: void
	 * 
	 * @return: void
	 * 
	 * @Description: This method is used to display all the address books.
	 */
	void displayAllAddressBooks() {
		System.out.println("All Address Books:");
		for (String name : addressBooks.keySet()) {
			System.out.println("- " + name);
		}

	}

	/*
	 * @param: void
	 * 
	 * @return: void
	 * 
	 * @Description: This method is used to manage the address book.
	 */
	void manageAddressBook() {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		AddressBookBuilder addressBook = new AddressBookBuilder();

		while (choice != 5) {
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Display Contact");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the number of contacts you want to add: ");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					addressBook.getdetails();
					System.out.println("Contact added successfully");
				}
				break;
			case 2:
				System.out.println("Enter the first name: ");
				String firstName = sc.next();

				System.out.println("Enter the last name: ");
				String lastName = sc.next();

				addressBook.editContact(firstName, lastName);
				break;
			case 3:
				System.out.println("Enter the first name: ");
				String firstName1 = sc.next();

				System.out.println("Enter the last name: ");
				String lastName1 = sc.next();

				addressBook.deleteContact(firstName1, lastName1);
				break;
			case 4:
				addressBook.display();
				break;
			case 5:
				System.out.println("Exiting the Book");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}

	}

}
