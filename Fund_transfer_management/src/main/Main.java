package main;

import model.AccountHolder;
import model.Beneficiary;
import model.StatementReport;
import service.AccountHolderService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fund Transfer Management");
        System.out.println("------------------------");
        System.out.println("Press 0: Login ");
        System.out.println("Press 1: Account Registration");
        Scanner sc1=new Scanner(System.in);
        int choice=sc1.nextInt();
         switch (choice ){
             case 0:
                 System.out.println("Enter the username/emailId");
                 String userName = sc1.next();
                 System.out.println("Enter the password");
                 String password= sc1.next();
                 boolean status = login(userName, password);
                 if (status){
                     System.out.println("Login Successfully!!");
                     System.out.println("Choose the task which you want to perform");
                     System.out.println("Press 1 for Beneficiary Registration");
                     System.out.println("Press 2 for Fund Transfer");
                     System.out.println("Press 3 for taking Account Statement");
                     System.out.println("Press 0 for Exit");
                     System.out.println("-------------------------------------");
                     Scanner sc = new Scanner(System.in);
                     int i = sc.nextInt();
                     switch (i) {
                         case 1:
                             beneficiaryRegistration();
                             break;
                         case 2:
                             fundTransfer();
                             break;
                         case 3:
                             getStatement();
                             break;
                         default:
                             System.out.println("-----------------Thank You---------------");
                     }
                 }else {
                     System.out.println("Invalid User ??");
                 }
                 break;
             case 1:
                 createAccount();
                 break;
             default:
                 System.out.println("Please choose the right choice!!");
         }
         }


    public static boolean login(String username, String password){
        AccountHolderService accountHolderService=new AccountHolderService();
        return accountHolderService.login(username, password);
    }

    public static void createAccount() {
        System.out.println("Enter account Holder Details");
        System.out.println("-------------------------");
        System.out.println("Enter account holder name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Enter your account number");
        int accountNo = input.nextInt();
        input.nextLine();
        System.out.println("Enter your email id");
        String email = input.nextLine();
        System.out.println("Enter your balance");
        double Balance = input.nextDouble();
        input.nextLine();
        System.out.println("Enter your address");
        String address=input.nextLine();
        System.out.println("Enter the password");
        String password = input.nextLine();
        AccountHolder accountHolder=new AccountHolder(accountNo,name,email,Balance,address, password);
        AccountHolderService accountHolderService= new AccountHolderService();
        accountHolderService.createAccount(accountHolder);

    }

    public static void beneficiaryRegistration() {
        System.out.println("Enter beneficiary details ");
        System.out.println("--------------------------");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter beneficiary id");
        int beneficiaryId = sc.nextInt();
        System.out.println("Enter beneficiary account number");
        int beneficiaryAccNo = sc.nextInt();
        System.out.println("Enter bank IFSC CODE ");
        String ifsc = sc.next();
        System.out.println("Enter current balance of beneficiary");
        int currentBalance = sc.nextInt();
        System.out.println("Enter beneficiary email id");
        String email = sc.next();
        System.out.println("Enter account status ");
        String status = sc.next();
        System.out.println("Enter maximum transfer limit");
        double maxiTransLimit = sc.nextDouble();

       Beneficiary beneficiary=new Beneficiary();
       beneficiary.setBeneficiaryId(beneficiaryId);
       beneficiary.setAccountNumber(beneficiaryAccNo);
       beneficiary.setCurrentBalance(currentBalance);
       beneficiary.setIfsc(ifsc);
       beneficiary.setMaximumTransferAmountLimit(maxiTransLimit);
       beneficiary.setEmailId(email);
       beneficiary.setAccountStatus(status);
        AccountHolderService accountHolderService = new AccountHolderService();
        int i = accountHolderService.beneficiaryRegistration(beneficiary);
        if (i==1){
            System.out.println("Beneficiary Registration Successful !!");
        }else {
            System.out.println("Beneficiary Registration failed?");
        }
    }

    public static void fundTransfer() {
        Scanner sc=new Scanner(System.in);
        AccountHolderService service= new AccountHolderService();
        System.out.println(" fund transfer provide");
        System.out.println("----------------------------");
        System.out.println("Select beneficiary");
        List<Integer> allBeneficiaryId = service.getAllBeneficiaryId();
        allBeneficiaryId.forEach(System.out::println);
        System.out.println("Enter above one beneficiary id");
        int beneficiaryId = sc.nextInt();
        System.out.println("Enter transfer amount");
        int transferAmount = sc.nextInt();
        System.out.println("Enter transaction Narration");
        String narration = sc.next();

        Beneficiary beneficiary = service.getBeneficiary(beneficiaryId);

        int status = service.fundTransfer(beneficiary, transferAmount,narration);
        if (status==1){
            System.out.println("Fund transfer successfully!!");
        }else {
            System.out.println("Fund transfer failed");
        }
    }

    public static void getStatement(){
        System.out.println("Statement Report");
        System.out.println("------------------");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter account number");
        int account_no = sc.nextInt();
        AccountHolderService service = new AccountHolderService();
        List<StatementReport> list = service.statementReport(account_no);
        list.forEach(System.out::println);

    }

}
