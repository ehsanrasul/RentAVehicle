package View;

import java.io.IOException;
import java.util.ArrayList;

import BussinessLogic.*;
import Controller.VMS;
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

public class HireDriverController {

    @FXML
    private TableView<Driver> driverTable;

    @FXML
    private TextField ID;

    @FXML
    private Button hire;

    @FXML
    private Text message;

    @FXML
    private TextField rentID;

    @FXML
    private TextField rentDate;

    @FXML
    private TextField returnDate;

    @FXML
    private TextField duration;

    @FXML
    private Button Back;

	Main main=new Main();

    VMS vms = VMS.getInstance();
    
    
    @FXML 
    public void initilize() {
    	
    	displayAvailableDrivers();
    	
    }
    
    
    
    public void displayAvailableDrivers() {
    	
    	ArrayList <Driver> driver = vms.getDrivers();   
    	final ObservableList<Driver> data= FXCollections.observableArrayList(driver);
    	
    	TableColumn cID = new TableColumn("ID");
		TableColumn cName = new TableColumn("Name");
		TableColumn cEmail = new TableColumn("Email");
		TableColumn cContactNumber = new TableColumn("Contact Number");
		TableColumn cAddress = new TableColumn("Address");
		TableColumn cDOB = new TableColumn("DOB");
		
		driverTable.getColumns().addAll(cID, cName, cEmail, cContactNumber, cAddress, cDOB);
    	
    	cID.setCellValueFactory(new PropertyValueFactory<Driver,String>("driverID"));
		cName.setCellValueFactory(new PropertyValueFactory<Driver,String>("driverName"));
		cEmail.setCellValueFactory(new PropertyValueFactory<Driver,String>("driverEmail"));
		cContactNumber.setCellValueFactory(new PropertyValueFactory<Driver,String>("driverContactNumber"));
		cAddress.setCellValueFactory(new PropertyValueFactory<Driver,String>("driverAddress"));
		cDOB.setCellValueFactory(new PropertyValueFactory<Driver,String>("DOB"));
		
		driverTable.setItems(data);

    	
    }
    
    
    
    @FXML
    void HireDirver(ActionEvent event) {
    	
    vms.hireDriver(ID.getText(), rentID.getText(), rentDate.getText(), returnDate.getText());
		
	message.setText("Hire Request Sent to Driver!!");
	
 }

    
   
        
    @FXML
    void goToCustomerHomeScreen(ActionEvent event) throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);
	}

}
