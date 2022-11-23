package View;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminHomePageController {

	
	FXMLLoader loader = new FXMLLoader();
    @FXML
    private Button ManageVehicles;
    @FXML
    private Button RentingRequests  ;
    @FXML
    private Button DriverRequests;
    @FXML
    private Button AddDiscounts;
    
    @FXML
    private Button logout;
    
    Main main = new Main();
    
    @FXML
    void goToManageVehicleScreen(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/ManageVehicle.fxml";
		main.goToNextScreen(s, path);	
    }
    
    @FXML
    void goToAddDiscountScreen(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/AddDiscount.fxml";
		main.goToNextScreen(s, path);	
    }
    
    @FXML
    void goToRentngRequestScreen(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/RentingRequest.fxml";
		main.goToNextScreen(s, path);		
    }
    
    @FXML
    void goToDriverRecruitmentScreen(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/DriverRecruitment.fxml";
		main.goToNextScreen(s, path);
		
    }
    @FXML
   	void goToMenuScreen(ActionEvent event) throws IOException {
   		
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/MENU.fxml";
		main.goToNextScreen(s, path);

}
    
   

}
