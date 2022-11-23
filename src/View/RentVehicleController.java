package View;

import java.io.IOException;
import java.util.ArrayList;
import BussinessLogic.Vehicle;
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
import javafx.util.Callback;
import Controller.*;
import BussinessLogic.*;

public class RentVehicleController {

	@FXML
	private TableView <Vehicle> vehicleTable;

	@FXML
	private Text message;

	@FXML
	private TextField ID;

	@FXML
	private TextField rentID;


	@FXML
	private TextField rentDate;


	@FXML
	private TextField returnDate;


	@FXML
	private TextField duration;


	@FXML
	private Button rent;

	Main main=new Main();

    VMS vms = VMS.getInstance();

	
	@FXML
	void initialize() {
		
		DisplayVehicles();
	
	}
	
	@FXML
	void DisplayVehicles() {	
		
		ArrayList <Vehicle> vehicle = vms.rentVehicle();   
		
		final ObservableList <Vehicle> data = FXCollections.observableArrayList(vehicle);
    	
    	
    	TableColumn <Vehicle, String> cName = new TableColumn<>("Vehicle Name");
		TableColumn <Vehicle, String> cType = new TableColumn<>("Vehicle Type");
		TableColumn <Vehicle, Integer> cID = new TableColumn<>("ID");
		TableColumn <Vehicle, String> cModel = new TableColumn<>("Model");
		TableColumn <Vehicle, String> cColor = new TableColumn<>("Color");
		TableColumn <Vehicle, String> cBody = new TableColumn<>("Body");
		TableColumn <Vehicle, String> cEngine = new TableColumn<>("Engine");
		TableColumn <Vehicle, String> cRentAmount = new TableColumn<>("Rent Amount");
		
		vehicleTable.getColumns().addAll(cName, cType, cID, cModel, cColor, cBody, cEngine, cRentAmount);
    	
    	cName.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("vehicleName"));
		cType.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("vehicleType"));
		cID.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("vehicleID"));
		cModel.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("vehicleModel"));
		cColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVd().getVehicleColor()));
		cBody.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVd().getVehicleBody()));
		cEngine.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVd().getVehicleEngine()));
		cRentAmount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getVd().getRentAmount())));
			
		vehicleTable.setItems(data);
		
	}
	
	
	@FXML
	void goToCustomerHomePage(ActionEvent event) throws IOException {
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);
	}
	
	
	@FXML
	void rentVehicle() {
		
		boolean flag = vms.checkVehicle(Integer.parseInt(ID.getText()));
		
		if(flag == true)		
		{
			vms.enterRentingDetails(Integer.parseInt(ID.getText()), rentID.getText(), rentDate.getText(), duration.getText(), returnDate.getText());
			message.setText("Vehicle Rented Successfully ");
			
		}else {
			
			message.setText("No Such Vehicle Record Exist");
					
		}
	}
	

}
