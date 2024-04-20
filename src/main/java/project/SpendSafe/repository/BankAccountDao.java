package project.SpendSafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.SpendSafe.model.BankAccount;


@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Long>{

}