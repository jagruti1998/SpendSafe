package project.SpendSafe.services;

import java.util.List;

import org.springframework.stereotype.Service;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.model.Customer;


@Service
public interface CustomerServiceIntr {

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer, String key) throws NotFoundException;

    public Customer deleteCustomer(String key) throws NotFoundException;

    public Customer getCustomerDetails(String key) throws NotFoundException;

    public List<Customer> getCustomerList() throws NotFoundException;



}