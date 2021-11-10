package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import models.Digicel;
import models.Flow;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class ShowNumberOfCustomer {

    public final ControllerUtilities controllerUtilities = new ControllerUtilities();
    public ListView<String>displayNumberOfCusListV = new ListView<>();

    public void switchToHome(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/home.fxml", event);
    }


    public void showTotalNumber(ActionEvent event) throws IOException{
        this.displayNumberOfCusListV.getItems().add("Total number of  digicel customer: ");
        this.displayNumberOfCusListV.getItems().add(String.valueOf(Digicel.getNumberOfCustomer()));
        this.displayNumberOfCusListV.getItems().add("Total number of  flow customer: ");
        this.displayNumberOfCusListV.getItems().add(String.valueOf(Flow.getNumberOfCustomer()));
    }
}
