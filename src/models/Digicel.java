package models;

import java.util.Arrays;
import java.util.List;

public class Digicel extends ServiceProvider {

    private int numOfBranches;


    public Digicel(){
        List<String> preNumList = Arrays.asList("301", "302", "303", "304");
        this.setNumPrefix(preNumList);
        this.setPassword("TheBiggerBetterNetwork2021");
    }
    public Digicel(int numOfBranches){
        this.numOfBranches = numOfBranches;
        this.setPassword("TheBiggerBetterNetwork2021");
    }

    public int getNumOfBranches() { return numOfBranches; }

    public void setNumOfBranches(int numOfBranches) { this.numOfBranches = numOfBranches; }

    @Override
    public void addCustomer() {}

    @Override
    public void viewCustomerBase() {}

    @Override
    public void createPhoneCredit() {}

    @Override
    public void viewPhoneCredit() {}

    @Override
    public void displayCompanyInfo() {}

    @Override
    public String toString(){
        return this.getPassword();
    }



}
