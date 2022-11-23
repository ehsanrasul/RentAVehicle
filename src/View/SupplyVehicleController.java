package View;

import java.io.IOException;

import Controller.VMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SupplyVehicleController {

    @FXML
    private TextField startDate;

    @FXML
    private TextField vehicleName;

    @FXML
    private TextField vehicleID;

    @FXML
    private TextField endDate;

    @FXML
    private TextField duration;

    @FXML
    private Button add;

    @FXML
    private TextField vehicleType;

    @FXML
    private TextField rentID;

    @FXML
    private TextField vehicleColor;

    @FXML
    private TextField vehicleModel;

    @FXML
    private TextField rentAmount;

    @FXML
    private TextField vehicleBody;

    @FXML
    private TextField vehicleEngine;
    
    @FXML
    private Button back;
    
    @FXML
    private Text message;


	Main main=new Main();

    VMS vms = VMS.getInstance();
    
    
    @FXML
    public void add() {
    	
    	
    	vms.rentOutVehicle(vehicleName.getText(), vehicleType.getText(), Integer.parseInt(vehicleID.getText()), vehicleModel.getText(), vehicleColor.getText(), vehicleBody.getText(), vehicleEngine.getText(), rentID.getText(), Double.parseDouble(rentAmount.getText()), startDate.getText(),duration.getText() ,endDate.getText());
        	
    	
    }    
    
    
    
    
    @FXML
    void addVehicle(ActionEvent event) throws IOException {

  
    	
    	vms.rentOutVehicle(vehicleName.getText(), vehicleType.getText(), Integer.parseInt(vehicleID.getText()), vehicleModel.getText(), vehicleColor.getText(), vehicleBody.getText(), vehicleEngine.getText(), rentID.getText(), Double.parseDouble(rentAmount.getText()), startDate.getText(),duration.getText() ,endDate.getText());
    	message.setText("Request Sent to admin!!");
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);	
		

    }
    

      
    
    
    
    
    @FXML
    void goToCustomerHomeScreen(ActionEvent event)  throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);
	}
    
    
	
}