/**
 * Name: Jacob Batrano
 * Date: April 12, 2024
 * Class: CS-320
 * School: SNHU
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContactTest {
    // Constants for the tests
    private final String LONG_CONTACT_ID = "12345678901"; // 11 characters
    private final String TEN_CHAR_NAME = "JacobBatra"; // 10 characters long
    private final String LONG_NAME = "JacobBatrano"; // Longer than 10 characters
    private final String SHORT_PHONE = "123456789"; // 9 digits
    private final String LONG_PHONE = "12345678901"; // 11 digits
    private final String NON_DIGIT_PHONE = "12345678a0"; // Non-digit characters included
    private final String LONG_ADDRESS = "123 Main Street in the City of Indust"; // Longer than 30 characters

    private String validContactId, validFirstName, validLastName, validPhone, validAddress;
    
    @Before
    public void setUp() {
        validContactId = "ID12345"; // 7 characters, valid
        validFirstName = "Jacob"; // less than 10 characters, valid
        validLastName = "Batrano"; // less than 10 characters, valid
        validPhone = "1234567890"; // exactly 10 digits, valid
        validAddress = "123 Main St"; // less than 30 characters, valid
    }

    // Test for contactId
    @Test(expected = IllegalArgumentException.class)
    public void testContactIdNull() {
        new Contact(null, validFirstName, validLastName, validPhone, validAddress);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdTooLong() {
        new Contact(LONG_CONTACT_ID, validFirstName, validLastName, validPhone, validAddress);
    }

    @Test
    public void testContactIdExactlyTenChars() {
        Contact contact = new Contact(TEN_CHAR_NAME, validFirstName, validLastName, validPhone, validAddress);
        assertEquals(TEN_CHAR_NAME, contact.getContactId());
    }

    @Test
    public void testContactIdLessThanTenChars() {
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        assertEquals(validContactId, contact.getContactId());
    }

    // Test for firstName
    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameNull() {
        new Contact(validContactId, null, validLastName, validPhone, validAddress);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameTooLong() {
        new Contact(validContactId, LONG_NAME, validLastName, validPhone, validAddress);
    }

    @Test
    public void testFirstNameExactlyTenChars() {
        Contact contact = new Contact(validContactId, TEN_CHAR_NAME, validLastName, validPhone, validAddress);
        assertEquals(TEN_CHAR_NAME, contact.getFirstName());
    }

    @Test
    public void testFirstNameLessThanTenChars() {
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        assertEquals(validFirstName, contact.getFirstName());
    }

    // Test for lastName
    @Test(expected = IllegalArgumentException.class)
    public void testLastNameNull() {
        new Contact(validContactId, validFirstName, null, validPhone, validAddress);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameTooLong() {
        new Contact(validContactId, validFirstName, LONG_NAME, validPhone, validAddress);
    }

    @Test
    public void testLastNameExactlyTenChars() {
        Contact contact = new Contact(validContactId, validFirstName, TEN_CHAR_NAME, validPhone, validAddress);
        assertEquals(TEN_CHAR_NAME, contact.getLastName());
    }

    @Test
    public void testLastNameLessThanTenChars() {
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        assertEquals(validLastName, contact.getLastName());
    }

    // Test for phone
    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNull() {
        new Contact(validContactId, validFirstName, validLastName, null, validAddress);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooLong() {
        new Contact(validContactId, validFirstName, validLastName, LONG_PHONE, validAddress);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooShort() {
        new Contact(validContactId, validFirstName, validLastName, SHORT_PHONE, validAddress);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNonDigit() {
        new Contact(validContactId, validFirstName, validLastName, NON_DIGIT_PHONE, validAddress);
    }

    @Test
    public void testPhoneExactlyTenDigits() {
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        assertEquals(validPhone, contact.getPhone());
    }

    // Test for address
    @Test(expected = IllegalArgumentException.class)
    public void testAddressNull() {
        new Contact(validContactId, validFirstName, validLastName, validPhone, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressTooLong() {
        new Contact(validContactId, validFirstName, validLastName, validPhone, LONG_ADDRESS);
    }

    @Test
    public void testAddressExactlyThirtyChars() {
        String thirtyCharAddress = "123456789012345678901234567890"; // exactly 30 characters
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, thirtyCharAddress);
        assertEquals(thirtyCharAddress, contact.getAddress());
    }

    @Test
    public void testAddressLessThanThirtyChars() {
        Contact contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
        assertEquals(validAddress, contact.getAddress());
    }
}


