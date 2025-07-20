package applicationView;

import applicationController.ApartmentController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ApartmentTypeView extends VBox{
	private ApartmentController apartmentAddController;
	private Text text ;
	private Label label1 ;
	private ComboBox<String> comboBox;
	
	private String ApartmentType []= {"ApartmentForSell","ApartmentForRent","ApartmentAirbnb"};
	
			
	public ApartmentTypeView(ApartmentController apartmentAddController) {
		this.apartmentAddController= apartmentAddController;
		setStyle("-fx-background-color: #6495ed;");
		createComboBox();
		createLabel();
		createText();
		addComponants();
		this.setSpacing(10);
		setPadding(new Insets(10, 10, 10, 10));
		
	}
	
	private void createComboBox() {
		comboBox = new ComboBox<String>(FXCollections.observableArrayList(ApartmentType));
	
	}
	
	private void createText()	{
		text = new Text("");
		text.setFont(Font.font("Ariel",FontWeight.BOLD,13));
	}
	
	private void createLabel() {
		label1 = new Label("Choose Type of Apartment");
		label1.setFont(Font.font("Arial",16));
	}
	
	
	private void addComponants() {
		this.getChildren().add(label1);
		this.getChildren().add(comboBox);
		this.getChildren().add(text);

		//create listener when choose from selection
		comboBox.getSelectionModel().selectedItemProperty().addListener( (ApartmentTypes,oldValue, newValue)
				-> text.setText(apartmentAddController.printApartmentsTypes(newValue)));
		

	}
	

	
}



