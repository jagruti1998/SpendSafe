package project.SpendSafe.services;


import project.SpendSafe.model.BankAccount;

import java.util.List;


public interface AccountServicesIntr {


    public BankAccount addAccount(BankAccount bank, String key);

    public List<BankAccount> getAllBankAccounts(String key);

    public BankAccount removeBankAccount(String key,long accountNo) ;

    public BankAccount updateBankAccount(String key,BankAccount bank) ;


}