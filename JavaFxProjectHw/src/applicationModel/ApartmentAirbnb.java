package applicationModel;


public class ApartmentAirbnb extends ApartmentForRent implements Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double pricePerDay;

	public ApartmentAirbnb(int id, String address, double areaSize, double numOfRooms, int apartmentRating,
			double pricePerDay, int duration) throws ExceptionRange, NumberFormatException {
		super(id, address, areaSize, numOfRooms, apartmentRating, 0, duration);
		this.pricePerDay = pricePerDay;

	}


	@Override
	public double priceForDuration() {
		//calculate the price of the apartment for the duration
		return duration*pricePerDay;
		
	}

	@Override
	public String toString() {
		return "Apartment Id = " + apartmentId + "\nAddress = " + address + "\nArea Size = " + areaSize
				+ "\nNumber of rooms = " + numOfRooms + "\nPrice per day: " + pricePerDay + "\nApartment Rating = "
				+ apartmentRating + "\nDuration of the stay is " + duration;
	}
	


	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		//deep clone the apartment
		ApartmentAirbnb abnb = null ;
		try {
			abnb = new ApartmentAirbnb(1, "", 1, 1, 1, 1, 1);
			abnb.setApartmentId(this.getapartmentId());
			abnb.setAddress(this.getAddress());
			abnb.setAreaSize(this.getAreaSize());
			abnb.setNumOfRooms(this.getNumOfRooms());
			abnb.setApartmentRating(this.getApartmentRating());
			abnb.setDuration(this.getDuration());
			abnb.setPricePerDay(this.pricePerDay);
			for(int i =0;i<arrayCustomer.size();i++) {
				abnb.arrayCustomer.add(i, super.arrayCustomer.get(i));
			
			}

			
		}
		catch(ExceptionRange e) {
			System.out.println(e.getMessage());
		}
		return abnb;
	}
	
	
	

}
