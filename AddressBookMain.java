package com.bridgeLabs.Master;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		AddressBookManager addressBookManager = new AddressBookManager();

		while (choice != 7) {
			System.out.println("1. Create Address Book");
			System.out.println("2. Select Address Book");
			System.out.println("3. Display all Address Books");
			System.out.println("4. Search Person in City");
			System.out.println("5. Search Person in State");
			System.out.println("6. Display Count of Persons in State and City");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the name of the Address Book: ");
				String name = sc.next();
				addressBookManager.createAddressBook(name);
				break;
			case 2:
				System.out.println("Enter the name of the Address Book: ");
				String name1 = sc.next();
				addressBookManager.selectAddressBook(name1);
				break;
			case 3:
				addressBookManager.displayAllAddressBooks();
				break;
			case 4:
				System.out.println("Enter the city: ");
				String city = sc.next();
				addressBookManager.viewPersonsByCity(city);
				break;
			case 5:
				System.out.println("Enter the State: ");
				String state = sc.next();
				addressBookManager.viewPersonsByState(state);
				break;
			case 6:
				System.out.println("Enter the city: ");
				String city1 = sc.next();
				System.out.println("Enter the State: ");
				String state1 = sc.next();
				addressBookManager.displayCountByCityAndState(city1, state1);
				break;
			case 7:
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}

}
