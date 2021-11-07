package controller.flowController;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

import models.Flow;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class FlowDisplayCompnayInfo {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public ListView<String> companyInfoLV = new ListView<String>();
    public Flow flow = new Flow();

    public void flowCDBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/flow_m_selec.fxml", event);
    }

    /**
     * Adding the data to the List view.
     */
    public void showFlowInfoBtn(ActionEvent event){
        this.companyInfoLV.getItems().add("Company Address: ");
        this.companyInfoLV.getItems().add(Flow.getAddress());
        this.companyInfoLV.getItems().add("Company Password: ");
        this.companyInfoLV.getItems().add(flow.getPassword());
        this.companyInfoLV.getItems().add("Company ID: ");
        this.companyInfoLV.getItems().add(String.valueOf(Flow.getCompanyID()));
        this.companyInfoLV.getItems().add("Main Company name: ");
        this.companyInfoLV.getItems().add(flow.getParentCompanyName());
        this.companyInfoLV.getItems().add("Number of customers: ");
        this.companyInfoLV.getItems().add(String.valueOf(Flow.getNumberOfCustomer()));
    }

}
