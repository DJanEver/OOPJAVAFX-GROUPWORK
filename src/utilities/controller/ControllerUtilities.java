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
                return true;
            }
        }
        return false;
    }

    public boolean writeCusToFile(String fileName, String digiCusTfID, String digiCusLN,String digiCusAddress,
                                  String digiCusNumPrefix, String digiCusNumBody, String numberCus){

        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    "CusID: " + digiCusTfID.toLowerCase() + "\n" +
                            "Lastname: " + digiCusLN + "\n" +
                            "Address: " + digiCusAddress + "\n" +
                            "PhoneNumber: " + digiCusNumPrefix + "-" + digiCusNumBody +
                    "\nNumber of customers: " + numberCus + "\n\n\n");
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


    public boolean isAddTfEmpty(String cusTfID, String cusLN, String cusAddress, String cusNumPrefix,
                             String cusNumBody) {

        return !cusTfID.equals("") && !cusLN.equals("") && !cusAddress.equals("") &&
                !cusNumPrefix.equals("") && !cusNumBody.equals("");
    }

}
