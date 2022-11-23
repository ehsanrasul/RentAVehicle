package View;

import java.io.IOException;
import Controller.*;
//import BussinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddDiscountController {

    @FXML
    private TextField discountPercentage;

    @FXML
    private Button addDiscount;
    
    @FXML
    private Text message;
    
    
    Main main=new Main();

    VMS vms = VMS.getInstance();

    @FXML
    void goToAdminHomePage(ActionEvent event) throws IOException {

    	Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
	 	String path = "src/View/AdminHomePage.fxml";
		main.goToNextScreen(s, path);
		
    }
    
    
    public void giveDisocunt() {
    	
    	vms.giveDiscount(Double.parseDouble(discountPercentage.getText()));
    	message.setText("Discount Added Successfully");
    	
    } 

}
