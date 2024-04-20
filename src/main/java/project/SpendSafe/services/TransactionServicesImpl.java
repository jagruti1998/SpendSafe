package project.SpendSafe.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.model.Transaction;
import project.SpendSafe.model.Wallet;
import project.SpendSafe.repository.TransactionDao;
import project.SpendSafe.repository.WalletDao;
import project.SpendSafe.util.GetCurrentLoginUserSessionDetailsIntr;


@Service
public class TransactionServicesImpl implements TransactionSevices {

    @Autowired
    WalletDao wDao;
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

    @Override
    public List<Transaction> viewAllTransaction(String key) {
        Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);

        List <Transaction>  transactionList = wallet.getTransactions();

        if(transactionList.size() == 0) {
            throw new NotFoundException("No Transaction found");
        }

        return transactionList;
    }









}