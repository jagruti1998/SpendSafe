package project.SpendSafe.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.SpendSafe.exceptions.InvalidAccountException;
import project.SpendSafe.exceptions.UserAlreadyExistWithMobileNumber;
import project.SpendSafe.model.BankAccount;
import project.SpendSafe.model.Wallet;
import project.SpendSafe.repository.BankAccountDao;
import project.SpendSafe.repository.WalletDao;
import project.SpendSafe.util.GetCurrentLoginUserSessionDetailsIntr;


@Component
public class AccountServicesImpl implements AccountServicesIntr {

    @Autowired
    BankAccountDao bDao;

    @Autowired
    WalletDao wDao;


    @Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;


    @Override
    public BankAccount addAccount(BankAccount bank, String key) {

        Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
        List<BankAccount> banks = wallet.getBankaccounts();

        for(BankAccount ibank:banks) {
            if(ibank.getAccountNo()==bank.getAccountNo()) {

                throw new UserAlreadyExistWithMobileNumber("This bank account is already added..");

            }
        }

        banks.add(bank);
        wDao.save(wallet);
        return bank;


    }

    @Override
    public List<BankAccount> getAllBankAccounts(String key){

        Wallet wallet =	getCurrentLoginUser.getCurrentUserWallet(key);

        if(wallet.getBankaccounts().size()==0) {
            throw new InvalidAccountException("No Bank Accounts Added");
        }

        return  wallet.getBankaccounts();

    }


    public BankAccount removeBankAccount(String key,long accountNo) {

        Wallet wallet =	getCurrentLoginUser.getCurrentUserWallet(key);

        List<BankAccount> banks = wallet.getBankaccounts();

        for(BankAccount bank:banks) {
            if(bank.getAccountNo()==accountNo) {

                banks.remove(bank);
                bDao.delete(bank);
                wDao.save(wallet);
                return bank;
            }
        }

        throw new InvalidAccountException("Check Account Number");
    }


    public BankAccount updateBankAccount(String key,BankAccount uBank) {

        Wallet wallet =	getCurrentLoginUser.getCurrentUserWallet(key);

        List<BankAccount> banks = wallet.getBankaccounts();

        for(BankAccount bank:banks) {
            if(bank.getAccountNo()==uBank.getAccountNo()) {

                bank.setAccountNo(uBank.getAccountNo());
                bank.setIfscCode(uBank.getIfscCode());
                bank.setBankname(uBank.getBankname());
                bDao.save(bank);
                return bank;
            }
        }

        throw new InvalidAccountException("Check Account Number");

    }


}