package com.bridgeLabs.Master;

import java.util.Objects;

/*
 * @Class Variables: firstName, lastName, address, city, state, zip, phoneNumber, email
 * 
 * @Class Methods: Setter and Getter methods for variables
 * 
 * @description: UC-1 Ability to create a Contacts in Address Book with first and last names, address,city, state, zip, phone number and email
 */

public class Contact {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String email;

	/*
	 * @Description: Parameterized constructor to initialize the variables
	 * 
	 * @Param: firstName, lastName, address, city, state, zip, phoneNumber, email
	 * 
	 * @Return: No return value
	 */

	public Contact(String firstName, String lastName, String address, String city, String state, int zip,
			long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/*
	 * @Description: Getter method to get the first name
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: String
	 */

	public String getFirstName() {
		return firstName;
	}

	/*
	 * @Description: Getter method to get the last name
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: String
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * @Description: Getter method to get the address
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: String
	 */
	public String getAddress() {
		return address;
	}

	/*
	 * @Description: Getter method to get the city
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: String
	 */
	public String getCity() {
		return city;
	}

	/*
	 * @Description: Getter method to get the state
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: String
	 */
	public String getState() {
		return state;
	}

	/*
	 * @Description: Getter method to get the zip
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: int
	 */
	public int getZip() {
		return zip;
	}

	/*
	 * @Description: Getter method to get the phone number
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: long
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/*
	 * @Description: Getter method to get the email
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: String
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * @Description: Setter method to set the first name
	 * 
	 * @Param: String
	 * 
	 * @Return: No return value
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * @Description: Setter method to set the last name
	 * 
	 * @Param: String
	 * 
	 * @Return: No return value
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * @Description: Setter method to set the address
	 * 
	 * @Param: String
	 * 
	 * @Return: No return value
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * @Description: Setter method to set the city
	 * 
	 * @Param: String
	 * 
	 * @Return: No return value
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/*
	 * @Description: Setter method to set the state
	 * 
	 * @Param: String
	 * 
	 * @Return: No return value
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * @Description: Setter method to set the zip
	 * 
	 * @Param: int
	 * 
	 * @Return: No return value
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

	/*
	 * @Description: Setter method to set the phone number
	 * 
	 * @Param: long
	 * 
	 * @Return: No return value
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/*
	 * @Description: Setter method to set the email
	 * 
	 * @Param: String
	 * 
	 * @Return: No return value
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * @Description: Overriding the toString method to print the contact details
	 * 
	 * @Param: No parameters
	 * 
	 * @Return: String
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Contact))
			return false;
		if (obj == this)
			return true;
		return this.getFirstName().equalsIgnoreCase(((Contact) obj).getFirstName())
				&& this.getLastName().equalsIgnoreCase(((Contact) obj).getLastName());
	}

}
