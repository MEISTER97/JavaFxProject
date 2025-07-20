package applicationView;

import applicationController.ApartmentController;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ApartmentWithCommissionView extends TextFlow{
	
	private ApartmentController apartmentAddController;
	
	private Text text;
	

	public ApartmentWithCommissionView(ApartmentController apartmentAddController) {
		this.apartmentAddController = apartmentAddController;
		text= new Text();
		setStyle("-fx-background-color: #6495ed;");
		printApartment();
		addComponants();
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void printApartment() {
		
		text.setText(apartmentAddController.getApartmentCommission());
		text.setFont(Font.font("Ariel",14));
	}
	
	
	private void addComponants() {
		this.getChildren().add(text);
		
	}

}
