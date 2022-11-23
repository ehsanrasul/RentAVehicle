package View;
import java.io.IOException;
import Controller.*;
import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CancelRideBookingController {

	@FXML
	private TextField ID;

	@FXML
	private Button cancel;
	
    @FXML
    private Text message;

	Main main=new Main();

    VMS vms = VMS.getInstance();

	@FXML
	void goToCustomerHomePage(ActionEvent event) throws IOException {
		Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
		String path = "src/View/CustomerHomePage.fxml";
		main.goToNextScreen(s, path);
	}
	
	@FXML
	void cancelRide() {
		
		boolean flag = vms.cancelBooking(ID.getText());
		if(flag = true) {
			
			message.setText("Deleted sucessfully");
		} else {
			
			message.setText("No id found");
		}
		
	}
	
}
