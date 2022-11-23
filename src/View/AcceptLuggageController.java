package View;
import Controller.*;
import BussinessLogic.*;
import java.io.IOException;
import java.util.ArrayList;
import BussinessLogic.Booking;
import BussinessLogic.LuggageBooking;
import Controller.VMS;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AcceptLuggageController {

	@FXML
	private TextField bookingID;

	@FXML
	private TextField FareAmount;
	
	@FXML
	private Text message;

	@FXML
	private Button Accept;

	@FXML
	private Button Back;

	@FXML
	private TableView <LuggageBooking> luggageTable;


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

		getAvailableLuggageBookings();

	}

	@FXML
	public void getAvailableLuggageBookings() {

		ArrayList <LuggageBooking> LBooking = vms.getAvailableLuggageBookings();  
		final ObservableList<LuggageBooking> data= FXCollections.observableArrayList(LBooking);

		TableColumn <LuggageBooking, String> cID = new TableColumn<>("ID");
		TableColumn <LuggageBooking, String> cVehicleType = new TableColumn<>("Vehicle Type");
		TableColumn <LuggageBooking, String> cPassengerID = new TableColumn<>("Passenger ID");
		TableColumn <LuggageBooking, String> cPickupLocation = new TableColumn<>("Pickup Location ");
		TableColumn <LuggageBooking, String> cDropoffLocation = new TableColumn<>("Dropoff Location");
		TableColumn <LuggageBooking, String> cLuggageWeight = new TableColumn<>("Luggage Weight");
		TableColumn <LuggageBooking, String> cLuggageType = new TableColumn<>("Luggage Type");



		luggageTable.getColumns().addAll(cID, cVehicleType, cPassengerID, cPickupLocation, cDropoffLocation, cLuggageWeight, cLuggageType);

		cID.setCellValueFactory(new PropertyValueFactory<LuggageBooking,String>("bookingID"));
		cVehicleType.setCellValueFactory(new PropertyValueFactory<LuggageBooking,String>("vehicleType"));
		cPassengerID.setCellValueFactory(new PropertyValueFactory<LuggageBooking,String>("passengerID"));
		cPickupLocation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRoute().getPickupLocation()));
		cDropoffLocation.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getRoute().getDropoffLocation())));
		cLuggageWeight.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLuggageWeight()));
		cLuggageType.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLuggageType())));

		luggageTable.setItems(data);

	}

	@FXML
	public void acceptLuggageRequest() {

		boolean flag = vms.acceptLuggageBooking(bookingID.getText(), Double.parseDouble(FareAmount.getText()));
		if(flag == true) {

			message.setText("You have accepted luggage sucessfully!!");

		}else {

			message.setText("No such ID exists.");	
		}
	}

}
