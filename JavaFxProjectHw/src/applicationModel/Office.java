package applicationModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Office implements Cloneable , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String saveFile = "FILE_HW.txt";
	Scanner scanner = new Scanner(System.in);
	public ArrayList<Apartment> arrayAppartment = new ArrayList<Apartment>();
	

	public boolean addNewApartment(Apartment apartment) {
		if (this.findAddress(apartment.getAddress())) {
			// using the method findAddress to find if the apartment is in the list already
			// using the address
			return false;
		}

		arrayAppartment.add(apartment);
		// adding the apartment to the array
		return true;
	}

	public boolean findAddress(String address) {
		for (int i = 0; i < this.arrayAppartment.size(); i++) {
			if (this.arrayAppartment.get(i).getAddress().equals(address))
				// using the string to find if the apartment is in the array
				return true;
		}

		return false;
	}

	public StringBuffer printApartments() {
		StringBuffer s = new StringBuffer();
		s.append("Apartments List: \n");
		// method that will print all the apartments
		for (int i = 0; i < this.arrayAppartment.size(); i++) {
			// loop to print the arraylist
			s.append("Type of apartments: [" + arrayAppartment.get(i).getClass().getSimpleName() + "]\n"
					+ arrayAppartment.get(i).toString());
			
			s.append("\n");
			s.append("\n");
		}
		
		return s;
	}

	public int findApartmentgetAddress(String adress) {
		// method to find the apartment location in the array
		for (int i = 0; i < this.arrayAppartment.size(); i++) {
			if (this.arrayAppartment.get(i).getAddress().equalsIgnoreCase(adress))

				return i;
		}

		System.out.println("the apartment adress is not on the list ");
		// if not found will return -1
		return -1;

	}

	public StringBuffer printApartments(String type) {
		StringBuffer s = new StringBuffer();
		// method to print apartment type
		int count = 1;
		s.append("Apartment " + type + " list: \n");
		for (int i = 0; i < this.arrayAppartment.size(); i++) {
			if (arrayAppartment.get(i).getClass().getSimpleName().equalsIgnoreCase(type)) {
				// loop to print the relevent type of apartment from the arraylist
				s.append(count + ". Apartment ID " + this.arrayAppartment.get(i).getapartmentId()
						+ ", Adress : " + this.arrayAppartment.get(i).getAddress() + ", Apartment size : "
						+ +this.arrayAppartment.get(i).getAreaSize() + " Numbers of rooms : "
						+ this.arrayAppartment.get(i).getNumOfRooms() + " Apartment rating : "
						+ arrayAppartment.get(i).getApartmentRating()+"\n");
				count++;
				
			}
		}
		return s;
	}

	public StringBuffer mostExpensiveRent() {
		// method to find the most expensive apartment for rent
		StringBuffer s = new StringBuffer();
		s.append("The most expensive apartment for rent is :\n");
		double mostExpensive = 0;
		int location = 0;		
		
		for (int i = 0; i < this.arrayAppartment.size(); i++) {
			if (this.arrayAppartment.get(i) instanceof ApartmentForRent) {
				// checking within the array only apartments for rent and bnb
				if (this.arrayAppartment.get(i).priceForDuration() > mostExpensive) {
					// if found within the array "priceForDuration" higher than "most expensive",
					// will apply the new value
					mostExpensive = this.arrayAppartment.get(i).priceForDuration();
					location = i;
				}
			}

		}
		s.append("Type : "+ this.arrayAppartment.get(location).getClass().getSimpleName()+"\n"+
				this.arrayAppartment.get(location).toString() + " and the price is " + mostExpensive);
		return s;
	}

	public StringBuffer printApartmentsCommission() {
		StringBuffer s = new StringBuffer();
		// will print all apartments but only for rent and airbnb will show commissions
		for (int i = 0; i < this.arrayAppartment.size(); i++) {
			if (this.arrayAppartment.get(i) instanceof IApartmentCommission && !this.arrayAppartment
					.get(i).getClass().getSimpleName().equals("ApartmentAirbnb")) {

				s.append("["+ this.arrayAppartment.get(i).getClass().getSimpleName()+ "]\n"+
						this.arrayAppartment.get(i).toString() + "\nThe Commission is : "
						+this.arrayAppartment.get(i).getCommission()+"\n");
				
				s.append("\n");
			}
			else {
				s.append("["+ this.arrayAppartment.get(i).getClass().getSimpleName()+ "]\n" +
						this.arrayAppartment.get(i).toString()+"\n");
				s.append("\n");
			}
		}
		return s;
	}

	
	public void outputFile () throws IOException, FileNotFoundException{
		//save file
			ObjectOutputStream objOutput= new ObjectOutputStream(new FileOutputStream(saveFile));
			objOutput.writeInt(this.arrayAppartment.size());

			for(int i=0;i<this.arrayAppartment.size();i++) {
				objOutput.writeObject(this.arrayAppartment.get(i));

	}
			objOutput.close();
	}
	
	public void inputFile () throws IOException,FileNotFoundException, ClassNotFoundException{
		// read file
		ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(saveFile));
		int size = objInput.readInt();
		for(int i=0;i<size;i++) {
			Apartment apartment = (Apartment) objInput.readObject();
			this.addNewApartment(apartment);
		}
		
		
		objInput.close();
	}
	
	


}
