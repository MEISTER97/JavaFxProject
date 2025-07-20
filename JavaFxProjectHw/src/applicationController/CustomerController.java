package applicationController;

import java.util.ArrayList;

import applicationModel.Customer;
import applicationModel.Model;
import applicationModel.Office;

public class CustomerController {
	private Model model;

	public CustomerController(Model model) {
		this.model = model;
	}
	// return apartment arraylist
	public ArrayList <String> getApartments() {

		return model.getArrayListApartments();
	}
	//create customer
	public boolean getCustomer(String name,String PhoneNum,String address) {
		
		return model.getCustomer(name, PhoneNum, address);
	}
	
	// return customers for apartment
	public String getCustomersForApartmnet(String address) {
		
		
		return model.getCustomerForApartment(address).toString();
	}
	// return sorted customer for apartment
	public String getCustomerSortedForApartment(String address) {
		
		
		
		return model.getSortedCustomerForApartment(address).toString();
	}
	

	
	
}
