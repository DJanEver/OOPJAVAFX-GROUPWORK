package models;

import java.util.Arrays;
import java.util.List;

public class Flow extends ServiceProvider {

    private String parentCompanyName;

    public Flow(){
        List<String> preNumList = Arrays.asList("601", "602", "603",  "604");
        this.setNumPrefix(preNumList);
        this.setPassword("TheWayIFlow2021");
        setCompanyID(600);
        setAddress("Flow Jamaica Headquarters, 2-6 Carlton Cres, Kingston");
        this.parentCompanyName = "Flow Enterprise";
    }
    public Flow(String parentCompanyName){
        this.parentCompanyName = parentCompanyName;
        this.setPassword("TheWayIFlow2021");
        setCompanyID(600);
        setAddress("Flow Jamaica Headquarters, 2-6 Carlton Cres, Kingston");
        this.parentCompanyName = "Flow Enterprise";
    }


    public String getParentCompanyName() {
        return parentCompanyName;
    }

    public void setParentCompanyName(String parentCompanyName) {
        this.parentCompanyName = parentCompanyName;
    }

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
