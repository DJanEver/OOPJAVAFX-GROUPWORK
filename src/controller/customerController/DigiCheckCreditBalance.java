package controller.customerController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.Digicel;
import utilities.controller.ControllerUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DigiCheckCreditBalance {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public TextField checkCreditTF;
    Alert alert = new Alert(Alert.AlertType.NONE);
    public ListView<String>displayCBalance = new ListView<>();
//

    public void checkBalanceBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/customer/digi_customer_menu.fxml",
                event);
    }

    public void checkDigiBalance(ActionEvent event) throws IOException{
        String creditTFValue = checkCreditTF.getText();
        if(creditTFValue.equals("")){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Field must not be empty");
            alert.show();
        }else{
            if(creditTFValue.startsWith("*120*")){
                //move on
                if(creditTFValue.startsWith("301", 8) || creditTFValue.startsWith("302", 8)
                || creditTFValue.startsWith("303", 8) || creditTFValue.startsWith("304", 8)){
                    if(creditTFValue.endsWith("#")){
                        //move on
                        if(!searchForDigiNum(creditTFValue.substring(5, 15))){
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setContentText("phone number does not exist or file empty(Please add customer)");
                            alert.show();
                        }
                    }else{
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("must end with # ex: *120*876301567#");
                        alert.show();
                    }
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("phone number must start with 301, 302, 303, 304 ex: *120*876301567#");
                    alert.show();
                }
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("must start with *120* ex: *120*876301567#");
                alert.show();
            }
        }
    }

    public boolean searchForDigiNum(String number) throws IOException {
        controllerUtilities.ensureFileCreation("Digicel_Customers.txt");
        Scanner scanner = new Scanner(new File("Digicel_Customers.txt"));
        if(scanner.hasNext()) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().toLowerCase();
                if (line.startsWith("phonenumber: ")) {
                    if (line.substring(13, 23).equals(number)) {
                        displayCBalance.getItems().add(scanner.nextLine());
                        scanner.close();
                        return true;
                    }
                }
            }
        }else{
            scanner.close();
            return  false;
        }
        scanner.close();
        return false;
    }

}
