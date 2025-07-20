package applicationView;

import applicationController.CustomerController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CustomerAddView extends GridPane{
	// create controller to work with
	private CustomerController customerController;
	// create label
	private Label label1 ;
	private Label label2 ;
	private Label label3 ;
	private Label label4 ;
	
	// create button
	private Button button1;
	//create text field
	private TextField Name;
	private TextField PhoneNum;

	//create combobox
	private ComboBox <String> comboBox;
	
	public CustomerAddView(CustomerController customerAddView) {
	this.customerController=customerAddView;
	setStyle("-fx-background-color: #6495ed;");
	getAdress();
	createLabelAdress();
	createTextField();
	createButtons();
	addComponants();
	setHgap(10);
	setVgap(10);
	setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void getAdress() {
		setAlignment(Pos.TOP_LEFT);
		// getting address from the controller to the combobox
		comboBox = new ComboBox<String>(FXCollections.observableArrayList(customerController.getApartments()));

	}
	
	private void createLabelAdress() {
		label1 = new Label("Apartments address:");
		label2 = new Label("Name:");
		label3 = new Label("PhoneNumber:");
		label4 = new Label();
		
		label1.setFont(Font.font("Arial",16));
		label2.setFont(Font.font("Arial",16));
		label3.setFont(Font.font("Arial",16));
		label4.setFont(Font.font("Arial",12));

		
	}
	
	private void createTextField() {
		Name = new TextField();
		PhoneNum = new TextField();
	}
	
	private void createButtons() {
		button1 = new Button("Add");
		
		
	}
	
	private void addComponants() {
		add(comboBox,1,0);
		add(label1,0,0);
		
		add(label2,0,1);
		add(Name,1,1);
		
		add(label3,0,3);
		add(PhoneNum,1,3);
		
		add(label4,10,10);
		add(button1,9,10);
		this.button1.setOnMouseClicked(e->{
			//of one of the parameters is empty
			if(Name.getText().trim().isEmpty()|| PhoneNum.getText().trim().isEmpty() || comboBox.getValue()== null) {
				label4.setText("One of the parameters is empty");
				label4.setTextFill(Color.RED);
				
			}
			else {
				//adding the customer to the apartment
				if(customerController.getCustomer(Name.getText(),PhoneNum.getText() , comboBox.getValue())) {
				label4.setText("Customer Added");
				label4.setTextFill(Color.GREEN);
				}
				else {
					//id the customer is already in the apartment
					label4.setText("Customer is already in the apartment");
					label4.setTextFill(Color.RED);
				}
		
			}
			
		});
		
	}
	
	
	
	
	
}



