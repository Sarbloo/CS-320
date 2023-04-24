package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import Contact.ContactService;
import Contact.Contact;

class ContactServiceTest extends ContactService {
	//Sets up the vector before each test
	@BeforeEach
	void setupVector() {
		Contact firstContact = new Contact("0001", "Sarah", "Beaty", "5555555555", "12345 Home Address Drive");
		contactList.add(firstContact);
	}
	//Clears the vector after each test
	@AfterEach
	void tearDownVector() {
		contactList.clear();
	}
	//Tests that the contact was added to the list
	@Test
	void testAddedContactToVector() {
		addContact("0002", "Jelly", "Bean", "3333333333", "67890 Jelly Bean Lane");
		for(Contact contact : contactList) {
			if("0002".equals(contact.getContactID())) {
				assertTrue(true);
			}
		}
	}
	//Tests that the exception is thrown if trying to add an id that already exists
	@Test
	void testAddedDuplicteID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			addContact("0001", "Sarah", "Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	
	//Tests if the contact was deleted from the vector
	@Test
	void testDeletedContactFromVector() {
		assertTrue(deleteContact("0001"));
	}
	
	//Tests that the update actually changes the entries
	@Test
	void testUpdateFirstName() {
		updateContactInfo("0001", "Jelly", "Bean", "3333333333", "67890 Jelly Bean Lane");
		for(Contact contact : contactList) {
			if("0001".equals(contact.getContactID())) {
				assertTrue("Jelly".equals(contact.getFirstName()));
				assertTrue("Bean".equals(contact.getLastName()));
				assertTrue("3333333333".equals(contact.getPhoneNumber()));
				assertTrue("67890 Jelly Bean Lane".equals(contact.getAddress()));
			}
		}
	}

}
