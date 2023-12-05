package com.bridgeLabs.Master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * @Description: This class is used to create, select and display all the address books.
 * 
 * @Class Variables: HashMap
 * 
 * @Class Methods: createAddressBook, selectAddressBook, displayAllAddressBooks, manageAddressBook

 */

public class AddressBookManager {

	private Map<String, AddressBookBuilder> addressBooks = new HashMap<>();
	AddressBookBuilder currentAddressBook;

	/*
	 * @Description: This method is used to create a new address book.
	 * 
	 * @param: String
	 * 
	 * @return: void
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
	 * @Description: This method is used to select an existing address book.
	 * 
	 * @param: String
	 * 
	 * @return: void
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
	 * @Description: This method is used to display all the address books.
	 * 
	 * @param: void
	 * 
	 * @return: void
	 */
	void displayAllAddressBooks() {
		System.out.println("All Address Books:");
		for (String name : addressBooks.keySet()) {
			System.out.println("- " + name);
		}

	}

	/*
	 * @Description: Ability to search Person in a City or State across the multiple
	 * AddressBook hashmaps using Streams
	 * 
	 * @Params: Contact lists
	 * 
	 * @Return: void
	 */

	public void searchPersonInCityOrState(String city, String state) {

		ArrayList<Contact> contactsInCity = new ArrayList<>();
		ArrayList<Contact> contactsInState = new ArrayList<>();
		// traversing hashmap
		for (AddressBookBuilder addressBook : addressBooks.values()) {
			// selecting the contacts having same city
			contactsInCity.addAll(addressBook.getContactList().stream()
					.filter(contact -> contact.getCity().equals(city)).collect(Collectors.toList()));
			// selecting the contacts having same state
			contactsInState.addAll(addressBook.getContactList().stream()
					.filter(contact -> contact.getState().equals(state)).collect(Collectors.toList()));
		}

		// Case: No same cities or states
		if (contactsInCity.size() == 0 || contactsInState.size() == 0) {
			System.out.println("No contacts found in city " + city + " or state " + state);
			return;
		}

		System.out.println("Contacts in city " + city + ":");
		for (Contact contact : contactsInCity) {
			System.out.println(contact.getFirstName() + " " + contact.getLastName());
		}

		System.out.println("Contacts in state " + state + ":");
		for (Contact contact : contactsInState) {
			System.out.println(contact.getFirstName() + " " + contact.getLastName());
		}

		System.out.println("Total contacts in city " + city + ": " + contactsInCity.size());
		System.out.println("Total contacts in state " + state + ": " + contactsInState.size());
	}

	/*
	 * @Description: This method is used to manage the address book.
	 * 
	 * @param: void
	 * 
	 * @return: void
	 */
	void manageAddressBook() {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

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
					currentAddressBook.getdetails();
				}
				break;
			case 2:
				System.out.println("Enter the first name: ");
				String firstName = sc.next();

				System.out.println("Enter the last name: ");
				String lastName = sc.next();

				currentAddressBook.editContact(firstName, lastName);
				break;
			case 3:
				System.out.println("Enter the first name: ");
				String firstName1 = sc.next();

				System.out.println("Enter the last name: ");
				String lastName1 = sc.next();

				currentAddressBook.deleteContact(firstName1, lastName1);
				break;
			case 4:
				currentAddressBook.display();
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
