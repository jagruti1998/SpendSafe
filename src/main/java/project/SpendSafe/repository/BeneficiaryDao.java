package project.SpendSafe.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import project.SpendSafe.model.Beneficiary;


public interface BeneficiaryDao extends JpaRepository<Beneficiary, Integer> {



    public Optional<Beneficiary> findByMobileNumber(String mobileNumber);

}