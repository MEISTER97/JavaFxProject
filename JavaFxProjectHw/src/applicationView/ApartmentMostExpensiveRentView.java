package applicationView;

import applicationController.ApartmentController;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ApartmentMostExpensiveRentView extends TextField{
	
	private Text text;
	
	private ApartmentController apartmentController;

	public ApartmentMostExpensiveRentView(ApartmentController apartmentController) {
		setStyle("-fx-background-color: #6495ed;");
		this.apartmentController = apartmentController;
		createText();
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	public void createText() {
		text= new Text();
		text.setFont(Font.font("Ariel",16));
		text.setFill(Color.BLACK);
		if(apartmentController.ifExpensiveApartmentNotExist()) {
			text.setText("You do not have any Apartments from type rent/airbnb");
		}
		else
		text.setText(apartmentController.getMostExpensiveRent());
		
		this.getChildren().add(text);
	}
	
	

}
