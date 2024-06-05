public class FullName {
	private String firstName;
	private String middleName;
	private String lastName;

	public FullName() {
		this.firstName = "Dummy First Name";
		this.middleName = "Dummy MiddleName";
		this.lastName = "Dummy LastName";
	}

	// First Name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	// Last Name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	// Middle Name
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMiddleName() {
		return middleName;
	}
}