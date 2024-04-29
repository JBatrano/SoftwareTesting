/**
 * Name: Jacob Batrano
 * Date: April 12, 2024
 * Class: CS-320
 * School: SNHU
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique and non-null.");
        }
        validateFields(firstName, lastName, phone, address);
        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, newContact);
    }

    private void validateFields(String firstName, String lastName, String phone, String address) {
        if (firstName == null || lastName == null || phone == null || address == null) {
            throw new IllegalArgumentException("Fields must not be null.");
        }
        if (phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits long.");
        }
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be less than or equal to 10 characters.");
        }
        Contact contactToUpdate = getExistingContact(contactId);
        contactToUpdate.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be less than or equal to 10 characters.");
        }
        Contact contactToUpdate = getExistingContact(contactId);
        contactToUpdate.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits and numeric.");
        }
        Contact contactToUpdate = getExistingContact(contactId);
        contactToUpdate.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be less than or equal to 30 characters.");
        }
        Contact contactToUpdate = getExistingContact(contactId);
        contactToUpdate.setAddress(address);
    }

    private Contact getExistingContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        return contacts.get(contactId);
    }
}




