package controller.customerController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import utilities.controller.ControllerUtilities;

import java.io.*;
import java.util.Scanner;


/**
 *Class created by Hakeem Watson 2000391
 */
public class DigiAddCredit {

    /**
     *Declaration of variables
     */
    public TextField creditTFDigi;
    Alert alert = new Alert(Alert.AlertType.NONE);
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    /**
     *Back button for adding the credit
     */
    public void addCreditDigiBackBtn(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/digi_customer_menu.fxml", event);
    }

    /**
     *Add credit to digicel  voucher
     */
    public void addCreditDigiBtn(ActionEvent event)throws IOException{

        /**
         * Declaration of variables and files
         */
        String creditTFValue = creditTFDigi.getText();
        int digiCreditLine = 0;
        int digiCusBalanceLine = 0;
        File digiCreditFile = new File("DigicelCredit.txt");
        File digiCusFile = new File("Digicel_Customers.txt");
        File digiTempCusFile = new File("cusTemp.txt");
        File digiTempCreditFile = new File("creditTemp.txt");
        controllerUtilities.ensureFileCreation("DigicelCredit.txt");
        Scanner scanner = new Scanner(digiCreditFile);
        controllerUtilities.ensureFileCreation("Digicel_Customers.txt");
        Scanner scannerCus = new Scanner(digiCusFile);

        /**
         * makes sure that the fields are not empty and validate the
         * input for the right format
         */
        if(creditTFValue.equals("")){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Field must not be empty");
            alert.show();
        }else{
            if(creditTFValue.startsWith("*121*")) {
                if (creditTFValue.endsWith("#")) {
                    if (scanner.hasNext()) {
                        while (scanner.hasNext()) {
                            digiCreditLine++;
                            String line = scanner.nextLine().toLowerCase();
                            if (line.startsWith("vouchernumber: ")) {
                                if (line.substring(15, 27).equals(creditTFValue.substring(5, 17))) {
                                    if (creditTFValue.startsWith("*876", 17)) {
                                        if (creditTFValue.startsWith("302", 21) ||
                                                creditTFValue.startsWith("303", 21) ||
                                                creditTFValue.startsWith("304", 21) ||
                                                creditTFValue.startsWith("301", 21)) {
                                            if (scannerCus.hasNext()) {
                                                while (scannerCus.hasNext()) {
                                                    digiCusBalanceLine++; //plus 1
                                                    String lineCus = scannerCus.nextLine().toLowerCase();
                                                    if (lineCus.startsWith("phonenumber: ")) {
                                                        if (lineCus.substring(13, 23).equals
                                                                (creditTFValue.substring(18, 28))) {
                                                            String creditValue = scanner.nextLine().substring(14, 17);
                                                            String creditStatus = scanner.nextLine().substring(8, 11);
                                                            if(creditStatus.equals("New")){
                                                                String cusBalance = scannerCus.nextLine().
                                                                        toLowerCase().replaceAll("balance: ",
                                                                        "");
                                                                /**
                                                                 * Update digicel file
                                                                 */
                                                                updateDigiCusFile(digiCusBalanceLine, digiCreditLine,
                                                                        digiCreditFile,
                                                                        digiCusFile, creditValue,
                                                                        cusBalance);
                                                                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                                                                alert.setContentText("Files updated");
                                                                alert.show();
                                                                break;

                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                alert.setAlertType(Alert.AlertType.ERROR);
                                                alert.setContentText("Customer file is empty");
                                                alert.show();
                                                break;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    } else {
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("File empty no credit to add");
                        alert.show();
                    }
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("must end with # ex: *120*8763014567#");
                    alert.show();
                }
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("must start with *120* ex: *120*8763014567#");
                    alert.show();
            }
        }
        scanner.close();
        scannerCus.close();

        /**
         * alerts the user if anything goes wrong
         */
        if(digiCreditFile.delete()){
            System.out.print("old credit file delete");
        }else{
            System.out.print("old credit file not delete");
        }

        if(digiCusFile.delete()){
            System.out.print("old cus file delete");
        }else{
            System.out.print("old cus file not delete");
        }



        if(digiTempCreditFile.renameTo(digiCreditFile)){
            System.out.print("credit file renamed");
        }else{
            System.out.print("credit file broke");
        }

        if(digiTempCusFile.renameTo(digiCusFile)){
            System.out.print("cus file renamed");
        }else{
            System.out.print("cus file broke");
        }

    }

    /**
     * update digicel customer file
     */
    public void updateDigiCusFile(int digiCusLine, int digiCreditLine, File creditFilename, File cusFilename,
                                  String cValue, String cusOldBalance) throws IOException {

        int dummyCreditLine = 0;
        int dummyCusLine = 0;
        digiCreditLine+=2;
        digiCusLine+=1;

        /**
         * Creating scanner for credit Customer
         */
        Scanner scannerCredit = new Scanner(creditFilename);
        Scanner scannerCus = new Scanner(cusFilename);

        /**
         * Creating writer for credit Customer
         */
        FileWriter writerCredit = new FileWriter("creditTemp.txt");
        FileWriter writerCus = new FileWriter(("cusTemp.txt"));

        /**
         * Creating writer for credit Customer
         */
        BufferedWriter bufferedCreditWriter = new BufferedWriter(writerCredit);
        BufferedWriter bufferedCusWriter = new BufferedWriter(writerCus);

        /**
         * reading each line from the main file to insert into
         * a temp file
         */
        while(scannerCredit.hasNext()){
            dummyCreditLine++;
            String line = scannerCredit.nextLine();
            if(digiCreditLine != dummyCreditLine){
                bufferedCreditWriter.write(line + "\n");
            }else{
                bufferedCreditWriter.write("Status: Used" + "\n \n");
            }
        }

        /**
         * closing the buffer and writer
         */
        bufferedCreditWriter.close();
        writerCredit.close();


        /**
         * reading each line from the main file to insert into
         * a temp file
         */
        while(scannerCus.hasNext()){
            dummyCusLine++;
            String line = scannerCus.nextLine();
            if(digiCusLine != dummyCusLine){
                bufferedCusWriter.write(line + "\n");
            }else{
                int newBalance = Integer.parseInt(cValue) + Integer.parseInt(cusOldBalance);
                bufferedCusWriter.write("Balance: " + newBalance +"\n\n\n");
            }
        }


        /**
         * closing the buffer and writer
         */
        bufferedCusWriter.close();
        writerCus.close();

        /**
         * closing the scanner files
         */
        scannerCredit.close();
        scannerCus.close();

    }

}
