package controller.flowController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Flow;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class FlowLoginForm {

    public TextField flowTextField;
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    Alert alert = new Alert(Alert.AlertType.NONE);

    public void flowLoginFormBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/service_provider.fxml",event);
    }

    @FXML
    private void flowLoginBtn(ActionEvent event) throws IOException{
        Flow flow = new Flow();
        if(flow.getPassword().equals(flowTextField.getText())){
            controllerUtilities.switchScene("resources/flow/flow_m_selec.fxml",event);
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Password");
            alert.show();
        }
    }
}
