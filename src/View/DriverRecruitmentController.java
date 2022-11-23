package View;



import java.io.IOException;
import java.util.ArrayList;
import Controller.*;
import BussinessLogic.*;
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

public class DriverRecruitmentController  {

    @FXML
	private TableView<Driver> driverTable;

    @FXML
    private TextField ID;

    @FXML
    private Button Accept;
    
    @FXML
    private Button Reject;
    

    @FXML
    private Button Back;

    @FXML
    private Text message;

    
    Main main = new Main();

    VMS vms = VMS.getInstance();
   
    @FXML
    void goToAdminHomePageScreen(ActionEvent event) throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
 		String path = "src/View/AdminHomePage.fxml";
 		main.goToNextScreen(s, path);

    }
    
    @FXML
    public void getDriverRequests() {
    	
    	ArrayList <Driver> driver = vms.recruitDriver();   
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
    
    
    public void acceptDriver() {
    	
    	boolean flag = vms.acceptDriver(ID.getText());
    	if(flag == true) {
    		
    		message.setText("Record Recruited Successfully");
    		getDriverRequests();
    		
    	}else {
    		
    		message.setText("No such Record Found ! Enter ID Again ");
    		
    	}
    	
    } 
    
    
    public void rejectDriver() {
    	
      	boolean flag = vms.rejectDriver(ID.getText());
    	if(flag == true) {
    		
    		message.setText("Recruitment Request Rejected Successfully ");
    		
    	}else {
    		
    		message.setText("No such Record Found ! Enter ID Again ");
    		
    	}
    	
    }
    
    
       @FXML
    private void initialize() {

    	   getDriverRequests();
    
    }

}
