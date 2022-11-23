package View;

import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookARideController {

    @FXML
    private TextField ID;

    @FXML
    private TextField vehicleType;

    @FXML
    private TextField pickupLocation;

    @FXML
    private TextField dropoffLocation;
    
    @FXML
    private Button Book;

    @FXML
    private Button Back;
    
    
    @FXML
    private Text message;
    
    
    Main main=new Main();
    
    VMS vms = VMS.getInstance();

    @FXML
    void goToCustomerHomePage(ActionEvent event) throws IOException {
    	
    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);

    }
    
    
    @FXML
    void bookRide() {
    	
          vms.bookRide(ID.getText(), vehicleType.getText(), pickupLocation.getText(), dropoffLocation.getText());    	
          message.setText("Ride Booked ! Waiting for the Driver");
    }
    
    
    

}
