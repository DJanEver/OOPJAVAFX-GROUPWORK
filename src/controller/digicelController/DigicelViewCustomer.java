
//Done by Grosjean Jackson 2002903

package controller.digicelController;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import utilities.controller.ControllerUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//Creating Digicel Customer Base Class
public class DigicelViewCustomer {
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    //Creating a ListVew for Digicel which accepts Strings
    public ListView<String> digicelViewCustomer = new ListView<String>();

    //Button for going back to the Digicel Main Selection Page
    public void digiVCBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/digicel/digicel_m_selec.fxml", event);
    }

    //Viewing the Digicel_Customers.txt File and printing it onto the ListView
    public void viewCusBtn(ActionEvent event) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Digicel_Customers.txt"));
        while(scanner.hasNext()){
            String line = scanner.nextLine().toLowerCase();
            this.digicelViewCustomer.getItems().add(line);
        }

    }
}