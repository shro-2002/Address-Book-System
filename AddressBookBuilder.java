package com.bridgeLabs.Master;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * @Class variables: ArrayList
 * 
 * @Class Methods: addContact(), getDetails(), display(),editContact(String,String),deleteContact(String,String)
 *  
 * @description: Ability to Create and Manage Contacts
 */

public class AddressBookBuilder {

	/*
	 * @Description: Ability to create Contacts in Address Book
	 * 
	 * @params: None
	 * 
	 * @return: None
	 */

	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	private static final String FILE_NAME = "AddressBook.txt";

	void getdetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter the first name: ");
		String firstName = sc.next();
		System.out.print("Enter the last name: ");
		String lastName = sc.next();
		System.out.print("Enter the address: ");
		String address = sc.next();
		System.out.print("Enter the city: ");
		String city = sc.next();
		System.out.print("Enter the state: ");
		String state = sc.next();
		System.out.print("Enter the zip: ");
		int zip = sc.nextInt();
		System.out.print("Enter the phone number: ");
		long phoneNumber = sc.nextLong();
		System.out.print("Enter the email: ");
		String email = sc.next();
		System.out.println();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

		if (!isDuplicate(contact)) {
			contactList.add(contact);
			System.out.println("Contact added successfully.");
		} else {
			System.out.println("Duplicate entry. Contact not added.");
		}

	}

	/*
	 * @Description: Ability to display new Contact to Address Book
	 * 
	 * @Params:None
	 * 
	 * @Return: void
	 */

	void display() {
		for (Contact c : contactList) {
			System.out.println("First Name: " + c.getFirstName());
			System.out.println("Last Name: " + c.getLastName());
			System.out.println("Address: " + c.getAddress());
			System.out.println("City: " + c.getCity());
			System.out.println("State: " + c.getState());
			System.out.println("Zip: " + c.getZip());
			System.out.println("Phone Number: " + c.getPhoneNumber());
			System.out.println("Email: " + c.getEmail());
			System.out.println();
		}

	}

	/*
	 * @Description: Ability to edit existing contact person using their name
	 * 
	 * @Params: String,String
	 * 
	 * @Return: void
	 */

	void editContact(String firstName, String lastName) {
		boolean contactFound = false;
		for (Contact c : contactList) {
			if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
				contactFound = true;
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the address");
				String address = sc.next();
				c.setAddress(address);
				System.out.println("Enter the city");
				String city = sc.next();
				c.setCity(city);
				System.out.println("Enter the state");
				String state = sc.next();
				c.setState(state);
				System.out.println("Enter the zip");
				int zip = sc.nextInt();
				c.setZip(zip);
				System.out.println("Enter the phone number");
				long phoneNumber = sc.nextLong();
				c.setPhoneNumber(phoneNumber);
				System.out.println("Enter the email");
				String email = sc.next();
				c.setEmail(email);
				sc.close();
			}

		}

		if (!contactFound) {
			System.out.print("Contact Not Found");
		}

	}

	/*
	 * @Description: Ability to delete a person using person's name
	 * 
	 * @Params: String,String
	 * 
	 * @Return: void
	 */

	void deleteContact(String firstName, String lastName) {
		ArrayList<Contact> contactsToRemove = new ArrayList<>();
		boolean contactFound = false;
		for (Contact c : contactList) {
			if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
				contactsToRemove.add(c);
				contactFound = true;

			}
		}

		if (contactFound) {
			contactList.removeAll(contactsToRemove);
			System.out.println("Contact deleted successfully.");
		} else {
			System.out.println("Contact not found.");
		}

	}

	/*
	 * @Description: Ability to display sorted contacts alphabetically by name.
	 *
	 * @param: None
	 *
	 * @return: void
	 */
	public void displaySortedContactsbyName() {
		List<Contact> sortedContacts = new ArrayList<>(contactList);
		Collections.sort(sortedContacts);

		System.out.println("Sorted Contacts Alphabetically by Name:");
		sortedContacts.forEach(System.out::println);
	}

	/*
	 * @Description: Helper function to sort contacts by specific Comparator.
	 *
	 * @param: Comparator
	 *
	 * @return: List<Contact>
	 */
	private List<Contact> sortContactsByComparator(Comparator<Contact> comparator) {
		return contactList.stream().sorted(comparator).collect(Collectors.toList());
	}

	/*
	 * @Description: Ability to display sorted contacts by city.
	 *
	 * @param: None
	 *
	 * @return: void
	 */
	public void displaySortedContactsByCity() {
		List<Contact> sortedContactsByCity = sortContactsByComparator(Comparator.comparing(Contact::getCity));
		System.out.println("Sorted Contacts by City:");
		sortedContactsByCity.forEach(System.out::println);
	}

	/*
	 * @Description: Ability to display sorted contacts by state.
	 *
	 * @param: None
	 *
	 * @return: void
	 */
	public void displaySortedContactsByState() {
		List<Contact> sortedContactsByState = sortContactsByComparator(Comparator.comparing(Contact::getState));
		System.out.println("Sorted Contacts by State:");
		sortedContactsByState.forEach(System.out::println);
	}

	/*
	 * @Description: Ability to display sorted contacts by zip.
	 *
	 * @param: None
	 *
	 * @return: void
	 */
	public void displaySortedContactsByZip() {
		List<Contact> sortedContactsByZip = sortContactsByComparator(Comparator.comparingInt(Contact::getZip));
		System.out.println("Sorted Contacts by Zip:");
		sortedContactsByZip.forEach(System.out::println);
	}

	/*
	 * @Description: Ability to check for duplicate entry
	 * 
	 * @Params: Contact
	 * 
	 * @Return: boolean
	 */

	private boolean isDuplicate(Contact newContact) {
		return contactList.stream().anyMatch(contact -> contact.getFirstName().equals(newContact.getFirstName())
				&& contact.getLastName().equals(newContact.getLastName()));
	}

	public ArrayList<Contact> getContactList() {
		return contactList;
	}
}
