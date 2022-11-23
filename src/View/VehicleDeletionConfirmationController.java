package View;

import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VehicleDeletionConfirmationController {


	Main main = new Main();

    VMS vms = VMS.getInstance();

	@FXML
	private Button NO;
	
    @FXML
    private Button YES;
   
    private int vehicleID ;
    
   // public VehicleDeletionConfirmationController(int vehicleID) {
    	
    //	this.vehicleID = vehicleID; 
    	
   // }
    
   @FXML
    void initialize() {
        

        vms.addVehicle("Ehsan", "Loader", 0, "V8", "Black", "Steel", "800CC", 9000);
        
          
    } 


    @FXML
	void goToDeleteVehicleScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/DeleteVehicle.fxml";
		main.goToNextScreen(s, path);

	}


	@FXML
	void goToManageVehicleScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/ManageVehicle.fxml";
		main.goToNextScreen(s, path);

	}
	
	
	@FXML
	void deleteVehicle() {

			boolean flag = vms.deleteVehicle(vehicleID);
			if(flag == true) {
				
		     		
				
			}else {
				
				
				
			}
			
			

	}

	@FXML
	void goToAdminHomePageScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/AdminHomePage.fxml";
		main.goToNextScreen(s, path);

	}

	
}
