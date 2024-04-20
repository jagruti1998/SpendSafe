package project.SpendSafe.services;



import java.util.List;

import org.springframework.stereotype.Service;
import project.SpendSafe.model.Beneficiary;


@Service
public interface BeneficiaryIntr {


    public Beneficiary addBenificiary(Beneficiary benificary, String key);



    public List<Beneficiary> viewAllBenificiary(String key);




}