package applicationView;

import applicationController.CustomerController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CustomerInApartmentView extends VBox{
	
	private CustomerController customerController;
	
	private Label label1;
	
	private ComboBox<String> comboBox;
	
	private Button button;
	
	private Text text;

	public CustomerInApartmentView(CustomerController customerController) {
		this.customerController = customerController;
		setStyle("-fx-background-color: #6495ed;");
		createComboBos();
		createLabel();
		createButton() ;
		createText();
		addComponants();
		this.setSpacing(10);
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void createComboBos() {
		comboBox = new ComboBox<String>(FXCollections.observableArrayList(customerController.getApartments()));
		
	}
	
	private void createLabel() {
		label1= new Label("Choose Address");
	}
	
	private void createButton() {
		button = new Button("Show");
	}
	
	private void createText() {
		text = new Text("");
		text.setFont(Font.font("Ariel",14));
	}
	
	private void addComponants() {
		this.getChildren().add(label1);
		this.getChildren().add(comboBox);
		this.getChildren().add(button);
		this.getChildren().add(text);
		
		this.button.setOnMouseClicked(e-> text.setText(customerController.getCustomersForApartmnet(comboBox.getValue())));
	}
	

}


