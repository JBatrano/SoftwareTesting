/**
 * Name: Jacob Batrano
 * Date: April 12, 2024
 * Class: CS-320
 * School: SNHU
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContactServiceTest {
    private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
        // Add a contact that we can use for update tests
        service.addContact("ID12345678", "Jacob", "Batrano", "1234567890", "123 Main St");
    }

    @Test
    public void testAddNewContact() {
        service.addContact("NEWID12345", "Bart", "Simpson", "9876543210", "742 Evergreen Terrace");
        assertNotNull(service.getContact("NEWID12345"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContactWithDuplicateId() {
        service.addContact("ID12345678", "Bart", "Simpson", "9876543210", "742 Evergreen Terrace");
    }

    @Test
    public void testDeleteContact() {
        service.deleteContact("ID12345678");
        assertNull(service.getContact("ID12345678"));
    }

    @Test
    public void testUpdateContact() {
        // Update all fields for the contact
        service.updateFirstName("ID12345678", "Bart");
        service.updateLastName("ID12345678", "Simpson");
        service.updatePhone("ID12345678", "9876543210");
        service.updateAddress("ID12345678", "742 Evergreen Terrace");

        // Retrieve the updated contact and check the new values
        Contact updated = service.getContact("ID12345678");
        assertNotNull(updated);
        assertEquals("Bart", updated.getFirstName());
        assertEquals("Simpson", updated.getLastName());
        assertEquals("9876543210", updated.getPhone());
        assertEquals("742 Evergreen Terrace", updated.getAddress());
    }
}


