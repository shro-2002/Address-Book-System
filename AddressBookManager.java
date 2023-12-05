package com.bridgeLabs.Master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	private Map<String, List<Contact>> cityPersonDictionary = new HashMap<>();
	private Map<String, List<Contact>> statePersonDictionary = new HashMap<>();

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
	 * @Description: This method is used to search a person in a city and display
	 * all the persons in that city.
	 * 
	 * @param: String
	 * 
	 * @return: void
	 */

	void viewPersonsByCity(String city) {
		List<Contact> personsInCity = addressBooks.values().stream()
				.flatMap(addressBook -> addressBook.getContactList().stream())
				.filter(contact -> contact.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());

		cityPersonDictionary.put(city, personsInCity); // Store in the dictionary
		displayPersons(city, cityPersonDictionary);
	}

	/*
	 * @Description: This method is used to search a person in a state and display
	 * all the persons in that state.
	 * 
	 * @param: String
	 * 
	 * @return: void
	 */
	void viewPersonsByState(String state) {
		List<Contact> personsInState = addressBooks.values().stream()
				.flatMap(addressBook -> addressBook.getContactList().stream())
				.filter(contact -> contact.getState().equalsIgnoreCase(state)).collect(Collectors.toList());

		statePersonDictionary.put(state, personsInState); // Store in the dictionary
		displayPersons(state, statePersonDictionary);
	}

	/*
	 * @Description: This method is used to display all the persons in a city or
	 * state.
	 * 
	 * @param: String, List
	 * 
	 * @return: void
	 */
	private void displayPersons(String location, Map<String, List<Contact>> dictionary) {
		List<Contact> persons = dictionary.get(location);
		if (persons != null) {
			System.out.println("Persons in " + location + ":");
			for (Contact person : persons) {
				System.out.println("- " + person.getFirstName() + " " + person.getLastName());
			}
		} else {
			System.out.println("No persons found in " + location);
		}
	}

	/*
	 * @Description: This method is used to display the count of persons by city and
	 * by state.
	 * 
	 * @param: void
	 * 
	 * @return: void
	 */
	void displayCountByCityAndState(String city, String state) {

		Map<String, Integer> cityCount = addressBooks.values().stream()
				.flatMap(addressBook -> addressBook.getContactList().stream())
				.filter(contact -> contact.getCity().equalsIgnoreCase(city))
				.collect(Collectors.groupingBy(Contact::getCity, Collectors.summingInt(e -> 1)));
		System.out.println("Number of contacts in " + city + ": " + cityCount.get(city));

		Map<String, Integer> stateCount = addressBooks.values().stream()
				.flatMap(addressBook -> addressBook.getContactList().stream())
				.filter(contact -> contact.getState().equalsIgnoreCase(state))
				.collect(Collectors.groupingBy(Contact::getState, Collectors.summingInt(e -> 1)));
		System.out.println("Number of contacts in " + state + ": " + stateCount.get(state));
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
