package project.SpendSafe.services;

import java.util.List;

import org.springframework.stereotype.Service;
import project.SpendSafe.model.BillPayment;

@Service
public interface BillPaymentIntr {

    public BillPayment addBill(String key, BillPayment bill);

    public List<BillPayment> billList(String Key);
}