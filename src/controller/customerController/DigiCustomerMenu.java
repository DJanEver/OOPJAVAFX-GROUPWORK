package controller.customerController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class DigiCustomerMenu {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

     public void customerMenuBackBtn(ActionEvent event)throws IOException {
         controllerUtilities.switchScene("resources/customer/select_ser_provider.fxml", event);
     }

    public void switchToCheckBalance(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/digi_check_balance.fxml", event);
    }



}
