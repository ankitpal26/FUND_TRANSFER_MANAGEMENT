package model;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private long accountHolderAccount;
    private long beneficiaryAccount;
    private  double transactionAmount;
    private String transactionNarration;
    private Date dateOfTransaction;
    private String transactionStatus;

    public Transaction() {
    }

    public Transaction(String transactionId, long accountHolderAccount, long beneficiaryAccount, double transactionAmount, String transactionNarration, Date dateOfTransaction, String transactionStatus) {
        this.transactionId = transactionId;
        this.accountHolderAccount = accountHolderAccount;
        this.beneficiaryAccount = beneficiaryAccount;
        this.transactionAmount = transactionAmount;
        this.transactionNarration = transactionNarration;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public long getAccountHolderAccount() {
        return accountHolderAccount;
    }

    public void setAccountHolderAccount(long accountHolderAccount) {
        this.accountHolderAccount = accountHolderAccount;
    }

    public long getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(long beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionNarration() {
        return transactionNarration;
    }

    public void setTransactionNarration(String transactionNarration) {
        this.transactionNarration = transactionNarration;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountHolderAccount=" + accountHolderAccount +
                ", beneficiaryAccount=" + beneficiaryAccount +
                ", transactionAmount=" + transactionAmount +
                ", transactionNarration='" + transactionNarration + '\'' +
                ", dateOfTransaction=" + dateOfTransaction +
                ", transactionStatus='" + transactionStatus + '\'' +
                '}';
    }
}
