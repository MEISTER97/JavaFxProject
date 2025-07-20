package applicationModel;

import java.io.Serializable;
import java.util.ArrayList;

abstract public class Apartment implements Cloneable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int apartmentId;
	protected String address;
	protected double areaSize;
	protected double numOfRooms;
	protected int apartmentRating;
	public ArrayList<Customer> arrayCustomer = new ArrayList<Customer>();

	public Apartment(int apartmentId, String address, double areaSize, double numOfRooms, int apartmentRating) throws ExceptionRange {
		if((apartmentRating>10||apartmentRating<0))
			throw new ExceptionRange(apartmentRating,"apartmentRating");
		if (apartmentId <0 )
			throw new ExceptionRange(apartmentId,"apartmentId");
		if (areaSize<0)
			throw new ExceptionRange((int)areaSize,"areaSize");
		if(numOfRooms<0)
			throw new ExceptionRange((int)numOfRooms,"numOfRooms");
		
		this.apartmentId = apartmentId;
		this.address = address;
		this.areaSize = areaSize;
		this.numOfRooms = numOfRooms;
		this.apartmentRating = apartmentRating;
	}

	public boolean findPhoneNumber(String phoneNumber) {
		for (int i = 0; i < this.arrayCustomer.size(); i++) {
			if (this.arrayCustomer.get(i).getPhoneNumber().equals(phoneNumber))
				// finding within the customer array if the phone number is in the array
				return true;
			
		}

		return false;
	}

	public boolean addNewCustomer(Customer customer) {
		if (this.findPhoneNumber(customer.getPhoneNumber())) {
			// using the method "findPhoneNumber if the customer is in the array using phone number
			return false;
		}

		arrayCustomer.add(customer);
		// adding the customer to the customer array list

		return true;
	}

	public StringBuffer printCustomers() {
		StringBuffer s = new StringBuffer()	;
		s.append("Customers List for the appartment [" + getAddress() + "] :\n");
		for (int i = 0; i < this.arrayCustomer.size(); i++) {
			// going through loop to print all the customers in the array
			s.append(arrayCustomer.get(i).toString()+"\n");

		}
		return s;
	}


	public StringBuffer printSort(ArrayList<Customer> arrayCustomer) {
		StringBuffer s = new StringBuffer()	;
		ArrayList<Customer> tempArrayCustomer = new ArrayList<Customer>(arrayCustomer); 
		// creating a temp arraylist to print sort so it won't change the array
		Customer temp;

		for (int i = 0; i < tempArrayCustomer.size() - 1; i++) {
			for (int j = 0; j < tempArrayCustomer.size() - 1 - i; j++) {
				if (tempArrayCustomer.get(j).getName()
						.compareToIgnoreCase(tempArrayCustomer.get(j + 1).getName()) > 0) {
					temp = tempArrayCustomer.get(j);

					tempArrayCustomer.set(j, tempArrayCustomer.get(j + 1));
					tempArrayCustomer.set(j + 1, temp);
					//using bubble sort technique
				}
			}
		}

		s.append("Customers sorted List for the appartment [" + getAddress() + "] :\n");
		for (int i = 0; i < tempArrayCustomer.size(); i++) {
			s.append(tempArrayCustomer.get(i).toString()+"\n");
		}
		
		return s;		
		
	}
	
	
	
	

	@Override
	public boolean equals(Object obj) {
		// equals method to compare address
		if(this ==obj)
			return true;
		if(obj==null)
			return false;
		if(obj.getClass()!=getClass())
			return false;
		Apartment other = (Apartment) obj;
		if(address== null)
			return other.address==null;
		
		
		return address.equalsIgnoreCase(other.address);
	}
	
	
	public abstract String toString();
	
	public abstract double priceForDuration();
	
	public abstract int getDuration() ;

	public int getapartmentId() {
		return apartmentId;
	}
	
	public abstract double getCommission() ;
	

	public String getAddress() {
		return address;
	}

	public double getAreaSize() {
		return areaSize;
	}

	public double getNumOfRooms() {
		return numOfRooms;
	}

	public int getApartmentRating() {
		return apartmentRating;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAreaSize(double areaSize) {
		this.areaSize = areaSize;
	}

	public void setNumOfRooms(double numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

	public void setApartmentRating(int apartmentRating) {
		this.apartmentRating = apartmentRating;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	


	
	
	


}
