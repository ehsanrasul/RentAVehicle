package View;
import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RideCancelConfirmationController {



	Main main = new Main();

    VMS vms = VMS.getInstance();

	@FXML
	private Button NO;
	
    @FXML
    private Button YES;
	@FXML
	void goToCancelRideBook(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "D:\\eclipse\\workplace\\VMS_Project\\src\\View\\cancelRideBooking.fxml";
		main.goToNextScreen(s, path);

	}

	@FXML
	void goToCustomerHomePage(ActionEvent event) throws IOException {

		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "D:\\eclipse\\workplace\\VMS_Project\\src\\View\\CustomerHomePage.fxml";
		main.goToNextScreen(s, path);

	}
}
