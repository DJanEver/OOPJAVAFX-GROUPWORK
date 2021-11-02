package controller.digicelController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Digicel;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class AddCustomerDigi {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public TextField digiCusTfID;
    public TextField digiCusLN;
    public TextArea digiCusAddress;
    public TextField digiCusNumPrefix;
    public TextField digiCusNumBody;
    Alert alert = new Alert(Alert.AlertType.NONE);
    public Digicel digicel = new Digicel();

    public void addCDBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/digicel/digicel_m_selec.fxml",
                event);
    }
    public void addCusBtn(ActionEvent event) throws IOException {
        final String filename = "Digicel_Customers.txt";
        controllerUtilities.ensureFileCreation(filename);
        if (!controllerUtilities.isAddTfEmpty(digiCusTfID.getText(), digiCusLN.getText(), digiCusAddress.getText(),
                digiCusNumPrefix.getText(), digiCusNumBody.getText())) {
            if(digiCusTfID.getText().length() == 3) {
                if(digiCusLN.getText().length() > 3 && digiCusAddress.getText().length() > 3) {
                    if(digiCusNumBody.getText().length() == 7) {
                        if (digicel.getNumPrefix().contains(digiCusNumPrefix.getText())) {
                        if (controllerUtilities.searchCusID(filename, digiCusTfID.getText()
                                .toLowerCase())) {
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setContentText("ID already exists please try again");
                            alert.show();
                        } else {

                            if(controllerUtilities.writeCusToFile(filename,
                                    digiCusTfID.getText(), digiCusLN.getText(), digiCusAddress.getText()
                            ,digiCusNumPrefix.getText(), digiCusNumBody.getText())){
                              System.out.print("Works file in");
                            }else{
                                System.out.print("Something went wrong");
                            }
                        }
                    }else{
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setContentText("Prefix does not exist please use one of the following: " +
                                   "\n" + "301, 302, 303, 304");
                            alert.show();
                        }
                    }else{
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("Body must have only 7 digits eg: 1234567");
                        alert.show();
                    }
                }else {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Last name and address must have more than 3 numbers");
                    alert.show();
                }
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("ID must have 3 characters eg: Q2E");
                alert.show();
            }
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("no Field must be empty");
            alert.show();
        }
    }


}
