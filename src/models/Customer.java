package models;

public class Customer {

    private int customerID;
    private String lastName;
    private String address;
    private String phoneNumBody;
    private int creditBalance;
    private String phoneNumPrefix;

    public Customer(){}
    public Customer(int customerID, String lastName, String address,
                    String telephoneNum, int creditBalance, String phoneNumPrefix){

        this.customerID = customerID;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumBody = telephoneNum;
        this.creditBalance = creditBalance;
        this.phoneNumPrefix = phoneNumPrefix;
    }

    public int getCustomerID() { return customerID; }

    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumBody() { return phoneNumBody; }

    public void setPhoneNumBody(String phoneNumBody) { this.phoneNumBody = phoneNumBody; }

    public int getCreditBalance() { return creditBalance; }

    public void setCreditBalance(int creditBalance) { this.creditBalance = creditBalance; }

    public void addCredit(){}
    public void checkBalance(){}

    public String getPhoneNumPrefix() { return phoneNumPrefix; }

    public void setPhoneNumPrefix(String phoneNumPrefix) {
        this.phoneNumPrefix = phoneNumPrefix;
    }
}
