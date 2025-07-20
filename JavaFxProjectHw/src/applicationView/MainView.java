package applicationView;

import applicationController.MenuController;
import applicationModel.Model;
import applicationModel.Office;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainView extends GridPane{
	// create labels
	private Label menuLabel;
	private Label label1 ;
	
	// create Button
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button10;
	

	private MenuController menucontroller;
	
	
	public MainView(Model model) {
		menucontroller= new MenuController(model);
		setStyle("-fx-background-color: #6495ed;");
		setBackground(getBackground());
		createButton();
		createLabel();
		addComponants();
		setHgap(10);
		setVgap(10);
		crateImage();
		
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void crateImage() {
		Image apartmentPic = new Image("apartment.png");

		ImageView imageview = new ImageView(apartmentPic);
		
		imageview.setFitHeight(100);
		imageview.setFitWidth(100);
		imageview.setPreserveRatio(true);
		add(imageview, 9, 5);
	}
	
	private void createLabel() {
		menuLabel = new Label("Project Menu ");
		label1 = new Label("Pick a choice");
		menuLabel.setFont(Font.font("Arial",24));
		menuLabel.setTextFill(Color.GOLD);
		label1.setFont(Font.font("Arial",24));
		label1.setTextFill(Color.GREEN);
		
	}
	
	// create buttons with lambda expression to move them to the relative scene
	private void createButton() {
		button1 = new Button("Add Apartment ");
		
		this.button1.setOnMouseClicked(e -> menucontroller.moveToApartmentAdd());
		
		
		 button2 = new Button("Add Customer ");
		 
		 this.button2.setOnMouseClicked(e-> menucontroller.moveToAddCustomer());
		
		
		 button3 = new Button("Show Apartment ");
		
		 this.button3.setOnMouseClicked(e-> {
			 menucontroller.movetoApartmentsList();
			 
		 });

		 button4 = new Button("Show Apartment Types ");
		 
		 this.button4.setOnMouseClicked(e-> menucontroller.moveToApartmentType());
		
		 button5 = new Button("Show rent price ");
		 
		 this.button5.setOnMouseClicked(e-> menucontroller.moveToApartmentRentPrice());
		
		 button6 = new Button("Show most expensive rent apartment ");
		 
		 this.button6.setOnMouseClicked(e-> menucontroller.moveToApartmentMostExpensive());
		
		 button7 = new Button("Show customers for an apartment ");
		 
		 this.button7.setOnMouseClicked(e-> menucontroller.moveToCustomerInApartment());
		
		 button8 = new Button("Show sorted customers for an apartment ");
		 
		 this.button8.setOnMouseClicked(e-> menucontroller.moveToCustomerInApartmentSorted());
		
		 button9 = new Button("Show all apartments with Commision ");
		 
		 this.button9.setOnMouseClicked(e-> menucontroller.moveToApartmentWitchCommission());
		
		 button10 = new Button("duplicate an apartment ");
		
		 this.button10.setOnMouseClicked(e-> menucontroller.moveToApartmentDuplicate());
	}
	
	

	private void addComponants() {
		setAlignment(Pos.TOP_CENTER);
		add(menuLabel,1,0);
		add(label1,1,1);
		
		add(button1, 0, 2);
		add(button2, 1, 2);
		add(button3, 2, 2);
		add(button4, 0, 3);
		add(button5, 1, 3);
		add(button6, 2, 3);
		add(button7, 0, 4);
		add(button8, 1, 4);
		add(button9, 2, 4);
		add(button10, 0, 5);

		
		
	}
	
	
	
}
