package applicationController;


import applicationModel.Model;
import applicationView.ApartmentAddView;
import applicationView.ApartmentDuplicate;
import applicationView.ApartmentMostExpensiveRentView;
import applicationView.ApartmentRentCostView;
import applicationView.ApartmentTypeView;
import applicationView.ApartmentWithCommissionView;
import applicationView.ApartmentsView;
import applicationView.CustomerAddView;
import applicationView.CustomerInApartmentSortedView;
import applicationView.CustomerInApartmentView;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.stage.Stage;
	public class MenuController {
	Model model;
		
	//creates controllers
	private ApartmentController apartmentaddcontroller;
	private CustomerController customerAddController;
	
	//creates Views
	private ApartmentsView apartmentview ;
	
	private ApartmentAddView addView;
	
	private CustomerAddView customerAddView;
	
	private ApartmentTypeView apartmentTypeView;
	
	private ApartmentRentCostView apartmentRentCost;
	
	private ApartmentMostExpensiveRentView apartmentMostExpensiveRentView;
	
	private CustomerInApartmentView CustomerInApartmentView;
	
	private CustomerInApartmentSortedView CustomerInApartmentSortedView;
	
	private ApartmentWithCommissionView apartmentwithCommissionView;
	
	private ApartmentDuplicate apartmentDuplicate;
	
	private Stage stage;
	
	
	// creating controllers
	public MenuController(Model model) {
		this.model= model;
		apartmentaddcontroller = new ApartmentController(model);
		customerAddController = new CustomerController(model);
	}
	
	
	// moving to the relevant scene
	public void moveToApartmentAdd() {
		addView= new ApartmentAddView(apartmentaddcontroller);
		Scene scene = new Scene(addView,650,750);
		
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Apartment Add");
		stage.setAlwaysOnTop(true);
		stage.show();

		
	}
	
	public void movetoApartmentsList() {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setPannable(true);
		
	apartmentview = new ApartmentsView(apartmentaddcontroller);
	
	scrollPane.setContent(apartmentview);
	scrollPane.setFitToHeight(true);
	scrollPane.setFitToWidth(true);
	Scene scene2 = new Scene(scrollPane, 500 ,500 );
	stage = new Stage();
	stage.setScene(scene2);
	stage.setTitle("Apartment List");
	stage.setAlwaysOnTop(true);
	stage.show();
	
	}
	
	
	public void moveToAddCustomer() {
		customerAddView = new CustomerAddView(customerAddController);
		Scene scene3 = new Scene(customerAddView, 650 , 500);
		stage = new Stage();
		stage.setScene(scene3);
		stage.setTitle("Customer Add");
		stage.setAlwaysOnTop(true);

		stage.show();
	}
	
	public void moveToApartmentType() {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setPannable(true);
		
		apartmentTypeView = new ApartmentTypeView(apartmentaddcontroller);
		
		scrollPane.setContent(apartmentTypeView);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		
		Scene scene4 = new Scene(scrollPane,800,500);
		stage = new Stage();
		stage.setScene(scene4);
		stage.setTitle("Apartments Types");
		stage.setAlwaysOnTop(true);
		stage.show();
		
		
	}
	
	public void moveToApartmentRentPrice() {
		apartmentRentCost = new ApartmentRentCostView(apartmentaddcontroller);
		Scene scene5 = new Scene(apartmentRentCost,600,200);
		stage = new Stage();
		stage.setScene(scene5);
		stage.setTitle("Apartments For Rent Total Cost");
		stage.setResizable(false);
		stage.setAlwaysOnTop(true);
		stage.show();

		
	}
	
	public void moveToApartmentMostExpensive() {
		apartmentMostExpensiveRentView= new ApartmentMostExpensiveRentView(apartmentaddcontroller);
		Scene scene6= new Scene(apartmentMostExpensiveRentView, 500 ,500);
		stage = new Stage();
		stage.setScene(scene6);
		stage.setTitle("Most Expensive Rent Apartment");
		stage.setResizable(false);
		stage.setAlwaysOnTop(true);
		stage.show();
	}
	
	public void moveToCustomerInApartment() {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setPannable(true);
		
		
		CustomerInApartmentView = new CustomerInApartmentView(customerAddController);
		
		scrollPane.setContent(CustomerInApartmentView);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		
		Scene scene7 = new Scene(scrollPane, 500, 500);
		stage = new Stage();
		stage.setScene(scene7);
		stage.setTitle("Customers in Apartment");
		stage.setAlwaysOnTop(true);
		stage.show();
		
	}
	
	public void moveToCustomerInApartmentSorted() {
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setPannable(true);
		
		CustomerInApartmentSortedView = new CustomerInApartmentSortedView(customerAddController);
		
		scrollPane.setContent(CustomerInApartmentSortedView);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		
		Scene scene8 = new Scene(scrollPane,500,500);
		stage = new Stage();
		stage.setScene(scene8);
		stage.setTitle("Customers Sorted in Apartment");
		stage.setAlwaysOnTop(true);
		stage.show();
		
	}
	
	public void moveToApartmentWitchCommission() {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setPannable(true);
		
		apartmentwithCommissionView = new ApartmentWithCommissionView(apartmentaddcontroller);
		scrollPane.setContent(apartmentwithCommissionView);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		
		Scene scene9 = new Scene(scrollPane,500,500);
		stage = new Stage();
		stage.setScene(scene9);
		stage.setTitle("Apartments With Commission");
		stage.setAlwaysOnTop(true);
		stage.show();
		
	}
	
	public void moveToApartmentDuplicate() {
		apartmentDuplicate = new ApartmentDuplicate(apartmentaddcontroller);
		Scene scene9 = new Scene(apartmentDuplicate,500,500);
		stage = new Stage();
		stage.setScene(scene9);
		stage.setTitle("Duplicate Apartment");
		stage.setAlwaysOnTop(true);
		stage.show();
		
	}
	
	

	
}




