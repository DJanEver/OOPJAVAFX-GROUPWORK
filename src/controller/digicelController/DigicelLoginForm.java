package controller.digicelController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import models.Digicel;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class DigicelLoginForm {

    public TextField digiTextField;
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    Alert alert = new Alert(Alert.AlertType.NONE);


    public void digicelLoginFormBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/service_provider.fxml",event);
    }

    @FXML
    private void digiLoginBtn(ActionEvent event) throws IOException{
        Digicel digicel = new Digicel();

        if(digicel.getPassword().equals(digiTextField.getText())){
            controllerUtilities.switchScene("resources/digicel/digicel_m_selec.fxml",event);
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Password");
            alert.show();
        }
    }
}
