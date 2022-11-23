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
import javafx.stage.Stage;

public class LuggageBookingController {

    @FXML
    private TextField ID;

    @FXML
    private TextField LType;

    @FXML
    private TextField LWeight;

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
    private TextField weight;
    
    Main main=new Main();
    
    VMS vms = VMS.getInstance();


    @FXML
    void goToCustomerHomePage(ActionEvent event) throws IOException {
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);

    }
    
    
    @FXML
    void LuggageBooking() {
    	
          vms.LuggageTrasport(ID.getText(), vehicleType.getText(), pickupLocation.getText(), dropoffLocation.getText(), LType.getText(),LWeight.getText());      	
         // message.setText("Ride Booked ! Waiting for the Rider");
    }

}
