package project.SpendSafe.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpendSafe.exceptions.NotFoundException;
import project.SpendSafe.repository.LogDetailsDao;
import project.SpendSafe.util.GetCurrentLoginUserSessionDetailsIntr;


@Service
public class LogDetailsImpl implements LogDetails{

    @Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentUserSessionDetails;

    @Autowired
    private LogDetailsDao logDetails;


    @Override
    public List<project.SpendSafe.model.LogDetails> logDetailsList() {

        List<project.SpendSafe.model.LogDetails> list = logDetails.findAll();

        System.out.println(list.size());

        if(list.size()==0 ) {
            throw new NotFoundException("Log details not found..");
        }

        return list;

    }

}