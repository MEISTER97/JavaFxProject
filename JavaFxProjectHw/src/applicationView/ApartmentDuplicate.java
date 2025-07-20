package applicationView;

import applicationController.ApartmentController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ApartmentDuplicate extends VBox{
	
	private ApartmentController apartmentController;
	
	private Label label1;
	
	private Text text;
	
	private Button button;
	
	private ComboBox<String> comboBox;

	public ApartmentDuplicate(ApartmentController apartmentController) {
		this.apartmentController = apartmentController;
		setStyle("-fx-background-color: #6495ed;");
		
		createLabel();
		createText();
		createComboBox();
		createButton();
		addComponants();
		this.setSpacing(10);
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void createComboBox() {
		comboBox = new ComboBox<String>(FXCollections.observableArrayList(apartmentController.getApartments()));
		
	}
	
	private void createLabel() {
		label1 = new Label("Choose Address to duplicate: ");
		label1.setFont(Font.font("Ariel",16));
	}
	
	private void createText() {
		text = new Text("");
		text.setFont(Font.font("Ariel",14));
	}
	
	private void createButton() {
		button= new Button("Duplicate");
	}
	
	private void addComponants() {
		this.getChildren().add(label1);
		this.getChildren().add(comboBox);
		this.getChildren().add(button);
		this.getChildren().add(text);

		
		this.button.setOnMouseClicked(e->{
			
				if(comboBox.getValue()== null) {
				text.setText("You need to select address");
				text.setFill(Color.RED);
				}
				
				else {
					text.setText(apartmentController.getDuplicateApartment(comboBox.getValue()));
					text.setFill(Color.BLACK);
				}
				
				
		});
	}
	

}
