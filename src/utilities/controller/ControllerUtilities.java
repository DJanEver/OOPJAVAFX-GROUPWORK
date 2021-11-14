package utilities.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ControllerUtilities {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScene(String path, ActionEvent event) throws IOException {
        this.root = FXMLLoader.load(Objects.requireNonNull
                (getClass().getClassLoader().getResource(path)));
        this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public boolean searchCusID(String fileName, String searchStr) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while(scanner.hasNext()){
            String line = scanner.nextLine().toLowerCase();
            if(line.contains(searchStr)){
                scanner.close();
                return true;
            }
        }
        scanner.close();
        return false;
    }

    public boolean writeCusToFile(String fileName, String digiCusTfID, String digiCusLN,String digiCusAddress,
                                  String digiCusNumPrefix, String digiCusNumBody, String cusBalance){

        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    "CusID: " + digiCusTfID.toLowerCase() + "\n" +
                            "Lastname: " + digiCusLN + "\n" +
                            "Address: " + digiCusAddress + "\n" +
                            "PhoneNumber: " + digiCusNumPrefix + digiCusNumBody +
                    "\nBalance: " + cusBalance + "\n\n\n");
            bufferedWriter.close();
            writer.close();
            return true;
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        return false;
    }

    public void  ensureFileCreation(String filename) throws IOException{
        File myFile = new File(filename);
        if(myFile.createNewFile()){
            System.out.print("File created\n");
        }else{
            System.out.print("File exists\n");
        }
    }

    public int countNumOfCustomer(String filename)throws IOException{
        this.ensureFileCreation(filename);
        Scanner scanner = new Scanner(new File(filename));
        int numberOfCus = 0;
        while(scanner.hasNext()){
            String line = scanner.nextLine().toLowerCase();
            if(line.startsWith("cusid: ")){
               numberOfCus++;
            }
        }
        scanner.close();
        return numberOfCus;
    }

    public boolean isAddTfEmpty(String cusTfID, String cusLN, String cusAddress, String cusNumPrefix,
                             String cusNumBody) {

        return !cusTfID.equals("") && !cusLN.equals("") && !cusAddress.equals("") &&
                !cusNumPrefix.equals("") && !cusNumBody.equals("");
    }

    /**
     *Onieka Id 1800249 checking if credit amount and length is correct.
     */

    public boolean ifNullValue(String voucher,int value) {

        return !voucher.equals("") && value != 0;
    }

    public boolean writeCreditToFile(String fileName, String voucher, int value, String status){

        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    "VoucherNumber: " + voucher + "\n" +
                            "VoucherValue: " + value + "\nStatus: " +
                            status + "\n \n" );
            bufferedWriter.close();
            writer.close();
            return true;
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        return false;
    }


    public boolean checkForNumber(String filename, String phoneNumber)throws IOException {
        this.ensureFileCreation(filename);
        Scanner scanner = new Scanner(new File(filename));
        if (scanner.hasNext()) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().toLowerCase();
                if (line.startsWith("phonenumber: ")) {
                    if (line.substring(13, 23).equals(phoneNumber)) {
                        scanner.close();
                        return true;
                    }
                }
            }
        } else{
            scanner.close();
            return false;
        }
        scanner.close();
            return false;
    }


}
