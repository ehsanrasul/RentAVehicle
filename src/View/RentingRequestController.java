package View;

import java.io.IOException;
import java.util.ArrayList;

import BussinessLogic.RentDetails;
import BussinessLogic.Vehicle;
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

public class RentingRequestController {
	
	    @FXML
	    private TextField ID;

	    @FXML
	    private Button Accept;

	    @FXML
	    private TableView<Vehicle> vehicleTable;

	    @FXML
	    private Button Reject;

	    @FXML
	    private Text message;

	    @FXML
	    private Button Back;
	    
	    Main main = new Main();

	    VMS vms = VMS.getInstance();
	    

	    
	    @FXML
	    public void initialize() {
	    	
	    	
	     DisplayVehicles();	
	    	
	    	
	    }
	    
	    
	    
	    
	    @FXML
		void DisplayVehicles() {	
			
			ArrayList <RentDetails> RD = vms.getVehicles();   
			
			
			ArrayList <Vehicle> vehicle = new ArrayList <Vehicle>();
			
			
			for(int i = 0; i < RD.size(); i++)
			{
				
				
				vehicle.add(RD.get(i).getVehicle());
				
				
			}
			
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
	    void acceptRentRequest(ActionEvent event) {
	    	
	    	boolean flag = vms.acceptVehicle(Integer.parseInt(ID.getText()));
	    	if(flag == true) {
	    		
	    		message.setText("Accepted Rented Request Successfully");
	    		
	    	}else {
	    		
	    		message.setText("No such Record Found ! Enter ID Again ");
	    		
	    	}
	    	
	    	
	    }

	    @FXML
	    void goToAdminHomePageScreen(ActionEvent event) throws IOException {

	    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 		String path = "src/View/AdminHomePage.fxml";
	 		main.goToNextScreen(s, path);
	    }

	    @FXML
	    void rejectRentRequest(ActionEvent event) {

	      	boolean flag=vms.rejectVehicle(Integer.parseInt(ID.getText()));
	    	if(flag == true) {
	    		
	    		message.setText("Rejected Rented Request");
	    		
	    	}else {
	    		
	    		message.setText("No such Record Found ! Enter ID Again ");
	    		
	    	}
	    }

}

