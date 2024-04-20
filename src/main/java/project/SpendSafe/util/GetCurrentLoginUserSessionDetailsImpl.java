package project.SpendSafe.util;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.model.BankAccount;
import project.SpendSafe.model.CurrentUserSession;
import project.SpendSafe.model.Customer;
import project.SpendSafe.model.Wallet;
import project.SpendSafe.repository.CustomerDao;
import project.SpendSafe.repository.SessionDao;


@Service
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetailsIntr{

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private CustomerDao customerDao;

    public CurrentUserSession getCurrentUserSession(String key) {
        Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);

        if(!optional.isPresent()) {
            throw new NotFoundException("Unauthorized Key");
        }

        return optional.get();
    }



    public Customer getCurrentCustomer(String key) {
        Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);

        if(!optional.isPresent()) {
            throw new NotFoundException("Unauthorized Key");
        }

        Integer customerId = optional.get().getCustomerId();

        return  customerDao.getById(customerId);
    }

    public Wallet getCurrentUserWallet(String key) {
        Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);

        if(!optional.isPresent()) {
            throw new NotFoundException("Unauthorized Key");
        }

        Integer customerId = optional.get().getCustomerId();
        Customer customer = customerDao.getById(customerId);

        Wallet wallet = customer.getWallet();

        return wallet;
    }

    public List<BankAccount> getCurrentUserBank(String key) {

        Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);

        if(!optional.isPresent()) {
            throw new NotFoundException("Unauthorized Key");
        }

        Integer customerId = optional.get().getCustomerId();
        Customer customer = customerDao.getById(customerId);

        List<BankAccount> bank = customer.getWallet().getBankaccounts();

        return bank;
    }






}