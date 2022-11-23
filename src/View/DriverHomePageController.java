package View;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DriverHomePageController {

    @FXML
    private Button RideRequest;

    @FXML
    private Button LuggageRequests;
    Main main=new Main();

    @FXML
    void goToAcceptRidesScreen(ActionEvent event) throws IOException {
        	
        	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
    	 	String path = "src/View/AcceptRide.fxml";
    		main.goToNextScreen(s, path);
    		
        }
    
    @FXML
    void goToAcceptLuggageScreen(ActionEvent event) throws IOException {
        	
        	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
    	 	String path = "src/View/AcceptLuggage.fxml";
    		main.goToNextScreen(s, path);
    		
        }
    
    @FXML
    void goToMenuScreen(ActionEvent event) throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/MENU.fxml";
		main.goToNextScreen(s, path);
    }
   
}
