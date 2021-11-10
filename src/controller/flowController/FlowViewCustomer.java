
//Done by Grosjean Jackson 2002903

package controller.flowController;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import utilities.controller.ControllerUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//Creating Flow Customer Base Class
public class FlowViewCustomer {
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    //Creating a ListView for FLow which accepts Strings
    public ListView<String> flowViewCustomer = new ListView<String>();

    //Button for going back to the Flow Main Selection Page
    public void flowVCBackBtn(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/flow/flow_m_selec.fxml", event);
    }

    //Viewing the Flow_Customers.txt File and printing it onto the ListView
    public void flowViewCusBtn(ActionEvent event) throws IOException {
        controllerUtilities.ensureFileCreation("Flow_Customers.txt");
        Scanner scanner = new Scanner(new File("Flow_Customers.txt"));
       if(scanner.hasNext()) {
           while (scanner.hasNext()) {
               String line = scanner.nextLine().toLowerCase();
               this.flowViewCustomer.getItems().add(line);
           }
       }else{
           this.flowViewCustomer.getItems().add("Please add customer");

       }
    }
}