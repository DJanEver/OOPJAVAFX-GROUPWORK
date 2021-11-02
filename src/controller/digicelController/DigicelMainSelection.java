package controller.digicelController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class DigicelMainSelection {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    public void digicelMBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/service_provider.fxml",event);
    }
    public void callAddCus(ActionEvent event ) throws IOException{
        controllerUtilities.switchScene("resources/digicel/add_digi_customer.fxml", event);
    }
}