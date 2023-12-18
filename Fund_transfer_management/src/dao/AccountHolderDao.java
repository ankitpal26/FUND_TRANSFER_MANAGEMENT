package dao;

import model.AccountHolder;
import model.Beneficiary;
import model.StatementReport;

import java.sql.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class AccountHolderDao {
    public int createAccount(AccountHolder accountHolder) {
        String url = "jdbc:mysql://localhost:3306/fundmanagement";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        int status = 0;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `account_info` VALUES (?, ?, ?, ?,?,?,?)");
            preparedStatement.setInt(1, Math.abs(new Random().nextInt(1000000000)));
            preparedStatement.setString(2, accountHolder.getCustomerName());
            preparedStatement.setInt(3, (int) accountHolder.getAccountNumber());
            preparedStatement.setString(4, accountHolder.getEmailId());
            preparedStatement.setInt(5, (int) accountHolder.getBalance());
            preparedStatement.setString(6, accountHolder.getAddress());
            preparedStatement.setString(7,accountHolder.getPassword());
            status = preparedStatement.executeUpdate();
            System.out.println("Account created successfully!!");
            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public int beneficiaryRegistration(Beneficiary beneficiary) {
        String url = "jdbc:mysql://localhost:3306/fundmanagement";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        int status = 0;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `beneficiary_info` VALUES (?, ?, ?, ?,?,?,?)");
            preparedStatement.setInt(1, beneficiary.getBeneficiaryId());
            preparedStatement.setInt(2, beneficiary.getAccountNumber());
            preparedStatement.setString(3, beneficiary.getIfsc());
            preparedStatement.setInt(4, beneficiary.getCurrentBalance());
            preparedStatement.setString(5, beneficiary.getEmailId());
            preparedStatement.setString(6, beneficiary.getAccountStatus());
            preparedStatement.setDouble(7, beneficiary.getMaximumTransferAmountLimit());
            status = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }



    public int fundTransfer(Beneficiary beneficiary, int transferAmount, String transactionNarration) {
        String url = "jdbc:mysql://localhost:3306/fundmanagement";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        int status = 0;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `transaction_info`(`transaction_id`,`beneficiary_id`,`account_no`,`amount_transfer`,`date`,`transaction_status`,`transaction_narration`) VALUES (?, ?, ?, ?,?,?,?)");
            java.util.Date currentDate = new java.util.Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmm");
            // Format the current date and time into the desired pattern
            String trnId = dateFormat.format(currentDate) + new Random().nextInt(3);
            preparedStatement.setString(1, trnId);
            preparedStatement.setInt(2, beneficiary.getBeneficiaryId());
            preparedStatement.setInt(3, beneficiary.getAccountNumber());
            preparedStatement.setInt(4, transferAmount);
            preparedStatement.setDate(5, new Date(currentDate.getTime()));
            preparedStatement.setString(6, beneficiary.getAccountStatus());
            preparedStatement.setString(7, transactionNarration);
            status = preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public Beneficiary getBeneficiary(int beneficiaryId) {
        Beneficiary beneficiary = new Beneficiary();
        String url = "jdbc:mysql://localhost:3306/fundmanagement";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        int status = 0;


        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM beneficiary_info where beneficiary_id= ?");
            preparedStatement.setInt(1, beneficiaryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                beneficiary.setBeneficiaryId(resultSet.getInt("beneficiary_id"));
                beneficiary.setAccountNumber(resultSet.getInt("account_no"));
                beneficiary.setIfsc(resultSet.getString("ifsc_code"));
                beneficiary.setCurrentBalance(resultSet.getInt("current_balance"));
                beneficiary.setEmailId(resultSet.getString("email_id"));
                beneficiary.setAccountStatus(resultSet.getString("account_status"));
                beneficiary.setMaximumTransferAmountLimit(resultSet.getDouble("maximum_transfer_limit"));
            }

            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return beneficiary;
    }

    public List<Integer> getAllBeneficiaryId() {
        List<Integer> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/fundmanagement";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT beneficiary_id FROM beneficiary_info");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getInt(1));
            }
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<StatementReport> statementReport(int account_no) {
        List<StatementReport> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/fundmanagement";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("select a.customer_name,a.balance,a.customer_name,b.current_balance,t.transaction_id,t.amount_transfer,t.transaction_narration,t.date,t.transaction_status  from account_info a join  beneficiary_info b on a.account_no=b.account_no join transaction_info t on t.account_no=a.account_no where a.account_no=?");
            preparedStatement.setInt(1, account_no);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ((resultSet.next())) {
                StatementReport statementReport = new StatementReport();
                statementReport.setTransactionId(Long.parseLong(resultSet.getString("transaction_id")));
                statementReport.setAccountHolderName(resultSet.getString("customer_name"));
                statementReport.setBeneficiaryName(resultSet.getString("customer_name"));
                statementReport.setTransferredAmount(resultSet.getDouble("amount_transfer"));
                statementReport.setAccountHolderAccountBalance(resultSet.getDouble("balance"));
                statementReport.setBeneficiaryAccountBalance(resultSet.getDouble("current_balance"));
                statementReport.setTransactionNarration(resultSet.getString("transaction_narration"));
                list.add(statementReport);
            }
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public boolean login(String username1, String password1) {
        String url = "jdbc:mysql://localhost:3306/fundmanagement";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        boolean status;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("select password from account_info where email_id=?");
            preparedStatement.setString(1, username1);
            ResultSet resultSet = preparedStatement.executeQuery();
            String pass="";
            while (resultSet.next()){
                pass=resultSet.getString(1);
            }
            if (Objects.equals(pass, password1)) {
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

}
