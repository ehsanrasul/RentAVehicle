package View;

import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerHomePageController {

    @FXML
    private Button bookARide;

    @FXML
    private Button CancelBooking;

    @FXML
    private Button HireDriver;

    @FXML
    private Button rentVehicle;

    @FXML
    private Button addVehcileOnRent;

    @FXML
    private Button transferLuggauge;

    @FXML
    private Button cancelLuggaeBooking;

    @FXML
    private Button Logout;
    
    Main main=new Main();


    VMS vms = VMS.getInstance();

    
    @FXML
    void goToBookRideScreen(ActionEvent event) throws IOException {
    	

     	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/BookRide.fxml";
		main.goToNextScreen(s, path);
    }

    @FXML
    void goToCancelLuggageBookingScreen(ActionEvent event)throws IOException {

     	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/CancelLuggageBooking.fxml";
		main.goToNextScreen(s, path);
    }

    @FXML
    void goToLuggageBookingScreen(ActionEvent event) throws IOException{

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/LuggageBooking.fxml";
		main.goToNextScreen(s, path);

    }

    @FXML
    void goToMenuScreen(ActionEvent event)throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/MENU.fxml";
		main.goToNextScreen(s, path);

    }

    @FXML
    void goToRentVehicleDisplayedScreen(ActionEvent event)throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/RentingVehiclesDisplayed.fxml";
		main.goToNextScreen(s, path);
    }

    
    
    @FXML
    void goToRentVehicleScreen(ActionEvent event)throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/RentVehicle.fxml";
		main.goToNextScreen(s, path);
    }
    
    
      @FXML
      void goToCancelRideBookingScreen(ActionEvent event)throws IOException {

      	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
  		String path = "src/View/cancelRideBooking.fxml";
  		main.goToNextScreen(s, path);
      }
      
      @FXML
      void goToSupplyVehicleScreen(ActionEvent event)throws IOException {

      	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
  		String path = "src/View/SupplyVehicle.fxml";
  		main.goToNextScreen(s, path);
      }

      @FXML
      void goToHireDriverScreen(ActionEvent event)throws IOException {

      	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
  		String path = "src/View/HireDriver.fxml";
  		main.goToNextScreen(s, path);
      }
    
}
