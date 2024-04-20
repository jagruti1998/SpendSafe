package project.SpendSafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.SpendSafe.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    public Optional<Customer> findByMobileNumber(String mobileNumber);


    public Optional<Customer> findByMobileNumberAndPassword(String mobileNumber, String password);





}