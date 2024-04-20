package project.SpendSafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.SpendSafe.model.BillPayment;


@Repository
public interface BillPayementDao extends JpaRepository<BillPayment, Integer> {

}