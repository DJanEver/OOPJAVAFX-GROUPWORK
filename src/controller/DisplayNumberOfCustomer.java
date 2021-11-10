package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import models.Digicel;
import models.Flow;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class DisplayNumberOfCustomer {
    public final ControllerUtilities controllerUtilities = new ControllerUtilities();
    public ListView<String> numberOfCus = new ListView<>();

    public void backBtnForDNOCus(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/service_provider.fxml", event);
    }

    public void showNumOfCus(ActionEvent event)throws IOException{
        this.numberOfCus.getItems().add("Digicel: ");
        this.numberOfCus.getItems().add(String.valueOf(Digicel.getNumberOfCustomer()));
        this.numberOfCus.getItems().add("Flow: ");
        this.numberOfCus.getItems().add(String.valueOf(Flow.getNumberOfCustomer()));

    }

}
