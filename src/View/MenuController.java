package View;

import java.io.IOException;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {
	
	FXMLLoader loader = new FXMLLoader();
    @FXML
    private Button Admin;
    @FXML
    private Button Driver;
    @FXML
    private Button Customer;
        
    
    Main main = new Main();
    
    @FXML
    void goToAdminLoginScreen(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/AdminLogin .fxml";
		main.goToNextScreen(s, path);
		
    }

    @FXML
    void goToCustomerLoginScreen(ActionEvent event) throws IOException {
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/CustomerLogin.fxml";
		main.goToNextScreen(s, path);
    }
    
    @FXML
    void goToDriverLoginScreen(ActionEvent event) throws IOException {
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/DriverLogin.fxml";
		main.goToNextScreen(s, path);
    }

   

}
