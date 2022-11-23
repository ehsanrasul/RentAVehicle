package View;

import java.io.IOException;
import Controller.*;
//import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddVehicleController {
	FXMLLoader loader = new FXMLLoader();


	@FXML
	private Button RentingRequests;

	@FXML
	private Button DriverRequest;

	@FXML
	private Button discounts;
	@FXML
	private Text message;

	@FXML
	private Button addVehicle;
	@FXML
	private TextField vehicleName  ;
	@FXML
	private TextField vehicleID  ;
	@FXML
	private TextField vehicleType  ;
	@FXML
	private TextField vehicleModel  ;
	@FXML
	private TextField vehicleColor  ;
	@FXML
	private TextField vehicleBody  ;
	@FXML
	private TextField vehicleEngine  ;
	@FXML
	private TextField rentAmount  ;

	Main main = new Main();

	VMS vms = VMS.getInstance();
	@FXML
	private Button logout;            
	@FXML
	private Button Home;

	@FXML
	void goToAddDiscountScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/AddDiscount.fxml";
		main.goToNextScreen(s, path);

	}


	@FXML
	void goToDriverRecruitmentScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/DriverRecruitment.fxml";
		main.goToNextScreen(s, path);

	}

	@FXML
	public void addVehicle(ActionEvent event) throws IOException {

		vms.addVehicle(vehicleName.getText(), vehicleType.getText(), Integer.parseInt(vehicleID.getText()), vehicleModel.getText(), vehicleColor.getText(), vehicleBody.getText(), vehicleEngine.getText(), Double.parseDouble(rentAmount.getText()));
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/ManageVehicle.fxml";
		main.goToNextScreen(s, path);

	}
	@FXML
	void goToHomePage(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/AdminHomePage.fxml";
		main.goToNextScreen(s, path);

	}

	@FXML
	void goToMenuScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/MENU.fxml";
		main.goToNextScreen(s, path);

	} 	

	//@FXML
	void addVehicle() {

		vms.addVehicle(vehicleName.getText(), vehicleType.getText(), Integer.parseInt(vehicleID.getText()), vehicleModel.getText(), vehicleColor.getText(), vehicleBody.getText(),vehicleEngine.getText(), Double.parseDouble(rentAmount.getText()));
		message.setText("Vehicle added sucessfully!");

	}

}
