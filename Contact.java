/**
 * Name: Jacob Batrano
 * Date: April 12, 2024
 * Class: CS-320
 * School: SNHU
 */
public class Contact {
    private final String contactId; // Unique and not updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor with validation for each field
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be non-null and less than or equal to 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be non-null and less than or equal to 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be non-null and less than or equal to 10 characters.");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits and only contain numeric characters.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null and less than or equal to 30 characters.");
	        }
	        
	        this.contactId = contactId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.phone = phone;
	        this.address = address;
	    }

	    // Getters and setters
	    public String getContactId() { return contactId; }
	    public String getFirstName() { return firstName; }
	    public void setFirstName(String firstName) { this.firstName = firstName; }
	    public String getLastName() { return lastName; }
	    public void setLastName(String lastName) { this.lastName = lastName; }
	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }
	    public String getAddress() { return address; }
	    public void setAddress(String address) { this.address = address; }
	}

