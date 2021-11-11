package controller.customerController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import utilities.controller.ControllerUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FlowCheckCreditBalance {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public TextField checkFlowCreditTF;
    Alert alert = new Alert(Alert.AlertType.NONE);
    public ListView<String>displayFlowCBalance = new ListView<>();
//

    public void checkBalanceFlowBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/customer/flow_customer_menu.fxml",
                event);
    }

    public void checkFlowiBalance(ActionEvent event) throws IOException{
        String creditTFValue = checkFlowCreditTF.getText();
        if(creditTFValue.equals("")){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Field must not be empty");
            alert.show();
        }else{
            if(creditTFValue.startsWith("*120*")){
                //move on
                if(creditTFValue.startsWith("601", 8) || creditTFValue.startsWith("602", 8)
                || creditTFValue.startsWith("603", 8) || creditTFValue.startsWith("604", 8)){
                    if(creditTFValue.endsWith("#")){
                        //move on
                        if(!searchForFlowNum(creditTFValue.substring(5, 15))){
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setContentText("phone number does not exist or File empty");
                            alert.show();
                        }
                    }else{
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("must end with # ex: *120*876601567#");
                        alert.show();
                    }
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("phone number must start with 601, 602, 603, 604 ex: *120*876601567#");
                    alert.show();
                }
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("must start with *120* ex: *120*876601567#");
                alert.show();
            }
        }
    }

    public boolean searchForFlowNum(String number) throws IOException {
        controllerUtilities.ensureFileCreation("Flow_Customers.txt");
        Scanner scanner = new Scanner(new File("Flow_Customers.txt"));
        if(scanner.hasNext()) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().toLowerCase();
                if (line.startsWith("phonenumber: ")) {
                    if (line.substring(13, 23).equals(number)) {
                        displayFlowCBalance.getItems().add(scanner.nextLine());
                        scanner.close();
                        return true;
                    }
                }
            }
        }else{
            scanner.close();
            return false;
        }
        scanner.close();
        return false;
    }

}
