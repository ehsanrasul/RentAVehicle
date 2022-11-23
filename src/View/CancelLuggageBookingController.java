package View;
import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelLuggageBookingController {

	@FXML
	private TextField ID;

	@FXML
	private Button cancel;
	
	@FXML
	private Button Back;

	Main main=new Main();

    VMS vms = VMS.getInstance();

	@FXML
	void goToCustomerHomePage(ActionEvent event) throws IOException {
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);
	}

	@FXML
	void cancelLuggageBooking() {
		
		boolean flag = vms.cancelLuggageBooking(ID.getText());
		if(flag = true) {
			 
			
		} else {
			//Message
			// No Such Booking is Found
			
		}
		
	}
	
}
