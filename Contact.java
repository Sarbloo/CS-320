package Contact;

import java.util.Vector;

public class Contact {
	//Initialize the private strings so they cannot be changed without proper methods
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Default constructor
	public Contact() {
		
	}
	//The constructor for the full contact information
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		//Exception thrown if id is null or longer then 10
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid contact id.");
		}
		//Exception thrown if first name is null or too long
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		//Exception thrown if last name is null or too long
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		//Exception thrown if phone is null or not 10 long
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		//Exception thrown if address is null or too long
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}
		//Sets the variables to the parameters
		contactID = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
	//The update for the first name, throws an exception if entered wrong
	public void updateFirstName(String name) {
		
		if(name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		
		firstName = name;
		
	}
	//The update for the last name, throws an exception if entered wrong
	public void updateLastName(String name) {
		
		if(name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		
		lastName = name;
		
	}
	//The update for the phone number, throws an exception if entered wrong
	public void updatePhoneNumber(String phone) {
		
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		
		this.phone = phone;
		
	}
	//The update for the address, throws and exception if entered wrong
	public void updateAddress(String address) {
		
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}
		
		this.address = address;
		
	}
	//Below are the getters for the contact information
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	//This is a method that checks if the ID is duplicated in the vector
	public boolean isDuplicate(Vector<Contact> contactList) {
		for(Contact obj : contactList) {
			if(contactID.equals(obj.getContactID())) {
				return true;
			}
		}
		return false;
	}
}
