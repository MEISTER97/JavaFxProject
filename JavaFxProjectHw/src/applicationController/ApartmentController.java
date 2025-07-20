package applicationController;

import java.util.ArrayList;

import applicationModel.Apartment;
import applicationModel.ApartmentAirbnb;
import applicationModel.ApartmentForRent;
import applicationModel.ApartmentForSell;
import applicationModel.ExceptionRange;
import applicationModel.Model;

public class ApartmentController {
	
	private Model model;
		
	
	public ApartmentController(Model model) {
		this.model = model;
	}
	//create apartment for sell
	public String createApartment(int ID, String address, double size, double rooms, int rating, double price)  {
		
		return model.createApartment(ID, address, size, rooms, rating, price);
		
	}
	

	//create apartment for rent
	public String createApartment(int ID, String address, double size, double rooms, int rating, double pricePerMonth,int duration) {
		return model.createApartment(ID, address, size, rooms, rating, pricePerMonth, duration);

		}
	//create apartment airbnb
	public String createApartment(int ID, String address, double size, double rooms, int rating,int duration , double pricePerDay) {
		
		return model.createApartment(ID, address, size, rooms, rating, duration, pricePerDay);
		
		}
	//print apartments
	public String printApartments() {
		return model.printApartments().toString();
		 
	}
	
	//check if the entered value is number
	public boolean validate(String text) {
		return text.matches("-?[0-9]*");
		
	}
	// check if the apartment is exist(duplciate)
	public boolean checkDuplicate(Apartment apartment) {
		
		
		return model.checkDuplicateApartment(apartment);
	}
	
	//print apartment types
	public String printApartmentsTypes(String apartment) {
		return model.printApartmentsType(apartment).toString();
		
	}
	
	// return array list apartments for rent(rent + airbnb)
	public ArrayList<String> getApartmentForRent() {
		
		ArrayList<String> arrayApartmentForRent = new ArrayList<>(model.getArrayListApartmentsRent());
		
		
		return arrayApartmentForRent;
		
	}
	// return total cost rent
	public String getApartmentRentText(String address) {
		
		return model.getApartmentRentTotalCost(address).toString();
	}
	//return most expensive rent
	public String getMostExpensiveRent() {
		
		return model.getMostExpensiveApartment().toString();
	}
	// check if most apartment is exist(array list of apartment from types rent are not empty)
	public boolean ifExpensiveApartmentNotExist() {
		
		return model.ifExpensiveApartmentNotExist();
	}
	//return commission of all apartment except apartment for sell
	public String getApartmentCommission() {
		
		return model.getApartmentCommission().toString();	
	}
	//return arraylist of apartment
	public ArrayList <String> getApartments() {

		return model.getArrayListApartments();
	}
	//return the duplicate apartment info
	public String getDuplicateApartment(String address) {
		
		return model.ApartmentDuplication(address).toString();
		
	}
	
	
	
}






