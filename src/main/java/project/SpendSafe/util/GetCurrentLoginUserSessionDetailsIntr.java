package project.SpendSafe.util;


import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.model.BankAccount;
import project.SpendSafe.model.CurrentUserSession;
import project.SpendSafe.model.Customer;
import project.SpendSafe.model.Wallet;

import java.util.List;


public interface GetCurrentLoginUserSessionDetailsIntr {

    public CurrentUserSession getCurrentUserSession(String key) throws NotFoundException;



    public Customer getCurrentCustomer(String key) throws NotFoundException;

    public Wallet getCurrentUserWallet(String key) throws NotFoundException;

    public List<BankAccount> getCurrentUserBank(String key) throws NotFoundException;
}