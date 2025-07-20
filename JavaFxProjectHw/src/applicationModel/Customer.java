package applicationModel;

import java.io.Serializable;

public class Customer implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phoneNumber;

	public Customer(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer name : " + name + ", phoneNumber : " + phoneNumber+"\n";
	}

	public void setName(String name) { // to set customer name for sort
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		// equals method to compare phone number
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass() != getClass())
			return false;
		Customer other = (Customer) obj;
		if (phoneNumber == null)
			return other.phoneNumber == null;

		return phoneNumber.equals(other.phoneNumber);

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Customer c = new Customer("","");
		c.setName(this.name);
		c.setPhoneNumber(this.phoneNumber);
		return c;
	}
	
	
	

}
