package View;

import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import BussinessLogic.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpdateVehicleController {

	FXMLLoader loader = new FXMLLoader();
	@FXML
	private Button Home;
	@FXML
	private Button RentingRequests  ;
	@FXML
	private Button DriverRequests;
	@FXML
	private Button AddDiscounts;

	@FXML
	private Button logout;

	@FXML
	private Button checkVehicle;

	@FXML
	private Text message;

	@FXML
	private Text message2;

	@FXML
	private Button update;
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
	void initialize() {




	} 


	// @FXML
	/*   void goToManageVehicleScreen(ActionEvent event) throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/ManageVehicle.fxml";
		main.goToNextScreen(s, path);

    }*/
	@FXML
	public void checkVehicle() {

		boolean flag =  vms.checkVehicle(Integer.parseInt(vehicleID.getText())); 	

		if(flag==true) {

			setRecords();	 
		}else {

			message2.setText("No such vehicle!");			
		}
	} 


	void setRecords() {
		
		message2.setText(" ");
		Vehicle vehicle = new Vehicle(); 
		vehicle = vms.getVehicle(Integer.parseInt(vehicleID.getText()));

		vehicleName.setText(vehicle.getVehicleName());
		vehicleType.setText(vehicle.getVehicleType());
		vehicleColor.setText(vehicle.getVd().getVehicleColor());
		vehicleModel.setText(vehicle.getVehicleModel());
		vehicleBody.setText(vehicle.getVd().getVehicleBody());
		vehicleEngine.setText(vehicle.getVd().getVehicleEngine());
		rentAmount.setText(Double.toString(vehicle.getVd().getRentAmount()));

	}



	public void updateVehicle() {


		vms.updateVehicle(vehicleName.getText(), vehicleType.getText(), Integer.parseInt(vehicleID.getText()), vehicleModel.getText(), vehicleColor.getText(), vehicleBody.getText(), vehicleEngine.getText(), Double.parseDouble(rentAmount.getText()) );
		message.setText("Vehicle updated sucessfully!");
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


}
