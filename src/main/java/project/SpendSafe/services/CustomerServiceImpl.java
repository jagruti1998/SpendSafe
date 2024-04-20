package project.SpendSafe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.exceptions.UserAlreadyExistWithMobileNumber;
import project.SpendSafe.model.CurrentUserSession;
import project.SpendSafe.model.Customer;
import project.SpendSafe.model.Wallet;
import project.SpendSafe.repository.CustomerDao;
import project.SpendSafe.repository.SessionDao;
import project.SpendSafe.repository.WalletDao;
import project.SpendSafe.util.GetCurrentLoginUserSessionDetailsIntr;


@Service
public class CustomerServiceImpl implements CustomerServiceIntr{

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

    @Autowired
    private WalletDao walletDao;

    @Override
    public Customer createCustomer(Customer customer) {

        Optional<Customer> opt =	customerDao.findByMobileNumber(customer.getMobileNumber());

        if(opt.isPresent()) {
            throw new UserAlreadyExistWithMobileNumber("User already exist with this mobile number..");
        }



        Wallet wallet = new Wallet();
        wallet.setBalance(0);
        wallet.setCustomer(customer);

        customer.setWallet(wallet);

        return customerDao.save(customer);

    }


    @Override
    public Customer updateCustomer(Customer customer, String key) {

        Customer customer2 = getCurrentLoginUser.getCurrentCustomer(key);

        if(customer2 == null) {
            throw new NotFoundException("User not found need to login..");
        }

        customer2.setMobileNumber(customer.getMobileNumber());
        customer2.setName(customer.getName());
        customer2.setPassword(customer.getPassword());
        return customerDao.save(customer2);

    }

    @Override
    public Customer deleteCustomer(String key) {

        Customer customer = getCurrentLoginUser.getCurrentCustomer(key);
        CurrentUserSession currentUserSession =	getCurrentLoginUser.getCurrentUserSession(key);
        customerDao.delete(customer);

        sessionDao.delete(currentUserSession);
        return customer;
    }

    @Override
    public Customer getCustomerDetails(String key) {

        Customer customer = getCurrentLoginUser.getCurrentCustomer(key);
//		System.out.println(customer);
        return customer;
    }


    @Override
    public List<Customer> getCustomerList() throws NotFoundException {
        // TODO Auto-generated method stub

        List<Customer> customers = customerDao.findAll();

        if(customers.size() <= 0) {
            throw new NotFoundException("Customer not found..");
        }
        return customerDao.findAll();


    }

}