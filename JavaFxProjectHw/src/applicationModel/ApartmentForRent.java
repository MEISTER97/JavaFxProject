package applicationModel;


public class ApartmentForRent extends Apartment implements IApartmentCommission, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int duration;
	private double pricePerMonth;

	public ApartmentForRent(int id, String address, double areaSize, double numOfRooms, int apartmentRating,
			double pricePerMonth,int duration ) throws ExceptionRange, NumberFormatException {
		super(id, address, areaSize, numOfRooms, apartmentRating);
		if(pricePerMonth<0)
			throw new ExceptionRange((int)pricePerMonth,"pricePerMonth");

			if(duration<0)
				throw new ExceptionRange(duration,"duration");

		this.pricePerMonth = pricePerMonth;
		this.duration=duration;
	}

	public int getDuration() {
		return duration;
	}

	
	public double priceForDuration() {
		int monthsCount=0;
		int saveDuration=duration;
		while(saveDuration>30){
			saveDuration-=30;
			monthsCount++;
		}
		// calculate the price of the apartment for the duration
		return saveDuration == 0 ? monthsCount*pricePerMonth : (monthsCount+1)*pricePerMonth;
		
	}
	
	@Override
	public String toString() {
		 	 	return "Apartment Id = " + apartmentId + "\nAddress = " + address + "\nArea Size = " + areaSize
				+ "\nNumber of rooms = " + numOfRooms + "\nPrice per Month: "+ pricePerMonth+ "\nApartment Rating = " + apartmentRating+ 
				"\nDuration of the stay is " + duration;
	}
	


	public double getCommission() {
		return 4000;
	}
	
	

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		//deep clone the apartment
		ApartmentForRent afr = null ;
		try {
			afr = new ApartmentForRent(1, "", 1, 1, 1, 1, 1);
			afr.setApartmentId(this.getapartmentId());
			afr.setAddress(this.getAddress());
			afr.setAreaSize(this.getAreaSize());
			afr.setNumOfRooms(this.getNumOfRooms());
			afr.setApartmentRating(this.getApartmentRating());
			afr.setDuration(this.getDuration());
			afr.setPricePerMonth(this.pricePerMonth);
			for(int i =0;i<arrayCustomer.size();i++) {
				afr.arrayCustomer.add(i, super.arrayCustomer.get(i));
			
			}
		}
		catch(ExceptionRange e) {
			System.out.println(e.getMessage());
		}
		return afr;
	
	}




	
	
	
	
}
