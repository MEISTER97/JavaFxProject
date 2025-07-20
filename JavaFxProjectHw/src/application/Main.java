package application;
	
import java.util.Optional;

import applicationModel.Model;
import applicationView.MainView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;


public class Main extends Application {
	public Stage MainStage;
	// model create in main to able save data after exit
	 Model model= new Model();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			MainStage=primaryStage;
			MainView mainview = new MainView(model);
			Scene scene = new Scene(mainview,900,300);
			
			MainStage.setResizable(false);
			Image icon = new Image("iconapartment.png");
			MainStage.getIcons().add(icon);
			MainStage.setTitle("Apartment menu");
			MainStage.setScene(scene);
			MainStage.show();
			MainStage.setOnCloseRequest(e -> {
				e.consume();
				logout(MainStage);
				
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void logout(Stage stage) {
		Alert alert = new Alert(AlertType.WARNING, "Are you sure you want to exit?"
				,ButtonType.YES,ButtonType.NO);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout");
		alert.setContentText("Are you sure you want to exit?");
		Optional<ButtonType>result = alert.showAndWait();
		
		if(result.get().equals(ButtonType.YES)) {
			model.outputFileFromMain();
			System.out.println("You logout");
			
			
			stage.close();
			
		}			
		
			}
	
	public static void main(String[] args) {
		launch(args);
	}
}

