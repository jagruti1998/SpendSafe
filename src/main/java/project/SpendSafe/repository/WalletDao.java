package project.SpendSafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.SpendSafe.model.Wallet;


@Repository
public interface WalletDao extends JpaRepository<Wallet, Integer> {



}