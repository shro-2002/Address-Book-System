package com.bridgeLabs.Master;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		AddressBookBuilder addressBook = new AddressBookBuilder();

		while (choice != 4) {
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Display Contact");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addressBook.getdetails();
				break;
			case 2:
				System.out.println("Enter the first name: ");
				String firstName = sc.nextLine();
				addressBook.editContact(firstName);
				break;
			case 3:
				addressBook.display();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}

	}

}
