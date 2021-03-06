package controller.flowController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Flow;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class AddFlowCustomer {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public TextField flowCusTfID;
    public TextField flowCusLN;
    public TextArea flowCusAddress;
    public TextField flowCusNumPrefix;
    public TextField flowCusNumBody;
    Alert alert = new Alert(Alert.AlertType.NONE);
    public Flow flow = new Flow();

    public void addCFBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/flow_m_selec.fxml",
                event);
    }

    public void addFCusBtn(ActionEvent event) throws IOException{
        final String filename = "Flow_Customers.txt";
        controllerUtilities.ensureFileCreation(filename);
        if (controllerUtilities.isAddTfEmpty(flowCusTfID.getText(), flowCusLN.getText(), flowCusAddress.getText(),
                flowCusNumPrefix.getText(), flowCusNumBody.getText())) {
            if(flowCusTfID.getText().length() > 6) {
                if(flowCusLN.getText().length() > 3 && flowCusAddress.getText().length() > 3) {
                    if(flowCusNumBody.getText().length() == 7) {
                        if (flowCusNumPrefix.getText().equals("876")) {
                            if (controllerUtilities.searchCusID(filename, flowCusTfID.getText()
                                    .toLowerCase())) {
                                alert.setAlertType(Alert.AlertType.ERROR);
                                alert.setContentText("ID already exists please try again");
                                alert.show();
                            } else {
                                if(flowCusNumBody.getText().startsWith("601") ||
                                        flowCusNumBody.getText().startsWith("602") ||
                                        flowCusNumBody.getText().startsWith("603") ||
                                        flowCusNumBody.getText().startsWith("604")) {
                                    if (!controllerUtilities.checkForNumber(filename, flowCusNumPrefix.getText() +
                                            flowCusNumBody.getText())) {
                                        if (controllerUtilities.writeCusToFile(filename,
                                                flowCusTfID.getText(), flowCusLN.getText(), flowCusAddress.getText()
                                                , flowCusNumPrefix.getText(), flowCusNumBody.getText(), String.valueOf(flow.getBalance()))) {
                                            alert.setAlertType(Alert.AlertType.CONFIRMATION);
                                            alert.setContentText("Customer added");
                                            alert.show();
                                        } else {
                                            System.out.print("Something went wrong\n");
                                        }
                                    } else {
                                        alert.setAlertType(Alert.AlertType.ERROR);
                                        alert.setContentText("Phone number already exits");
                                        alert.show();
                                    }
                                }else{
                                    alert.setAlertType(Alert.AlertType.ERROR);
                                    alert.setContentText("phone number must start with: " +
                                            "\n" + "601, 602, 603, 604 ex 8766011234");
                                    alert.show();

                                }                            }
                        }else{
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setContentText("Prefix not valid must be 876");
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
