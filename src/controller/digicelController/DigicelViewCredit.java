package controller.digicelController;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import utilities.controller.ControllerUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * class created by Jhavon Bron
 */
public class DigicelViewCredit {
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public ListView<String>digicelViewCredit = new ListView<>();

    public void digiViewCreditBackBtn(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/digicel/digicel_m_selec.fxml", event);
    }

    public void viewCreditBtn(ActionEvent event)throws IOException{
        controllerUtilities.ensureFileCreation("DigicelCredit.txt");
        Scanner scanner = new Scanner(new File("DigicelCredit.txt"));
        if(scanner.hasNext()) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().toLowerCase();
                this.digicelViewCredit.getItems().add(line);
            }
        }else{
            this.digicelViewCredit.getItems().add("Please add credit");
        }
        scanner.close();
    }
}
