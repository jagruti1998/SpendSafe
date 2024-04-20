package project.SpendSafe.controllers;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.SpendSafe.model.BankAccount;
import project.SpendSafe.model.Beneficiary;
import project.SpendSafe.model.Customer;
import project.SpendSafe.model.LoginDTO;
import project.SpendSafe.services.*;


@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceIntr customerServiceImpl;

    @Autowired
    AccountServicesIntr accountServicesIntr;

    @Autowired
    private WalletServices wService;

    @Autowired
    private BeneficiaryIntr bService;

    @Autowired
    private TransactionSevices trServices;

    @Autowired
    private BillPaymentImpl billservice;

    @Autowired
    private CustomerLoginImpl customerLogin;

    // for user Login
    @PostMapping(value = "customer/login")
    public ResponseEntity<String> logInCustomer(@Valid @RequestBody LoginDTO customerDTO) {
        String s = customerLogin.logIntoAccount(customerDTO);
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }

    // for user Logout
    @PostMapping(value = "customer/logout")
    public ResponseEntity<String> logOutCustomer(@RequestParam(required = false) String key) {
        String s = customerLogin.logOutFromAccount(key);
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }



    // to register user
    @PostMapping(value = "/customer")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {

        Customer custmer = customerServiceImpl.createCustomer(customer);

        return new ResponseEntity<Customer>(custmer, HttpStatus.CREATED);
    }

    // To update existing user details by passing its login key
    @PutMapping(value = "/customer")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,
                                                   @RequestParam(required = false) String key) {
        Customer fetched_customer = customerServiceImpl.updateCustomer(customer, key);

        return new ResponseEntity<Customer>(fetched_customer, HttpStatus.ACCEPTED);
    }


    // To delete existing user details by passing its login key
    @DeleteMapping(value = "/customer")
    public ResponseEntity<Customer> deleteCustomer(@RequestParam(required = false) String key) {
        Customer deleted_customer = customerServiceImpl.deleteCustomer(key);

        return new ResponseEntity<Customer>(deleted_customer, HttpStatus.ACCEPTED);
    }



    @PostMapping("/addaccount")
    public ResponseEntity<BankAccount> AccountHandler(@RequestBody  BankAccount bank, @RequestParam String key) {

        BankAccount b = accountServicesIntr.addAccount(bank, key);

        return new ResponseEntity<BankAccount>(b,HttpStatus.ACCEPTED);


    }


    // delete bank account
    @DeleteMapping("/accounts")
    public ResponseEntity<BankAccount> removeBankAccountHandler(@RequestParam String key,@RequestParam long accountNo ) {

        BankAccount b = accountServicesIntr.removeBankAccount(key, accountNo);
        return new ResponseEntity<BankAccount>(b,HttpStatus.ACCEPTED);
    }

    // update bank account
    @PutMapping("/updateaccount")
    public ResponseEntity<BankAccount> updateAccountHandler(@RequestBody  BankAccount bank, @RequestParam String key) {

        BankAccount b = accountServicesIntr.updateBankAccount(key,bank);

        return new ResponseEntity<BankAccount>(b,HttpStatus.ACCEPTED);

    }



    // add beneficiary
    @PostMapping("/addbenificiary")
    public ResponseEntity<Beneficiary> addBenificiaryHandler(@Valid @RequestBody Beneficiary benificiary, @RequestParam String key) {

        Beneficiary b = bService.addBenificiary(benificiary, key);
        return new ResponseEntity<Beneficiary>(b,HttpStatus.CREATED);

    }




}