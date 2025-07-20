package applicationView;


import applicationController.ApartmentController;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ApartmentsView extends TextFlow{
	
	private Text text ;
			
	private ApartmentController apartmentcontroller;
	
	public ApartmentsView(ApartmentController apartmentcontroller) {
		this.apartmentcontroller = apartmentcontroller;
		text = new Text();
		setStyle("-fx-background-color: #6495ed;");
		printApartment();
		addComponants();

		setPadding(new Insets(10, 10, 10, 10));
	}
	
	

	
	
	private void printApartment() {
		text.setText(apartmentcontroller.printApartments());
		text.setFont(Font.font("Ariel",14));
	}
	
	private void addComponants() {
		this.getChildren().add(text);

	}
	
}
