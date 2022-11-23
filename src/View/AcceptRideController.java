package View;

import java.io.IOException;
import java.util.ArrayList;
import Controller.*;
import BussinessLogic.*;
import BussinessLogic.Booking;
import BussinessLogic.Driver;
import BussinessLogic.Vehicle;
import Controller.VMS;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AcceptRideController {

    @FXML
    private TextField BookingID;

    @FXML
    private TextField FareAmount;
    
    @FXML
    private Text message;

    @FXML
	private TableView <Booking> requestsTable;

    
    @FXML
    private Button Accept;
    
    @FXML
    private Button Back;
    Main main=new Main();
    VMS vms = VMS.getInstance();

    @FXML
    void goToDriverHomePage(ActionEvent event) throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/DriverHomePage.fxml";
		main.goToNextScreen(s, path);
    }

    
    @FXML
    void initialize(){    
        
        
        getAvailableRides();
        
        
    }
    
    @FXML
    public void getAvailableRides() {
    	
    	ArrayList <Booking> booking = vms.getAvailableBookings();   
    	final ObservableList<Booking> data= FXCollections.observableArrayList(booking);
    	
    	TableColumn <Booking, String> cID = new TableColumn<>("ID");
		TableColumn <Booking, String> cVehicleType = new TableColumn<>("Vehicle Type");
		TableColumn <Booking, String> cPassengerID = new TableColumn<>("Passenger ID");
		TableColumn <Booking, String> cPickupLocation = new TableColumn<>("Pickup Location ");
		TableColumn <Booking, String> cDropoffLocation = new TableColumn<>("Dropoff Location");
		
		requestsTable.getColumns().addAll(cID, cVehicleType, cPassengerID, cPickupLocation, cDropoffLocation);
    	
    	cID.setCellValueFactory(new PropertyValueFactory<Booking,String>("bookingID"));
		cVehicleType.setCellValueFactory(new PropertyValueFactory<Booking,String>("vehicleType"));
		cPassengerID.setCellValueFactory(new PropertyValueFactory<Booking,String>("passengerID"));
		cPickupLocation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRoute().getPickupLocation()));
		cDropoffLocation.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getRoute().getDropoffLocation())));
		
		requestsTable.setItems(data);

	
    }
    
    public void acceptRide() {
    	
    	boolean flag = vms.acceptBooking(BookingID.getText(), Double.parseDouble(FareAmount.getText()));
    	
		if(flag == true) {
    		
    		message.setText("You have accepted ride sucessfully!!");
    		
    	}else {
    		
    		message.setText("No such ID exists.");	
    	}
    		
    }
    }

