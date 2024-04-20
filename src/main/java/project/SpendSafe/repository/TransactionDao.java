package project.SpendSafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.SpendSafe.model.Transaction;


@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}