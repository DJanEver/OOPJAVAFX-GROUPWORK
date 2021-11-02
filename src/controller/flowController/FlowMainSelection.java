package controller.flowController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class FlowMainSelection {
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    public void flowMBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/service_provider.fxml",event);
    }

    public void addFlowCus(ActionEvent event) throws IOException{
        controllerUtilities.switchScene("resources/flow/add_flow_customer.fxml", event);
    }

}