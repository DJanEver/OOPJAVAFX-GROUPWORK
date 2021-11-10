package controller.customerController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class SelectSerProvider {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    public void selectServicePBackBtn(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/home.fxml", event);

    }

    public void switchDigiCusMenu(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/digi_customer_menu.fxml", event);

    }

    public void switchFlowCusMenu(ActionEvent event)throws IOException{
        controllerUtilities.switchScene("resources/customer/flow_customer_menu.fxml", event);
    }

}
