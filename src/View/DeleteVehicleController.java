package View;

import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteVehicleController {

	FXMLLoader loader = new FXMLLoader();
	@FXML
	private Button ManageVehicles;
	@FXML
	private Button RentingRequests  ;
	@FXML
	private Button DriverRequests;
	@FXML
	private Button AddDiscounts;
	@FXML
	private Button delete;
	@FXML
	private TextField vehicleID  ;

    @FXML
    private Text message;
    
	Main main = new Main();
	VMS vms = VMS.getInstance();



	@FXML
	void goToManageVehicleScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/ManageVehicle.fxml";
		main.goToNextScreen(s, path);

	}

	@FXML
	void goToMenuScreen(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/MENU.fxml";
		main.goToNextScreen(s, path);

	}


	@FXML
	void goToDeleteConfirm(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/VehicleDeletionConfirmation.fxml";
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


	@FXML
	void deleteVehicle() {

		boolean flag = vms.deleteVehicle(Integer.parseInt(vehicleID.getText()));
		if(flag == true) {

			message.setText("Vehicle Deleted Successfully");	

		}else {

			message.setText("No Such Vehicle Record Found !");	

		}

	}

}
