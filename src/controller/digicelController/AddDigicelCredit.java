package controller.digicelController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Digicel;
import utilities.controller.ControllerUtilities;

import java.io.IOException;

public class AddDigicelCredit {

    final public ControllerUtilities controllerUtilities = new ControllerUtilities();
    public TextField dVoucher;
    public TextField dValue;
    Alert alert = new Alert(Alert.AlertType.NONE);
    public Digicel digicel = new Digicel();


    public void digicelBackBut(ActionEvent event) throws IOException {
        controllerUtilities.switchScene("resources/digicel/digicel_m_selec.fxml",
                event);
    }

    public void addDigicelCredit(ActionEvent event) throws IOException {
        final String filename = "DigicelCredit.txt";

        controllerUtilities.ensureFileCreation(filename);

        if (controllerUtilities.ifNullValue(dVoucher.getText(),Integer.parseInt(dValue.getText())))
        {
            if(dVoucher.getText().length() < 12)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher length cannot be less than 12 char");
                alert.show();
            }
            else if(dVoucher.getText().length() > 12)
                {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher length cannot be greater than 12 char");
                alert.show();
                }
            else if(Integer.parseInt(dValue.getText()) >1000)
             {
                 alert.setAlertType(Alert.AlertType.ERROR);
                 alert.setContentText("Voucher cannot be greater than 1000");
                 alert.show();
                }
            else if(Integer.parseInt(dValue.getText()) <100)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher cannot be less than 100");
                alert.show();
            }
            else if(Integer.parseInt(dValue.getText() ) !=100 && Integer.parseInt(dValue.getText() ) !=200 &&
                    Integer.parseInt(dValue.getText() ) !=500 && Integer.parseInt(dValue.getText() ) !=1000)
            {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Voucher must valued at 100,200,500 or 1000");
                alert.show();
            }
            else
            {
               if(controllerUtilities.writeCreditToFile(filename,dVoucher.getText(),Integer.parseInt(dValue.getText())
               , "New"))
                    {
                        alert.setAlertType(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("Credit added to file");
                        alert.show();
                     }else{
                            System.out.print("Something went wrong");
                        }
                    }
            }
              }

    }



