package models;

import java.util.List;

public abstract class ServiceProvider {

    private static int companyID;
    private static String address;
    private static int numberOfCustomer;
    private String password;
    private List<String> numPrefix;

    public ServiceProvider(){}
    public ServiceProvider(int companyID, String address, int numberOfCustomer, String password){
        ServiceProvider.companyID = companyID;
        ServiceProvider.address = address;
        ServiceProvider.numberOfCustomer = numberOfCustomer;
        this.password = password;
    }


    public static int getCompanyID() { return companyID; }

    public static void setCompanyID(int companyID) { ServiceProvider.companyID = companyID; }

    public static String getAddress() { return address; }

    public static void setAddress(String address) { ServiceProvider.address = address; }

    public static int getNumberOfCustomer() { return numberOfCustomer; }

    public static void setNumberOfCustomer(int numberOfCustomer) {
        ServiceProvider.numberOfCustomer = numberOfCustomer;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    abstract public void addCustomer();
    abstract public void viewCustomerBase();
    abstract public void createPhoneCredit();
    abstract public void viewPhoneCredit();
    abstract public void displayCompanyInfo();
    abstract  public String toString();

    public List<String> getNumPrefix() {
        return numPrefix;
    }

    public void setNumPrefix(List<String> numPrefix) {
        this.numPrefix = numPrefix;
    }
}
