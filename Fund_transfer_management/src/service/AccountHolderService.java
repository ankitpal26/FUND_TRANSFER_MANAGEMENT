package service;

import dao.AccountHolderDao;
import model.AccountHolder;
import model.Beneficiary;
import model.StatementReport;

import java.util.List;

public class AccountHolderService {


    public void createAccount(AccountHolder accountHolder){
        AccountHolderDao accountHolderDao= new AccountHolderDao();
        accountHolderDao.createAccount(accountHolder);
    }
    public int beneficiaryRegistration(Beneficiary beneficiary){
        AccountHolderDao accountHolderDao= new AccountHolderDao();
        return accountHolderDao.beneficiaryRegistration(beneficiary);
    }

    public int fundTransfer(Beneficiary beneficiary,int transferAmount,String transactionNarration){
        AccountHolderDao accountHolderDao= new AccountHolderDao();
        return accountHolderDao.fundTransfer(beneficiary, transferAmount,transactionNarration);
    }
    public List<StatementReport> statementReport(int account_no){
        AccountHolderDao accountHolderDao= new AccountHolderDao();
        return accountHolderDao.statementReport(account_no);
    }

    public List<Integer> getAllBeneficiaryId(){
        AccountHolderDao accountHolderDao= new AccountHolderDao();
        return accountHolderDao.getAllBeneficiaryId();
    }

    public Beneficiary getBeneficiary(int beneficiaryId){
        AccountHolderDao accountHolderDao= new AccountHolderDao();
        return accountHolderDao.getBeneficiary(beneficiaryId);
    }

    public  boolean login(String username, String password){
        AccountHolderDao accountHolderDao= new AccountHolderDao();
        return accountHolderDao.login(username, password);
    }
}
