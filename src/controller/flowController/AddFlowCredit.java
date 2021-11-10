package controller.flowController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;
import models.Flow;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class AddFlowCredit {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public TextField fVoucher;
    public TextField fValue;
    Alert alert = new Alert(Alert.AlertType.NONE);
    public Flow flow = new Flow();

/** done by onieka*/
    public void flowBackBut(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/flow_m_selec.fxml",
                event);
    }

    public void flowAddCredit(ActionEvent event) throws IOException {
        final String filename = " FlowCredit.txt";

        controllerUtilities.ensureFileCreation(filename);

        if (controllerUtilities.ifNullValue(fVoucher.getText(),Integer.parseInt(fValue.getText())))
        {
            if(fVoucher.getText().length() < 12)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher length cannot be less than 12 char");
                alert.show();
            }
            else if(fVoucher.getText().length() > 12)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher length cannot be greater than 12 char");
                alert.show();
            }
            else if(Integer.parseInt(fValue.getText()) >1000)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher cannot be greater than 1000");
                alert.show();
            }
            else if(Integer.parseInt(fValue.getText()) <100)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher cannot be less than 100");
                alert.show();
            }
            else if(Integer.parseInt(fValue.getText() ) !=100 && Integer.parseInt(fValue.getText() ) !=200 &&
                    Integer.parseInt(fValue.getText() ) !=500 && Integer.parseInt(fValue.getText() ) !=1000)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher must valued at 100,200,500 or 1000");
                alert.show();
            }
            else
            {
                if(controllerUtilities.writeCreditToFile(filename,fVoucher.getText(),Integer.parseInt(fValue.getText()) ))
                {
                    System.out.print("Added credit to file");
                }else{
                    System.out.print("Something went wrong");
                }
            }
        }
    }

}

