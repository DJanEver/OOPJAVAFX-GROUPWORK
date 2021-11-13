package controller.customerController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;


/**
 *Class created by Hakeem Watson 2000391
 */
public class FlowCustomerMenu {

    /**
     * Declartion of variables
     */
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    /**
     *Controller method to switch scenes
     */
     public void customerFlowMenuBackBtn(ActionEvent event)throws IOException {
         controllerUtilities.switchScene("resources/customer/select_ser_provider.fxml", event);
     }

    public void switchToCheckFlowBalance(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/flow_check_balance.fxml", event);
    }

    public void switchToAddFlowCredit(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/flow_add_credit.fxml", event);
    }

}
