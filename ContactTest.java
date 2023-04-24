package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Contact.Contact;
import Contact.ContactService;

class ContactTest extends ContactService{
	
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
	
	//Tests that the contact object is created
	@Test
	void testContact() {
		Contact contact = new Contact("0001", "Sarah", "Beaty", "5555555555", "12345 Home Address Drive");
		assertTrue(contact.getContactID().equals("0001"));
		assertTrue(contact.getFirstName().equals("Sarah"));
		assertTrue(contact.getLastName().equals("Beaty"));
		assertTrue(contact.getPhoneNumber().equals("5555555555"));
		assertTrue(contact.getAddress().equals("12345 Home Address Drive"));
	}
	//Tests that the contact ID throws the exception when null or too long
	@Test
	void testContactIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Sarah", "Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Sarah", "Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	//Tests that the first name throws the exception when null or too long
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", null, "Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "San Miguel ", "Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	//Tests that the last name throws an exception when null or too long
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "Sarah", null, "5555555555", "12345 Home Address Drive");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "Sarah", "Alvarado-Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	//Tests that the phone throws an exception if null, too long, or too short
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "Sarah", "Beaty", null, "12345 Home Address Drive");
		});
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "Sarah", "Beaty", "55555555551", "12345 Home Address Drive");
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "Sarah", "Beaty", "555", "12345 Home Address Drive");
		});
	}
	//Tests that the address throws an exception if null or too long
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "Sarah", "Beaty", "5555555555", null);
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0001", "Sarah", "Beaty", "5555555555", "12345 Home Address Is this thirty yet?");
		});
	}
	
	//The tests below test that the exceptions are thrown when the updated information
	// is not formatted correctly
	@Test
	void testUpdateFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", null, "Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	@Test
	void testUpdateFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 updateContactInfo("0001", "San Miguel ", "Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	@Test
	void testUpdateLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", "Sarah", null, "5555555555", "12345 Home Address Drive");
		});
	}
	@Test
	void testUpdateLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", "Sarah", "Alvarado-Beaty", "5555555555", "12345 Home Address Drive");
		});
	}
	@Test
	void testUpdatePhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", "Sarah", "Beaty", null, "12345 Home Address Drive");
		});
	}
	@Test
	void testUpdatePhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", "Sarah", "Beaty", "55555555551", "12345 Home Address Drive");
		});
	}
	@Test
	void testUpdatePhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", "Sarah", "Beaty", "555", "12345 Home Address Drive");
		});
	}
	@Test
	void testUpdateAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", "Sarah", "Beaty", "5555555555", null);
		});
	}
	@Test
	void testUpdateAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			updateContactInfo("0001", "Sarah", "Beaty", "5555555555", "12345 Home Address Is this thirty yet?");
		});
	}
	@Test
	void testIsDuplicateID() {
		Contact firstContact = new Contact("0001", "Sarah", "Beaty", "5555555555", "12345 Home Address Drive");
		contactList.add(firstContact);
		assertTrue(firstContact.isDuplicate(contactList));
	}

}
