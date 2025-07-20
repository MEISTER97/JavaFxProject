package applicationView;

import applicationController.ApartmentController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ApartmentRentCostView extends VBox{
	
	private ApartmentController apartmentcontroller;
	
	private Text text;
	
	private Label label;
	
	private Button button;
	
	private ComboBox<String> comboBox;
	
	
	

	public ApartmentRentCostView(ApartmentController apartmentcontroller) {
		this.apartmentcontroller = apartmentcontroller;
		setStyle("-fx-background-color: #6495ed;");
		createComboBox();
		createLabel();
		createText();
		createButton();
		addComponants();
		this.setSpacing(10);
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void createText() {
		text= new Text();
		text.setFont(Font.font("Ariel",16));
	}
	
	
	private void createComboBox() {
		comboBox = new ComboBox<String>(FXCollections.observableArrayList(apartmentcontroller.getApartmentForRent()));
	}
	
	private void createLabel(){
		label = new Label("Choose address: ");
		label.setFont(Font.font("Ariel",16));
	}
	
	private void createButton() {
		button= new Button("Show");
	}
	
	private void addComponants() {
		this.getChildren().add(label);
		this.getChildren().add(comboBox);
		this.getChildren().add(button);
		this.getChildren().add(text);



	this.button.setOnMouseClicked(e->{
		if(comboBox.getValue()==null) {
		text.setText("You need to select an apartment or you do not have Rents Apartments");
		text.setFill(Color.RED);
	}
		else {
		text.setText(apartmentcontroller.getApartmentRentText(comboBox.getValue()));
		text.setFill(Color.BLACK);
		}
	});
		
	}

}
