package applicationView;

import applicationController.ApartmentController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ApartmentAddView extends GridPane{
	
	
	//create labels
	private Label label1 ;
	private Label label2 ;
	private Label label3 ;
	private Label label4 ;
	private Label label5 ;
	private Label label6 ;
	private Label label7 ;
	private Label label8 ;
	private Label label9 ;
	private Label label10 ;
	private Label label11 ;

	//create button
	private Button button1;
	
	//create Radio butoon
	private RadioButton radioButton1 ;
	private RadioButton radioButton2 ;
	private RadioButton radioButton3 ;
	
	//create Textfield
	private TextField textID;
	private TextField textAddress;
	private TextField textSize;
	private TextField textRooms;
	private TextField textApartmentPrice;
	private TextField pricePerMonth;
	private TextField stayDuration;
	private TextField pricePerDay;

	//create apartment controller to work with
	private ApartmentController apartmentaddcontroller ;

	
	//create combobox
	private ComboBox<Integer> combobox;
	
	private Integer rating []= {0,1,2,3,4,5,6,7,8,9,10};
	
	boolean flag;
	

	public ApartmentAddView (ApartmentController apartmentaddcontroller)	{
		this.apartmentaddcontroller= apartmentaddcontroller;
		setStyle("-fx-background-color: #6495ed;");
		createLabel();
		createRadioButton();
		combobox = new ComboBox<Integer>(FXCollections.observableArrayList(rating));
		setToggle();
		createTextField();
		createButton();
		setHgap(10);
		setVgap(10);
		addComponants();
		setPadding(new Insets(10, 10, 10, 10));

	}
	

	
	private void createRadioButton() {
		radioButton1 = new RadioButton("Apartment for sell");
		radioButton2 = new RadioButton("Apartment for rent");
		radioButton3 = new RadioButton("Apartment bnb");
		radioButton1.setFont(Font.font("Arial",16));
		radioButton2.setFont(Font.font("Arial",16));
		radioButton3.setFont(Font.font("Arial",16));
		
	}
	
	private void createLabel() {
		label1 = new Label("Choose what type of apartment");
		label2 = new Label("ID:");
		label3 = new Label("address:");
		label4 = new Label("size:");
		label5 = new Label("rooms:");
		label6 = new Label("apartment rating:");
		
		label10 = new Label("apartment price:");

		label7 = new Label("price per month :");
		label8 = new Label("stay duration in days:");
		
		label9 = new Label("price per day :");
		
		label11 = new Label("");
		label1.setFont(Font.font("Arial",16));
		label2.setFont(Font.font("Arial",16));
		label3.setFont(Font.font("Arial",16));
		label4.setFont(Font.font("Arial",16));
		label5.setFont(Font.font("Arial",16));
		label6.setFont(Font.font("Arial",16));
		label7.setFont(Font.font("Arial",16));
		label8.setFont(Font.font("Arial",16));
		label9.setFont(Font.font("Arial",16));
		label10.setFont(Font.font("Arial",16));
		label11.setFont(Font.font("Arial",12));

	}
	
	private void createTextField() {
		textID = new TextField();
		textAddress = new TextField();
		textSize = new TextField();
		textRooms = new TextField();
		textApartmentPrice = new TextField();
		pricePerMonth = new TextField();
		stayDuration = new TextField();
		pricePerDay = new TextField();
		
	}
	
	
	private void createButton() {
		button1 = new Button("Add");
		
		this.button1.setOnMouseClicked(e->{
			 flag=true;
			 //check if one of the textfield have Char/String (not interger) value
			if(
					!apartmentaddcontroller.validate(textID.getText())||
					!apartmentaddcontroller.validate(textSize.getText())||
					!apartmentaddcontroller.validate(textRooms.getText())||
					!apartmentaddcontroller.validate(textApartmentPrice.getText())||
					!apartmentaddcontroller.validate(pricePerMonth.getText())||
					!apartmentaddcontroller.validate(pricePerDay.getText())||
					!apartmentaddcontroller.validate(stayDuration.getText())
						) 
					{
						label11.setText("One of the parameters Must be Int");
						label11.setTextFill(Color.RED);
						flag=false;
						}
			
			// check if apartment for sell selected
			if(radioButton1.isSelected()&&flag) 
				// check if one of the parameters is empty
				if(textAddress.getText().trim().isEmpty() || textID.getText().trim().isEmpty() || 
						textSize.getText().trim().isEmpty()	|| textRooms.getText().trim().isEmpty() ||
						textApartmentPrice.getText().trim().isEmpty()|| combobox.getValue()==null) {
					label11.setText("One of the parameters is empty");
				label11.setTextFill(Color.RED);
				}
				else {
					// adding the apartment
					String error="";
			 error = apartmentaddcontroller.createApartment(Integer.parseInt(textID.getText()),textAddress.getText(),Double.parseDouble(textSize.getText()),
					Double.parseDouble(textRooms.getText()),(int)combobox.getValue(),Double.parseDouble(textApartmentPrice.getText()));
				label11.setText("Apartment have been added");
				label11.setTextFill(Color.GREEN);
				// if there is negative number in one of the textfield
				if(error.equals("Exception range")) {
					label11.setText("One of the parameters cannot be negative");
					label11.setTextFill(Color.RED);
				}
				// if the "address" is already in the list
				if(error.equals("Already in the list")) {
					label11.setText("The apartment already in the list");
					label11.setTextFill(Color.RED);
				}
				
			}
			// if apartment for rent selected
			if(radioButton2.isSelected()&& flag)
				// check if one of the parameters is empty
				if(textAddress.getText().trim().isEmpty() || textID.getText().trim().isEmpty() || 
						textSize.getText().trim().isEmpty()	|| textRooms.getText().trim().isEmpty() ||stayDuration.getText().trim().isEmpty()|| 
						pricePerMonth.getText().trim().isEmpty() || combobox.getValue()==null) {
				label11.setText("One of the parameters is empty");
				label11.setTextFill(Color.RED);
				}
				else {
					String error="";
					// adding the apartment
					 error = apartmentaddcontroller.createApartment(Integer.parseInt(textID.getText()),textAddress.getText(),Double.parseDouble(textSize.getText()),
						Double.parseDouble(textRooms.getText()),(int)combobox.getValue(),Double.parseDouble(pricePerMonth.getText()),Integer.parseInt(stayDuration.getText()));
				label11.setText("Apartment have been added");
				label11.setTextFill(Color.GREEN);
				// if there is negative number in one of the textfield

				if(error.equals("Exception range")) {
					label11.setText("One of the parameters cannot be negative");
					label11.setTextFill(Color.RED);
				}
				// if the "address" is already in the list

				if(error.equals("Already in the list")) {
					label11.setText("The apartment already in the list");
					label11.setTextFill(Color.RED);
				}
				
				}
			//if apartment airbnb is selected
			if(radioButton3.isSelected()&&flag)
				if(textAddress.getText().trim().isEmpty() || textID.getText().trim().isEmpty() || 
						textSize.getText().trim().isEmpty()	|| textRooms.getText().trim().isEmpty() ||stayDuration.getText().trim().isEmpty()|| 
						pricePerDay.getText().trim().isEmpty()|| combobox.getValue()==null) {
					label11.setText("One of the parameters is empty");
					label11.setTextFill(Color.RED);
				}
				else {
					// adding the apartment
					String error="";
					 error = apartmentaddcontroller.createApartment(Integer.parseInt(textID.getText()),textAddress.getText(),Double.parseDouble(textSize.getText()),
						Double.parseDouble(textRooms.getText()),(int)combobox.getValue(),Integer.parseInt(stayDuration.getText()),Double.parseDouble(pricePerDay.getText()));
				label11.setText("Apartment have been added");
				label11.setTextFill(Color.GREEN);
				// if there is negative number in one of the textfield
				if(error.equals("Exception range")) {
					label11.setText("One of the parameters cannot be negative");
					label11.setTextFill(Color.RED);
				}
				// if the "address" is already in the list
				if(error.equals("Already in the list")) {
					label11.setText("The apartment already in the list");
					label11.setTextFill(Color.RED);
				}
					
				}
			// if no apartment type is selected
			if(!radioButton1.isSelected() && ! radioButton2.isSelected() && !radioButton3.isSelected() && flag) {
				label11.setText("You need to select type of apartment");
				label11.setTextFill(Color.RED);
			}
		});
		add(button1, 10 , 21);
		
	}
	
	
	private void setToggle() {
		ToggleGroup tg = new ToggleGroup();
		radioButton1.setToggleGroup(tg);
		radioButton2.setToggleGroup(tg);
		radioButton3.setToggleGroup(tg);
		
		// setting the visibility of the text field in accordance to the choice
		radioButton1.setOnMouseClicked(e-> {
		label10.setVisible(true);
		textApartmentPrice.setVisible(true);
		pricePerMonth.setVisible(false);
		label7.setVisible(false);
		stayDuration.setVisible(false);
		label8.setVisible(false);
		label9.setVisible(false);
		pricePerDay.setVisible(false);
		});

		radioButton2.setOnMouseClicked(e-> {
			pricePerMonth.setVisible(true);
			label7.setVisible(true);
			stayDuration.setVisible(true);
			label8.setVisible(true);
			label10.setVisible(false);
			textApartmentPrice.setVisible(false);
			label9.setVisible(false);
			pricePerDay.setVisible(false);
			
		});
				
		radioButton3.setOnMouseClicked(e-> {
			label9.setVisible(true);
			pricePerDay.setVisible(true);
			stayDuration.setVisible(true);
			label8.setVisible(true);
			
			
			pricePerMonth.setVisible(false);
			label7.setVisible(false);
			label10.setVisible(false);
			textApartmentPrice.setVisible(false);
		});
		
		
	}
	
	private void addComponants() {
		setAlignment(Pos.TOP_LEFT);
		add(label1, 0, 0);
		add(radioButton1, 0, 1);
		add(radioButton2, 0, 2);
		add(radioButton3, 0, 3);
		
		add(label2, 0 , 4);
		add(label3, 0 , 6);
		add(label4, 0 , 8);
		add(label5, 0 , 10);
		add(label6, 0 , 12);

		add(textID, 0 , 5);
		add(textAddress, 0 , 7);
		add(textSize, 0 , 9);
		add(textRooms, 0 , 11);
		add(combobox, 0, 13);
		
		add(label10, 0, 14);
		add(textApartmentPrice,0,15);
		
		add(label7, 0, 16);
		add(label8, 0, 18);

		add(pricePerMonth,0,17);
		add(stayDuration,0,19);
		
		add(label9,0,20);
		add(pricePerDay,0,21);
		
		add(label11,11, 21);
		
	}
	

	

	
	
}
