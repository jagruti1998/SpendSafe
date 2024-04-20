package project.SpendSafe.util;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpendSafe.model.CurrentUserSession;
import project.SpendSafe.model.Customer;
import project.SpendSafe.repository.CustomerDao;
import project.SpendSafe.repository.SessionDao;


@Service
public class getCurrentLoginUserSessionDetails {


    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private CustomerDao customerDao;

    public CurrentUserSession getCurrentUserSession(String key) {
        Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);

        return optional.get();
    }

    public Integer getCurrentUserSessionId(String key) {
        Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);

        return optional.get().getId();
    }

    public Customer getCurrentCustomer(String key) {

        Optional<CurrentUserSession> optional = sessionDao.findByUuid(key);

        Integer customerId = optional.get().getCustomerId();

        return  customerDao.getById(customerId);
    }
}