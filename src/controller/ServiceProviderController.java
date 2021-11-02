package controller;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class ServiceProviderController {
    private final ControllerUtilities controllerUtilities = new ControllerUtilities();

    public void switchToHome(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/home.fxml",event);
    }

    public void digicelLoginForm(ActionEvent event) throws IOException{
        controllerUtilities.switchScene("resources/digicel/digicel_login_form.fxml",event);
    }

    public void flowLoginForm(ActionEvent event) throws IOException{
        controllerUtilities.switchScene("resources/flow/flow_login_form.fxml",event);
    }
}
