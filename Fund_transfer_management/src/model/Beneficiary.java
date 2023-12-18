package model;

public class Beneficiary {
    private int beneficiaryId;
    private int accountNumber;
    private String accountStatus;
    private int currentBalance;
    private String ifsc;
    private String emailId;
    private double maximumTransferAmountLimit;

    public Beneficiary() {
    }

    public Beneficiary(int beneficiaryId, int accountNumber, int currentBalance, String ifsc, String emailId) {
        this.beneficiaryId = beneficiaryId;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.ifsc = ifsc;
        this.emailId = emailId;
    }

    public Beneficiary(int beneficiaryId, int accountNumber, String accountStatus, int currentBalance, String ifsc, String emailId, double maximumTransferAmountLimit) {
        this.beneficiaryId=beneficiaryId;
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.currentBalance = currentBalance;
        this.ifsc = ifsc;
        this.emailId = emailId;
        this.maximumTransferAmountLimit = maximumTransferAmountLimit;
    }

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getMaximumTransferAmountLimit() {
        return maximumTransferAmountLimit;
    }

    public void setMaximumTransferAmountLimit(double maximumTransferAmountLimit) {
        this.maximumTransferAmountLimit = maximumTransferAmountLimit;
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "beneficiaryId'" + beneficiaryId + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountStatus='" + accountStatus + '\'' +
                ", ifsc='" + ifsc + '\'' +
                ", emailId='" + emailId + '\'' +
                ", maximumTransferAmountLimit=" + maximumTransferAmountLimit +
                '}';
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}
