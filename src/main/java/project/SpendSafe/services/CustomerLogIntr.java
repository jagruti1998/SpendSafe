package project.SpendSafe.services;


import project.SpendSafe.model.LoginDTO;

public interface CustomerLogIntr {

    public String logIntoAccount(LoginDTO customerDTO);

    public String logOutFromAccount(String key);

}