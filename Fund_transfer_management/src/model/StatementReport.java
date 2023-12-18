package model;

public class StatementReport {
    private long transactionId;
    private String accountHolderName;
    private String beneficiaryName;
    private double transferredAmount;
    private double accountHolderAccountBalance;
    private double beneficiaryAccountBalance;
    private String transactionNarration;

    public StatementReport() {
    }

    public StatementReport(long transactionId, String accountHolderName, String beneficiaryName, double transferredAmount, double accountHolderAccountBalance, double beneficiaryAccountBalance, String transactionNarration) {
        this.transactionId = transactionId;
        this.accountHolderName = accountHolderName;
        this.beneficiaryName = beneficiaryName;
        this.transferredAmount = transferredAmount;
        this.accountHolderAccountBalance = accountHolderAccountBalance;
        this.beneficiaryAccountBalance = beneficiaryAccountBalance;
        this.transactionNarration = transactionNarration;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public double getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(double transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public double getAccountHolderAccountBalance() {
        return accountHolderAccountBalance;
    }

    public void setAccountHolderAccountBalance(double accountHolderAccountBalance) {
        this.accountHolderAccountBalance = accountHolderAccountBalance;
    }

    public double getBeneficiaryAccountBalance() {
        return beneficiaryAccountBalance;
    }

    public void setBeneficiaryAccountBalance(double beneficiaryAccountBalance) {
        this.beneficiaryAccountBalance = beneficiaryAccountBalance;
    }

    public String getTransactionNarration() {
        return transactionNarration;
    }

    public void setTransactionNarration(String transactionNarration) {
        this.transactionNarration = transactionNarration;
    }

    @Override
    public String toString() {
        return
                "transactionId=" + transactionId +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", transferredAmount=" + transferredAmount +
                ", accountHolderAccountBalance=" + accountHolderAccountBalance +
                ", beneficiaryAccountBalance=" + beneficiaryAccountBalance +
                ", transactionNarration='" + transactionNarration + '\''
                ;
    }
}
