package View;


import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerLoginController {

	FXMLLoader loader = new FXMLLoader();
	
    VMS vms = VMS.getInstance();
	@FXML
 	private TextField ID; 
	@FXML
	private PasswordField password;
    
    Main main = new Main();
    
    @FXML
    void goToCustomerMainMenuScreen(ActionEvent event) throws IOException {
  	
    	boolean flag = vms.passengerLogin(ID.getText(), password.getText());
    	if(flag == true) {
    		
         	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
    	 	String path = "src/View/CustomerHomePage.fxml";
    		main.goToNextScreen(s, path);
    		
    	}
		
    }

   
}
