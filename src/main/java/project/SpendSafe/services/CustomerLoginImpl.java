package project.SpendSafe.services;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.bytebuddy.utility.RandomString;
import project.SpendSafe.exceptions.InvalidPasswordException;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.exceptions.UserAlreadyExistWithMobileNumber;
import project.SpendSafe.model.CurrentUserSession;
import project.SpendSafe.model.Customer;
import project.SpendSafe.model.LoginDTO;
import project.SpendSafe.repository.CustomerDao;
import project.SpendSafe.repository.LogDetailsDao;
import project.SpendSafe.repository.SessionDao;
import project.SpendSafe.util.GetCurrentLoginUserSessionDetailsIntr;

@Service
public class CustomerLoginImpl implements CustomerLogIntr{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private SessionDao sessionDao;
    @Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

    @Autowired
    private LogDetailsDao logDetailsDao;


    @Override
    public String logIntoAccount(LoginDTO customerDTO) {


        Optional<Customer> opt = customerDao.findByMobileNumber(customerDTO.getMobileNumber());


        if(!opt.isPresent()) {
            throw new NotFoundException("Please Enter Valid Mobile Number");
        }

        Customer newCustomer = opt.get();

        Integer customerId = newCustomer.getCustomerId();

        Optional<CurrentUserSession> currentUserOptional = sessionDao.findByCustomerId(customerId);

        if(currentUserOptional.isPresent()) {
            throw new UserAlreadyExistWithMobileNumber("User already logged in with this number");
        }

        if(newCustomer.getPassword().equals(customerDTO.getPassword())) {

            String key = RandomString.make(7);

            CurrentUserSession currentUserSession = new CurrentUserSession(newCustomer.getCustomerId(), key, LocalDateTime.now());
            sessionDao.save(currentUserSession);
            project.SpendSafe.model.LogDetails logD = new project.SpendSafe.model.LogDetails();

            logD.setCid(currentUserSession.getId());
            logD.setLocalDateTime(currentUserSession.getLocalDateTime());
            logD.setLogtype("Log In");
            logD.setUuid(currentUserSession.getUuid());
            logDetailsDao.save(logD);


            return currentUserSession.toString();
        }
        else {
            throw new InvalidPasswordException("Please Enter Valid Password");
        }

    }

    @Override
    public String logOutFromAccount(String key) {


        Optional<CurrentUserSession> currentUserOptional = sessionDao.findByUuid(key);

        if(!currentUserOptional.isPresent()) {
            throw new NotFoundException("User is not logged in with this number");
        }

        CurrentUserSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);

        project.SpendSafe.model.LogDetails logD = new project.SpendSafe.model.LogDetails();

        logD.setCid(currentUserSession.getId());
        logD.setLocalDateTime(currentUserSession.getLocalDateTime().now());
        logD.setLogtype("Log Out");
        logD.setUuid(currentUserSession.getUuid());
        logDetailsDao.save(logD);


        sessionDao.delete(currentUserSession);

        return "Logged Out...";
    }

}