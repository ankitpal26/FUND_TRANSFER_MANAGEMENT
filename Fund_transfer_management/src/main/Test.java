package main;

import model.Beneficiary;
import service.AccountHolderService;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
       AccountHolderService service=new AccountHolderService();
        Beneficiary beneficiary= new Beneficiary(4051,390045,"Active",5000,"SBIRAM","shiv@gmail.com",30000);
        int i = service.beneficiaryRegistration(beneficiary);
        System.out.println(i);
    }
    }
