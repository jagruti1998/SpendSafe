package project.SpendSafe.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.SpendSafe.model.Transaction;

@Repository
public interface TransactionSevices {


    public List<Transaction> viewAllTransaction(String key);




}