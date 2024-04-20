package project.SpendSafe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.exceptions.UserAlreadyExistWithMobileNumber;
import project.SpendSafe.model.Beneficiary;
import project.SpendSafe.model.Wallet;
import project.SpendSafe.repository.BankAccountDao;
import project.SpendSafe.repository.BeneficiaryDao;
import project.SpendSafe.repository.CustomerDao;
import project.SpendSafe.repository.WalletDao;
import project.SpendSafe.util.GetCurrentLoginUserSessionDetailsIntr;


@Component
public class BenificiaryImpl implements BeneficiaryIntr {


    @Autowired
    WalletDao wDao;
    @Autowired
    CustomerDao cDao;
    @Autowired
    BankAccountDao bDao;

    @Autowired
    BeneficiaryDao bfDao;


    @Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

    @Override
    public Beneficiary addBenificiary(Beneficiary benificary, String key) {

        Optional<Beneficiary> optBenificiary = bfDao.findByMobileNumber(benificary.getMobileNumber());
        if(optBenificiary.isPresent()) {
            throw new UserAlreadyExistWithMobileNumber("Benificiary already added..");
        }

        Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);

        wallet.getBenificiaryList().add(benificary);
        benificary.setWallet(wallet);
        bfDao.save(benificary);


        // TODO Auto-generated method stub
        return benificary;
    }



    @Override
    public List<Beneficiary> viewAllBenificiary(String key) {

        Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);

        List<Beneficiary> bfList = wallet.getBenificiaryList();
        if( bfList.size()<=0 )
            throw new NotFoundException("Benificiaries details not found..");
        return bfList;
    }




}