package project.SpendSafe.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpendSafe.exceptions.InsufficientAmountException;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.model.BillPayment;
import project.SpendSafe.model.Transaction;
import project.SpendSafe.model.Wallet;
import project.SpendSafe.repository.*;
import project.SpendSafe.util.GetCurrentLoginUserSessionDetailsIntr;


@Service
public class BillPaymentImpl implements BillPaymentIntr{

    @Autowired
    WalletDao wDao;
    @Autowired
    CustomerDao cDao;
    @Autowired
    BillPayementDao billDao;
    @Autowired
    BankAccountDao bDao;
    @Autowired
    TransactionDao trDao;
    @Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

    @Override
    public BillPayment addBill(String key, BillPayment bill) {
        // TODO Auto-generated method stub
        Wallet w = getCurrentLoginUser.getCurrentUserWallet(key);

        if(w.getBalance()<bill.getAmount()) {
            throw new InsufficientAmountException("Insufficient balance in Wallet");
        }

        bill.setBilldate(LocalDate.now());
        w.setBalance(w.getBalance()-bill.getAmount());
        w.getBilllist().add(bill);
//		wDao.save(w);
        Transaction tr = new Transaction();
        tr.setAmount(bill.getAmount());
        tr.setDescription("Payment Successfull..!");
        tr.setTransactionDate(LocalDate.now());
        tr.setTransactionType(bill.getBilltype());
        tr.setWallet(w);
        w.getTransactions().add(tr);
        trDao.save(tr);
        bill.setWallet(w);
        billDao.save(bill);
        return bill;
    }

    @Override
    public List<BillPayment> billList(String Key) {
        // TODO Auto-generated method stub
        Wallet w = getCurrentLoginUser.getCurrentUserWallet(Key);
        List<BillPayment> billlist = w.getBilllist();
        if(billlist.size()==0) {
            throw new NotFoundException("No BillPaymets in the List ");
        }
        return billlist;
    }


}