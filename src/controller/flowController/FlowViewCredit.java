package controller.flowController;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import utilities.controller.ControllerUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FlowViewCredit {
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public ListView<String>flowViewCredit = new ListView<>();

    public void flowViewCreditBackBtn(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/flow/flow_m_selec.fxml", event);
    }

    public void viewFlowCreditBtn(ActionEvent event)throws IOException{
        controllerUtilities.ensureFileCreation("Flow_Customers.txt");
        Scanner scanner = new Scanner(new File("Flow_Customers.txt"));
        if(scanner.hasNext()) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().toLowerCase();
                this.flowViewCredit.getItems().add(line);
            }
        }else{
            this.flowViewCredit.getItems().add("Please add customer");
        }
    }
}
