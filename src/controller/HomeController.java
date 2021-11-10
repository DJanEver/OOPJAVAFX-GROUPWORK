package controller;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class HomeController {
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    public void switchToServiceProvider(ActionEvent event) throws  IOException{
        controllerUtilities.switchScene("resources/service_provider.fxml", event);
    }
    public void switchToCustomer(ActionEvent event)throws IOException{
        controllerUtilities.switchScene("resources/customer/select_ser_provider.fxml", event);
    }
}
