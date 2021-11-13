package controller.customerController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import utilities.controller.ControllerUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 *Class created by Hakeem Watson 2000391
  */
public class FlowAddCredit {

    /**
     *Declaration of variables
     */
    public TextField creditTFFlow;
    Alert alert = new Alert(Alert.AlertType.NONE);
    final public ControllerUtilities controllerUtilities = new ControllerUtilities();

    /**
     *Back button Method
     */
    public void addCreditFlowBackBtn(ActionEvent event)throws IOException {
        controllerUtilities.switchScene("resources/customer/flow_customer_menu.fxml", event);
    }

    /**
     *Add credit to Flow  voucher
     */
    public void addCreditFlowBtn(ActionEvent event)throws IOException{

        /**
         * Declaration of variables and files
         */
        String creditTFValue = creditTFFlow.getText();
        int flowCreditLine = 0;
        int flowCusBalanceLine = 0;
        File flowCreditFile = new File("FlowCredit.txt");
        File flowCusFile = new File("Flow_Customers.txt");
        File flowTempCusFile = new File("cusTemp.txt");
        File flowTempCreditFile = new File("creditTemp.txt");
        controllerUtilities.ensureFileCreation("FlowCredit.txt");
        Scanner scanner = new Scanner(flowCreditFile);
        controllerUtilities.ensureFileCreation("Flow_Customers.txt");
        Scanner scannerCus = new Scanner(flowCusFile);

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
                            flowCreditLine++;
                            String line = scanner.nextLine().toLowerCase();
                            if (line.startsWith("vouchernumber: ")) {
                                if (line.substring(15, 27).equals(creditTFValue.substring(5, 17))) {
                                    if (creditTFValue.startsWith("*876", 17)) {
                                        if (creditTFValue.startsWith("602", 21) ||
                                                creditTFValue.startsWith("603", 21) ||
                                                creditTFValue.startsWith("604", 21) ||
                                                creditTFValue.startsWith("601", 21)) {
                                            if (scannerCus.hasNext()) {
                                                while (scannerCus.hasNext()) {
                                                    flowCusBalanceLine++; //plus 1
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
                                                                 * Update Flow file
                                                                 */
                                                                updateFlowCusFile(flowCusBalanceLine, flowCreditLine,
                                                                        flowCreditFile,
                                                                        flowCusFile, creditValue,
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
                        /**
                         * alerts the user if anything goes wrong
                         */
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("File empty no credit to add");
                        alert.show();
                    }
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("must end with # ex: *120*8766014567#");
                    alert.show();
                }
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("must start with *120* ex: *120*8766014567#");
                    alert.show();
            }
        }
        /**
         * closes scanner
         */
        scanner.close();
        scannerCus.close();

        /**
         * deletes old files
         */
        if(flowCreditFile.delete()){
            System.out.print("old credit file delete");
        }else{
            System.out.print("old credit file not delete");
        }

        if(flowCusFile.delete()){
            System.out.print("old cus file delete");
        }else{
            System.out.print("old cus file not delete");
        }


        /**
         * rename old files
         */
        if(flowTempCreditFile.renameTo(flowCreditFile)){
            System.out.print("credit file renamed");
        }else{
            System.out.print("credit file broke");
        }

        if(flowTempCusFile.renameTo(flowCusFile)){
            System.out.print("cus file renamed");
        }else{
            System.out.print("cus file broke");
        }


    }

    /**
     * update flow customer file
     */
    public void updateFlowCusFile(int digiCusLine, int digiCreditLine, File creditFilename, File cusFilename,
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
         * **
          closing the buffer and writer
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
