package controller.customerController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

/**
 * class was created bt Hakeem watson 200391
 */
public class DigiCustomerMenu {

    /**
     * Declaration of variables
     */

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    /**
     *Controller methods switching sences
     */
     public void customerMenuBackBtn(ActionEvent event)throws IOException {
         controllerUtilities.switchScene("resources/customer/select_ser_provider.fxml", event);
     }

    public void switchToCheckBalance(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/digi_check_balance.fxml", event);
    }

    public void switchToAddDigiCredit(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/digi_add_credit.fxml", event);
    }


}
