package com.bridgeLabs.Master;

import java.util.Scanner;

/*
 * Class variables: None
 * 
 * Class Methods: addContact(), getDetails(), display()
 * 
 * @description: UC-2 Ability to add a new Contact to Address Book
 */

public class AddressBookBuilder {

	/*
	 * @params: None
	 * 
	 * @return: contact
	 * 
	 * @description: Ability to create a Contacts in Address Book with first and
	 */

	static Contact getdetails() {
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

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		return contact;
	}

	static void display(Contact contact) {
		System.out.println();
		System.out.println("Contact Details: ");
		System.out.println(contact.getFirstName());
		System.out.println(contact.getLastName());
		System.out.println(contact.getAddress());
		System.out.println(contact.getCity());
		System.out.println(contact.getState());
		System.out.println(contact.getZip());
		System.out.println(contact.getPhoneNumber());
		System.out.println(contact.getEmail());

	}

}
