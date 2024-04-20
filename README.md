
# REST API for SpendSafe - An Online Payment Wallet Application

This project focuses on building REST APIs for an online payment wallet application, providing various services to customers. The key features of SpendSafe include robust user validation at every step based on authenticated unique keys for each user, and adherence to a proper architecture-based design, enabling clean and maintainable code.

We've structured the business logic to allow easy access to the current customer at any step, facilitating the implementation of required logic as needed.
<br />

- **Services Offered**
1.User Authentication: Login and Signup functionalities.
2.Wallet Management: Adding money to the wallet from a bank, transferring money to different users, and viewing transaction history.
3.Bill Payments: Paying bills through the application.

- **Backend**
1. Implemented authentication during login and logout using keys.
2. Utilized MySQL for storing data and authentication purposes.


<br />


# Tech Stack

<img align="left" src="https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.png" alt="drawing" width="100"/>
<img align="left"  src="https://download.logo.wine/logo/Spring_Framework/Spring_Framework-Logo.wine.png" alt="drawing" width="100"/>
<img src="https://download.logo.wine/logo/MySQL/MySQL-Logo.wine.png" alt="drawing" width="100"/>


<img align = "left" src="https://www.dariawan.com/media/images/tech-spring-boot.width-1024.png" alt="drawing" width="100"/>
<img align="left"  src="https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png" alt="drawing" width="100"/>
<img  align="left" src="https://miro.medium.com/max/818/1*zc-LgogGtr7fFHF9e1M8wA.png" alt="drawing" width="100"/>

<img src="https://maven.apache.org/images/maven-logo-white-on-black.purevec.svg" alt="drawing" width="100"/>


<img src="https://zooz.github.io/predator/images/restapi.png" alt="drawing" width="100"/>



<br />





# Modules

- Login and Signup Module
- Wallet Module
- Account Module
- Customer Module
- Bill Payment Module
- Transaction Module
- Beneficiary Module
- Bank Account Module


<br />

## User Features
- Users can validate their login credentials.


<br />


## Customer Features
- Customer can login in the application and update their information using their username and password.
- Customer can add account to wallet.
- Customer can delete account from wallet.
- Customer can view account of wallet.
- Customer can view list of all account to wallet.


<br />

## Wallet Features
- User can create new wallet account.
- Track a user’s wallet balance.
- User can add money to  wallet account.
- Allow a user to transfer money to another user/account.
- Keep a history of last N transactions.

<br />


## Bank Accounts Features
- Can add,delete,update Bank Accounts in their wallet
- Can transfer money from Bank Accounts to wallet


<br />

## Bill Payment Features
- Customer can add bill payment.
- Customer can view bill payment.



<br />

## Transaction Features
- Customer can add new transaction.
- Customer can view all transaction.
- Customer can view transaction by date.
- Customer can view lis of all transaction.



<br />

# Installation & Run
 - Before running the API server, ensure you update the database configuration in the application.properties file:

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/walletdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```


# ER Diagram :



![erd_final_walletapp](https://user-images.githubusercontent.com/90818364/185763697-0448e426-d5db-429f-84f6-e5774ebc9491.png)




