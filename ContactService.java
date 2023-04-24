package Contact;

import java.util.Vector;

public class ContactService extends Contact {
	//The vector for the contact information to sit in
	public Vector<Contact> contactList = new Vector<Contact>();
	
	//The method for adding the contact
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		//Creates a new contact object
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		//Checks to make sure the new contact is not already in the vector
		if(newContact.isDuplicate(contactList)) {
			//If the contact already exists, throws an exception
			throw new IllegalArgumentException("Contact ID already exists.");
		}
		//else, adds the contact to the vector.
		contactList.add(newContact);
	}
	
	//The method for deleting a contact
	public boolean deleteContact(String contactID) {
		// A boolean check if it is false or not
		boolean deletedSuccessfully = false;
		// Iterates through the contact list
		for(int i = 0; i < contactList.size(); i++) {
			// If the given contact id is found,
			if(contactID.equals(contactList.get(i).getContactID())) {
				// Removes the contact from the vector and changed the result to true
				contactList.remove(i);
				deletedSuccessfully = true;
			}
		}
		// Returns the result
		return deletedSuccessfully;
	}
	//The method for updating information, based on the id number
	public void updateContactInfo(String contactID, String firstName, String lastName, String phone, String address) {
		//Searches through the list for the contact id
		for(Contact contact : contactList) {
			if(contactID.equals(contact.getContactID())) {
				//If found, updates the information for the name, phone, and address
				contact.updateFirstName(firstName);
				contact.updateLastName(lastName);
				contact.updatePhoneNumber(phone);
				contact.updateAddress(address);
			}
		}
	}
}
