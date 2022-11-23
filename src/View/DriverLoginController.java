package View;

import java.io.IOException;

import Controller.*;
import BussinessLogic.*;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class DriverLoginController {
	FXMLLoader loader = new FXMLLoader();
	
    VMS vms = VMS.getInstance();
	
	@FXML
 	private TextField ID; 
	@FXML
	private PasswordField password;
    
    Main main = new Main();
    
    @FXML
    void goToDriverMainMenuScreen(ActionEvent event) throws IOException {
  	
    	boolean flag = vms.driverLogin(ID.getText(), password.getText());
    	if(flag == true) {
    		
         	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
    	 	String path = "src/View/DriverHomePage.fxml";
    		main.goToNextScreen(s, path);
    		
    	}
    }

    

}
