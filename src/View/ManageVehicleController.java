package View;

import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManageVehicleController {
	
	
	FXMLLoader loader = new FXMLLoader();
    
    
    @FXML
    private Button add  ;
    @FXML
    private Button update  ;
    @FXML
    private Button delete  ;
    @FXML
    private Button logout;
    
    Main main = new Main();
    
    VMS vms = VMS.getInstance();

    
    @FXML
    void goToAddVehicleScreen(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/addVehicle.fxml";
		main.goToNextScreen(s, path);
		
    }
    
    
    @FXML
    	void goToUpdateVehicleScreen(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/updateVehicle.fxml";
		main.goToNextScreen(s, path);
		
    }
    
    
    
    @FXML
    	void goToDeleteVehicleScreen(ActionEvent event) throws IOException {
	
    		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
    		String path = "src/View/DeleteVehicle.fxml";
    		main.goToNextScreen(s, path);
 }
    @FXML
   	void goToMenuScreen(ActionEvent event) throws IOException {
   		
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/MENU.fxml";
		main.goToNextScreen(s, path);

}
    
    @FXML
   	void goToAdminHomePage(ActionEvent event) throws IOException {
   		
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/AdminHomePage.fxml";
		main.goToNextScreen(s, path);

}
    
    

}
