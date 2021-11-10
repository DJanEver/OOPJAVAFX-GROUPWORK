package controller.digicelController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Digicel;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

/**
 * Class created by hakeem watson-2000391
 * this is the controller class for the add_digi_customer.fxml file
 **/
public class AddCustomerDigi {

    /**
     * variables that will get the data from the text fields.
     **/
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public TextField digiCusTfID;
    public TextField digiCusLN;
    public TextArea digiCusAddress;
    public TextField digiCusNumPrefix;
    public TextField digiCusNumBody;
    Alert alert = new Alert(Alert.AlertType.NONE);
    public Digicel digicel = new Digicel();

    /**
     *Method created by hakeem watson 2000391
     * this method is used to control the back button and send the user back to the main digicel
     * selection menu
     */
    public void addCDBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/digicel/digicel_m_selec.fxml",
                event);
    }


    /**
     *Method created by hakeem watson 2000391
     * this method is used to control the add customer button when clicked it
     * writes the data gathered from the text fields into thr respective file.
     */
    public void addCusBtn(ActionEvent event) throws IOException {
        final String filename = "Digicel_Customers.txt";

        /**
         *ensureFileCreation ensures the file was created.
         */
        controllerUtilities.ensureFileCreation(filename);

        /**
         *The following bellow validates the data from the text fields and calls the write to file function
         * to pass the data
         */
        if (controllerUtilities.isAddTfEmpty(digiCusTfID.getText(), digiCusLN.getText(), digiCusAddress.getText(),
                digiCusNumPrefix.getText(), digiCusNumBody.getText())) {
            if(digiCusTfID.getText().length() > 6) {
                if(digiCusLN.getText().length() > 3 && digiCusAddress.getText().length() > 3) {
                    if(digiCusNumBody.getText().length() == 7) {
                        if (digicel.getNumPrefix().contains(digiCusNumPrefix.getText())) {
                        if (controllerUtilities.searchCusID(filename, digiCusTfID.getText()
                                .toLowerCase())) {
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setContentText("ID already exists please try again");
                            alert.show();
                        } else {
                            if (!controllerUtilities.checkForNumber(filename, digiCusNumPrefix.getText() +
                                    digiCusNumBody.getText())) {
                                if (controllerUtilities.writeCusToFile(filename,
                                        digiCusTfID.getText(), digiCusLN.getText(), digiCusAddress.getText()
                                        , digiCusNumPrefix.getText(), digiCusNumBody.getText(), String.valueOf(digicel.getBalance()))) {

                                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                                    alert.setContentText("Customer added");
                                    alert.show();
                                } else {
                                    System.out.print("Something went wrong");
                                }
                            }else{
                                alert.setAlertType(Alert.AlertType.ERROR);
                                alert.setContentText("Phone number already exits or File Empty");
                                alert.show();
                            }
                        }
                    }else{

                            /**
                             *alerts are displayed when the user enters invalid data.
                             */
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
                alert.setContentText("ID must have more that 6 characters");
                alert.show();
            }
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("no Field must be empty");
            alert.show();
        }
    }


}
