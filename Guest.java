package curs11CompunereAgregare;

public class Guest {

	String lastName, firstName;
	String fullName;
	String email;
	String phoneNumber;
	static int cazComparatie = 0;
	
	Guest(){
	}
	Guest(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.fullName = firstName + " " + lastName;
	}	
	Guest(String s) {
		switch (cazComparatie) {
			case 1:
				this.fullName = s;
			case 2:
				this.email = s;
			case 3:
				this.phoneNumber = s;
		}			
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getFullName() {
		return this.fullName;
	}
	@Override
	public String toString() {
		return "Guest [lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Guest other = (Guest) obj;
		if (cazComparatie == 1 || cazComparatie == 0) {
			if (this.getFullName() == null|| other.getFullName() == null) {
				return false;
			} else if (this.getFullName().equals(other.getFullName())) {
				return true;
			}
		}
		if (cazComparatie == 2 || cazComparatie == 0) {
			if (email == null || other.email == null) {
				return false;
			} else if (email.equals(other.email)) {
				return true;
			}
		}
		if (cazComparatie == 3 || cazComparatie == 0) {
			if (phoneNumber == null || other.phoneNumber == null) {
				return false;
			} else if (phoneNumber.equals(other.phoneNumber)) {
				return true;
			}
		}
		return false;
	}

}
