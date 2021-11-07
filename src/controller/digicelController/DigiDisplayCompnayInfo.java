package controller.digicelController;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import models.Digicel;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class DigiDisplayCompnayInfo {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public ListView<String> companyInfoLV = new ListView<String>();
    public Digicel digicel = new Digicel();

    public void digiCDBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/digicel/digicel_m_selec.fxml", event);
    }

    /**
     * Adding the data to the List view.
     */
    public void showDigiInfoBtn(ActionEvent event){
        this.companyInfoLV.getItems().add("Company Address: ");
        this.companyInfoLV.getItems().add(Digicel.getAddress());
        this.companyInfoLV.getItems().add("Company Password: ");
        this.companyInfoLV.getItems().add(digicel.getPassword());
        this.companyInfoLV.getItems().add("Company ID: ");
        this.companyInfoLV.getItems().add(String.valueOf(Digicel.getCompanyID()));
        this.companyInfoLV.getItems().add("Number of company branches: ");
        this.companyInfoLV.getItems().add(String.valueOf(digicel.getNumOfBranches()));
        this.companyInfoLV.getItems().add("Number of customers: ");
        this.companyInfoLV.getItems().add(String.valueOf(Digicel.getNumberOfCustomer()));
    }

}
