package controller.digicelController;

import javafx.event.ActionEvent;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

/**
 * class edited by everyone
 */
public class DigicelMainSelection {

    /**
     * declartion of variables
     */
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    /**
     *method created by hakeem watson 2000391
     */
    public void digicelMBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/service_provider.fxml",event);
    }

    /**
     *method created by hakeem watson 2000391
     */
    public void callAddCus(ActionEvent event ) throws IOException{
        controllerUtilities.switchScene("resources/digicel/add_digi_customer.fxml", event);
    }

    public void digiCompanyInfo(ActionEvent event) throws IOException{
        controllerUtilities.switchScene("resources/digicel/digi_displaycompany_info.fxml", event);
    }

    public void viewCusBase(ActionEvent event) throws IOException{
        controllerUtilities.switchScene("resources/digicel/digi_view_cus.fxml", event);
    }

    public void digiCredit(ActionEvent event) throws IOException{
        controllerUtilities.switchScene("resources/digicel/add_digi_credit.fxml", event);
    }

    public void switchToViewPC(ActionEvent event)throws IOException{
        controllerUtilities.switchScene("resources/digicel/view_digi_credit.fxml", event);
    }

    public void switchToCreatePC(ActionEvent event)throws IOException{
        controllerUtilities.switchScene("resources/digicel/add_digi_credit.fxml",event);
    }

}
