package model;

public class AccountHolder {
    private int accountNumber;
    private String CustomerName;
    private String emailId;
    private double balance;
    private String address;
    private String password;
    public AccountHolder(int accountNumber, String CustomerName, String emailId, double balance, String address, String password) {

        this.CustomerName = CustomerName;
        this.accountNumber = accountNumber;
        this.emailId = emailId;
        this.balance = balance;
        this.address = address;
        this.password = password;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                ", CustomerName='" + CustomerName + '\'' +
                ", accountNumber=" + accountNumber +
                ", emailId='" + emailId + '\'' +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                '}';
    }
}
