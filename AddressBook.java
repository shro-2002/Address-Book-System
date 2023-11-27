package com.bridgeLabs.Master;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");

		Contact contact = AddressBookBuilder.getdetails();
		AddressBookBuilder.display(contact);

	}

}
