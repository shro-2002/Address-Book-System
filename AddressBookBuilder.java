package com.bridgeLabs.Master;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @Class variables: ArrayList
 * 
 * @Class Methods: addContact(), getDetails(), display(),editContact(String,String),deleteContact(String,String)
 *  
 * @description: Ability to Create and Manage Contacts
 */

public class AddressBookBuilder {

	/*
	 * @params: None
	 * 
	 * @return: None
	 * 
	 * @description: Ability to create Contacts in Address Book
	 */

	private ArrayList<Contact> contactList = new ArrayList<Contact>();

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
		contactList.add(contact);
	}

	/*
	 * @params:
	 * 
	 * @return: void
	 * 
	 * @description: Ability to display new Contact to Address Book
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
	 * @params: String,String
	 * 
	 * @return: void
	 * 
	 * @description: Ability to edit existing contact person using their name
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
			}
		}

		if (!contactFound) {
			System.out.print("Contact Not Found");
		}

	}
	/*
	 * @params: String,String
	 * 
	 * @return: void
	 * 
	 * @description: Ability to delete a person using person's name
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
}
