package controller.flowController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class FlowMainSelection {
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    public void flowMBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/service_provider.fxml", event);
    }

    public void addFlowCus(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/add_flow_customer.fxml", event);
    }

    public void flowCompanyInfo(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/flow_displaycompany_info.fxml", event);
    }

    public void flowViewCusBase(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/flow_view_cus.fxml", event);
    }

    public void flowCreateCredit(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/add_flow_credit.fxml", event);
    }
}