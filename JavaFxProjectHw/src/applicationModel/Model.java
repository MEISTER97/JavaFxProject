package applicationModel;


import java.io.IOException;
import java.util.ArrayList;



public class Model {
	
	static Office office;
	
	public Model() {
		office = new Office();
		try {
			office.inputFile();
		} catch (ClassNotFoundException | IOException e) {
			try {
				// on first run will add data(because file not exist)
				addData();
			} catch (ExceptionRange e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	//create apartment for sell
	public String createApartment(int ID, String address, double size, double rooms, int rating, double price)  {
		
		try {
			ApartmentForSell apartmentforsell = new ApartmentForSell(ID, address, size, rooms, rating, price);
			if(checkDuplicateApartment(apartmentforsell))
			return "Already in the list";
			else
			office.addNewApartment(apartmentforsell);
		} catch (ExceptionRange e) {
			 	return "Exception range";

		}	

			
		return "";

			
		}
		

		//create apartment for rent
		public String createApartment(int ID, String address, double size, double rooms, int rating, double pricePerMonth,int duration) {
			
			try {
				ApartmentForRent apartmentforrent = new ApartmentForRent(ID, address, size, rooms, rating, pricePerMonth, duration);
				if(checkDuplicateApartment(apartmentforrent)) 
					return "Already in the list";
				
				else
				office.addNewApartment(apartmentforrent);
			} catch (ExceptionRange e) {
				return "Exception range";
			}

			return "";

			}
		//create apartment airbnb
		public String createApartment(int ID, String address, double size, double rooms, int rating,int duration , double pricePerDay) {
				try {
					ApartmentAirbnb apartmentAirbnb= new ApartmentAirbnb(ID, address, size, rooms, rating, pricePerDay, duration);
					
					if(checkDuplicateApartment(apartmentAirbnb))
						return "Already in the list";
			
					else 
					office.addNewApartment(apartmentAirbnb);
				} catch (ExceptionRange e) {
					return "Exception range";
				}

				return "";
			
			}
	
		//create customer
		public boolean getCustomer(String name,String PhoneNum,String address) {
			Customer customer = new Customer(name, PhoneNum);
			
			if(checkDuplicateCustomer(customer,findApartment(address)))
			return false;
					
			else {
			addCustomer(customer,address);
			return true;
			}
			
		}
	
	
	
	
	// add apartment 
	public void addApartment(Apartment apartment){
		office.addNewApartment(apartment);
	}
	// check if the apartment already exist
	public boolean checkDuplicateApartment(Apartment apartment) {
		
		return office.findAddress(apartment.getAddress());
		 
	}
	// get the apartment location in the arraylist
	public Apartment findApartment(String address) {
		return office.arrayAppartment.get(office.findApartmentgetAddress(address));
		
	}
	// add the customer to the address of the apartment
	public void addCustomer(Customer customer,String address) {
		
		office.arrayAppartment.get(office.findApartmentgetAddress(address)).addNewCustomer(customer);
	}
	// check duplciate customer in the aprtment
	public boolean checkDuplicateCustomer(Customer customer, Apartment apartment) {
		return apartment.findPhoneNumber(customer.getPhoneNumber());
						
	}
	// return String buffer of the apartments
	public StringBuffer printApartments() {
		
		return office.printApartments();
	}
	// return arraylist address of the apartments 
	public ArrayList <String> getArrayListApartments() {
		ArrayList<String> Apartments = new ArrayList<>();
		for(int i=0;i<=office.arrayAppartment.size()-1;i++) {
			Apartments.add(office.arrayAppartment.get(i).getAddress());
		}
		return Apartments;
		
	}
	
	//return String buffer of the type of the apartment
	public StringBuffer printApartmentsType(String apartmentType) {
		
		return office.printApartments(apartmentType);
		
	}
	// return arraylist of rent and aiabnb types
	public ArrayList<String> getArrayListApartmentsRent(){
		ArrayList<String> Apartments = new ArrayList<>();
		for(int i=0;i<=office.arrayAppartment.size()-1;i++) {
			office.arrayAppartment.get(i).getClass();
			if(office.arrayAppartment.get(i) instanceof ApartmentForRent) {
				Apartments.add(office.arrayAppartment.get(i).getAddress());
			}
		}
		
		
		return Apartments;
	}
	// return string buffer of total cost for rent
	public StringBuffer getApartmentRentTotalCost(String address) {
		int location = office.findApartmentgetAddress(address);
		StringBuffer s = new StringBuffer();
		s.append("The price for the address : " + address+ " is "+office.arrayAppartment.get(location).priceForDuration()+
				" for the duration of "+ office.arrayAppartment.get(location).getDuration()+" days");
		
		return s;	
	}
	// return most expensive apartment(rent and airbnb)
	public StringBuffer getMostExpensiveApartment() {
		
		return office.mostExpensiveRent();

	}
	//check if there is expensive apartment(if there is apartments in array)
	public boolean ifExpensiveApartmentNotExist() {
		ArrayList<String> test = getArrayListApartmentsRent();
		
			return (test.size()==0) ?  true :  false;
	}
	// return string buffer of customers in address of the apartment
	public StringBuffer getCustomerForApartment(String address) {		
		
		return office.arrayAppartment.get(office.findApartmentgetAddress(address)).printCustomers();
		
	}
	// return string buffer of sorted customers in address of the apartment
	public StringBuffer getSortedCustomerForApartment(String address) {
		return office.arrayAppartment.get(office.findApartmentgetAddress(address)).printSort
		(office.arrayAppartment.get(office.findApartmentgetAddress(address)).arrayCustomer);
	}
	// return apartments with commissions
	public StringBuffer getApartmentCommission() {
		
		return office.printApartmentsCommission();
		
	}

	// return string buffer duplicate apartment 
	public StringBuffer ApartmentDuplication(String address) {
		StringBuffer s = new StringBuffer();
		int apartmentArrayLocation = office.findApartmentgetAddress(address);	
		if(apartmentArrayLocation!=-1) {
			try {
		if(	office.arrayAppartment.get(apartmentArrayLocation).getClass().getSimpleName().equals("ApartmentForRent")) {
			ApartmentForRent afr =  (ApartmentForRent) office.arrayAppartment.get(apartmentArrayLocation).clone();
			s.append(afr.toString()+"\n"+afr.arrayCustomer.toString()+"\n");
			if(afr.equals(office.arrayAppartment.get(apartmentArrayLocation))) {
				s.append("clone successfully\n");
			}
		}
		else if (office.arrayAppartment.get(apartmentArrayLocation).getClass().getSimpleName().equals("ApartmentAirbnb")) {
			ApartmentAirbnb aab =  (ApartmentAirbnb) office.arrayAppartment.get(apartmentArrayLocation).clone();
			s.append(aab.toString() + "\n"+aab.arrayCustomer.toString()+"\n");
			s.append("clone successfully\n");

		}
		
		else if (office.arrayAppartment.get(apartmentArrayLocation).getClass().getSimpleName().equals("ApartmentForSell")) {
			ApartmentForSell afs =  (ApartmentForSell) office.arrayAppartment.get(apartmentArrayLocation).clone();
			s.append(afs.toString()+ "\n"+afs.arrayCustomer.toString()+"\n");
			s.append("clone successfully\n");
		}
			}
			catch (CloneNotSupportedException e) {
				s.append("Cannot clone");
			}
		}
		return s;	

	}
	// save the data in binary file
	public void outputFileFromMain ()	{
		try {
			office.outputFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void addData() throws ExceptionRange{
		// adding 4 apartments with 4 customer for each apartments
		ApartmentForSell newApartmentForSell1 = new ApartmentForSell(111, "Arlozorov 50", 40, 2, 2, 1500000);
		ApartmentForSell newApartmentForSell2 = new ApartmentForSell(112, "Arlozorov 51", 41, 3, 3, 1600000);
		ApartmentForSell newApartmentForSell3 = new ApartmentForSell(113, "Arlozorov 52", 42, 4, 4, 1700000);
		ApartmentForSell newApartmentForSell4 = new ApartmentForSell(114, "Arlozorov 53", 43, 5, 5, 1800000);
		
		
		office.addNewApartment(newApartmentForSell1);
		office.addNewApartment(newApartmentForSell2);
		office.addNewApartment(newApartmentForSell3);
		office.addNewApartment(newApartmentForSell4);
		
		Customer customer1 = new Customer("customer 1", "111");
		Customer customer2 = new Customer("customer 2", "222");
		Customer customer3 = new Customer("customer 3", "333");
		Customer customer4 = new Customer("customer 4", "444");
		Customer customer5 = new Customer("customer 5", "555");
		Customer customer6 = new Customer("customer 6", "666");
		Customer customer7 = new Customer("customer 7", "777");
		Customer customer8 = new Customer("customer 8", "888");
		Customer customer9 = new Customer("customer 9", "999");
		Customer customer10 = new Customer("customer 10", "101010");
		Customer customer11 = new Customer("customer 11", "111111");
		Customer customer12 = new Customer("customer 12", "121212");
		Customer customer13 = new Customer("customer 13", "131313");
		Customer customer14 = new Customer("customer 14", "141414");
		Customer customer15 = new Customer("customer 15", "151515");
		Customer customer16 = new Customer("customer 16", "161616");
		
		
		newApartmentForSell1.addNewCustomer(customer1);
		newApartmentForSell1.addNewCustomer(customer2);
		newApartmentForSell1.addNewCustomer(customer3);
		newApartmentForSell1.addNewCustomer(customer4);
		
		newApartmentForSell2.addNewCustomer(customer5);
		newApartmentForSell2.addNewCustomer(customer6);
		newApartmentForSell2.addNewCustomer(customer7);
		newApartmentForSell2.addNewCustomer(customer8);
		
		newApartmentForSell3.addNewCustomer(customer9);
		newApartmentForSell3.addNewCustomer(customer10);
		newApartmentForSell3.addNewCustomer(customer11);
		newApartmentForSell3.addNewCustomer(customer12);
		
		newApartmentForSell4.addNewCustomer(customer13);
		newApartmentForSell4.addNewCustomer(customer14);
		newApartmentForSell4.addNewCustomer(customer15);
		newApartmentForSell4.addNewCustomer(customer16);
		
		
		
		ApartmentForRent newApartmentForRent1 = new ApartmentForRent(985, "Hakishon 75", 54, 3, 4, 4300, 100);
		ApartmentForRent newApartmentForRent2 = new ApartmentForRent(986, "Hakishon 76", 64, 4, 5, 5300, 365);
		ApartmentForRent newApartmentForRent3 = new ApartmentForRent(987, "Hakishon 77", 74, 5, 6, 6300, 730);
		ApartmentForRent newApartmentForRent4 = new ApartmentForRent(988, "Hakishon 78", 84, 6, 7, 7300, 50);

		office.addNewApartment(newApartmentForRent1);
		office.addNewApartment(newApartmentForRent2);
		office.addNewApartment(newApartmentForRent3);
		office.addNewApartment(newApartmentForRent4);

		
		Customer customer17 = new Customer("customer 17", "171717");
		Customer customer18 = new Customer("customer 18", "181818");
		Customer customer19 = new Customer("customer 19", "191919");
		Customer customer20 = new Customer("customer 20", "202020");		
		Customer customer21 = new Customer("customer 21", "212121");
		Customer customer22 = new Customer("customer 22", "222222");
		Customer customer23 = new Customer("customer 23", "232323");
		Customer customer24 = new Customer("customer 24", "242424");		
		Customer customer25 = new Customer("customer 25", "252525");
		Customer customer26 = new Customer("customer 26", "262626");
		Customer customer27 = new Customer("customer 27", "272727");
		Customer customer28 = new Customer("customer 28", "282828");
		Customer customer29 = new Customer("customer 29", "292929");
		Customer customer30 = new Customer("customer 30", "303030");
		Customer customer31 = new Customer("customer 31", "313131");
		Customer customer32 = new Customer("customer 32", "323232");
		
		
		newApartmentForRent1.addNewCustomer(customer17);
		newApartmentForRent1.addNewCustomer(customer18);
		newApartmentForRent1.addNewCustomer(customer19);
		newApartmentForRent1.addNewCustomer(customer20);
		
		newApartmentForRent2.addNewCustomer(customer21);
		newApartmentForRent2.addNewCustomer(customer22);
		newApartmentForRent2.addNewCustomer(customer23);
		newApartmentForRent2.addNewCustomer(customer24);
		
		newApartmentForRent3.addNewCustomer(customer25);
		newApartmentForRent3.addNewCustomer(customer26);
		newApartmentForRent3.addNewCustomer(customer27);
		newApartmentForRent3.addNewCustomer(customer28);
		
		newApartmentForRent4.addNewCustomer(customer29);
		newApartmentForRent4.addNewCustomer(customer30);
		newApartmentForRent4.addNewCustomer(customer31);
		newApartmentForRent4.addNewCustomer(customer32);
		
		
		
		
		ApartmentAirbnb newApartmentairbnb1 = new ApartmentAirbnb(452, "Burla 10", 56, 2, 5, 250, 10);
		ApartmentAirbnb newApartmentairbnb2 = new ApartmentAirbnb(453, "Burla 11", 66, 3, 4, 350, 50);
		ApartmentAirbnb newApartmentairbnb3 = new ApartmentAirbnb(454, "Burla 12", 76, 4, 3, 450, 365);
		ApartmentAirbnb newApartmentairbnb4 = new ApartmentAirbnb(455, "Burla 13", 86, 5, 2, 550, 100);

		office.addNewApartment(newApartmentairbnb1);
		office.addNewApartment(newApartmentairbnb2);
		office.addNewApartment(newApartmentairbnb3);
		office.addNewApartment(newApartmentairbnb4);

		

		Customer customer33 = new Customer("customer 33", "333333");
		Customer customer34 = new Customer("customer 34", "343434");
		Customer customer35 = new Customer("customer 35", "353535");
		Customer customer36 = new Customer("customer 36", "363636");
		Customer customer37 = new Customer("customer 37", "373737");
		Customer customer38 = new Customer("customer 38", "383838");
		Customer customer39 = new Customer("customer 39", "393939");
		Customer customer40 = new Customer("customer 40", "404040");
		Customer customer41 = new Customer("customer 41", "414141");
		Customer customer42 = new Customer("customer 42", "424242");
		Customer customer43 = new Customer("customer 43", "434343");
		Customer customer44 = new Customer("customer 44", "444444");
		Customer customer45 = new Customer("customer 45", "454545");
		Customer customer46 = new Customer("customer 46", "464646");
		Customer customer47 = new Customer("customer 47", "474747");
		Customer customer48 = new Customer("customer 48", "484848");
		
		newApartmentairbnb1.addNewCustomer(customer33);
		newApartmentairbnb1.addNewCustomer(customer34);
		newApartmentairbnb1.addNewCustomer(customer35);
		newApartmentairbnb1.addNewCustomer(customer36);
		
		newApartmentairbnb2.addNewCustomer(customer37);
		newApartmentairbnb2.addNewCustomer(customer38);
		newApartmentairbnb2.addNewCustomer(customer39);
		newApartmentairbnb2.addNewCustomer(customer40);
		
		newApartmentairbnb3.addNewCustomer(customer41);
		newApartmentairbnb3.addNewCustomer(customer42);
		newApartmentairbnb3.addNewCustomer(customer43);
		newApartmentairbnb3.addNewCustomer(customer44);
		
		newApartmentairbnb4.addNewCustomer(customer45);
		newApartmentairbnb4.addNewCustomer(customer46);
		newApartmentairbnb4.addNewCustomer(customer47);
		newApartmentairbnb4.addNewCustomer(customer48);
	

	}
	
	
	



	


}
