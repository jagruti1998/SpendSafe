package project.SpendSafe.services;

import java.util.List;

import org.springframework.stereotype.Service;
import project.SpendSafe.exceptions.InvalidAccountException;
import project.SpendSafe.model.Customer;


@Service
public interface UserService {

    public Customer validLogin(String mobileNumber, String password) throws InvalidAccountException;

    public List<Customer> getList();

    public Customer updateCustomer(Customer customer);
}