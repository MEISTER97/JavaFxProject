package applicationModel;

import java.io.Serializable;

public class ApartmentForSell extends Apartment implements IApartmentCommission,Cloneable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double apartmentPrice;

	
	public ApartmentForSell(int apartmentId, String address, double areaSize, double numOfRooms, int apartmentRating,double apartmentPrice) throws ExceptionRange, NumberFormatException {
		super(apartmentId, address, areaSize, numOfRooms, apartmentRating);
		if(apartmentPrice<0)
			throw new ExceptionRange((int)apartmentPrice,"apartmentPrice");
		this.apartmentPrice=apartmentPrice;
	}

	@Override
	public String toString() {
		 	return "Apartment Id = " + apartmentId + "\nAddress = " + address + "\nArea Size = " + areaSize
				+ "\nNumber of rooms = " + numOfRooms + "\nApartment price is= "+ apartmentPrice + "\nApartment Rating = " + apartmentRating 
				;
	}
	
	

	@Override
	public double priceForDuration() {
		return -1;
	//  because the apartment is abstract , the method is for the clas apartment rent/bnb, but this method is not being used
	}

	@Override
	public int getDuration() {
		return -1;
	//  because the apartment is abstract , the method is for the clas apartment rent/bnb, but this method is not being used
	}

	public double getCommission() {
		return apartmentPrice*0.05;
	}
	

	public void setApartmentPrice(double apartmentPrice) {
		this.apartmentPrice = apartmentPrice;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		//deep clone the apartment
		ApartmentForSell afs = null ;
		try {
		afs = new ApartmentForSell(1,"", 1,1,1,1);
		afs.setApartmentId(this.getapartmentId());
		afs.setAddress(this.getAddress());
		afs.setAreaSize(this.getAreaSize());
		afs.setNumOfRooms(this.getNumOfRooms());
		afs.setApartmentRating(this.getApartmentRating());
		afs.setApartmentPrice(this.apartmentPrice);
		for(int i =0;i<arrayCustomer.size();i++) {
			afs.arrayCustomer.add(i, super.arrayCustomer.get(i));
		
		}
		
		}
		catch(ExceptionRange e) {
			System.out.println(e.getMessage());
		}
		return afs;

	}


	 
	
	
	
	

}
