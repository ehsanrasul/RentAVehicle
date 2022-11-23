package View;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Controller.*;
import BussinessLogic.*;

public class Main extends Application {

	FXMLLoader loader= new FXMLLoader();
	@Override
	public void start(Stage primaryStage) {
		try {

			String fxmlDocPath= "src/View/MENU.fxml";
			FileInputStream fxmlStream= new FileInputStream(fxmlDocPath);
			AnchorPane root=  (AnchorPane) loader.load(fxmlStream);

			Scene scene = new Scene(root,800,600);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		
	}


	public void goToNextScreen(Stage currentStage, String path)  throws IOException  {
	    
		VMS vms = VMS.getInstance();
	    vms.writeData(); //Writting Data While Before Switching Screen

	    String fxmlDocPath = path;
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);

		Scene scene = new Scene(pane,944,698);
		currentStage.setScene(scene);
		currentStage.show();

	}



}