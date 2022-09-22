## Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Installation](#installation)
4. [Collaboration](#collaboration)

### General Info
***

<h1 >IronBank - Final Project Ironhack - Bea Ibañez </h1>
<p>Is a project that is differentiated first by users and second by bank accounts. Users are divided into AccountHolders, Admins, and ThirdParties and accounts into CheckingAccount, SavingAccount, CreditAccount, and StudentCheckingAccounts.</p>

<h3><u>INTRO</u> --> </h3>

Each account and user has some requirements.<br><br>
The admins:
<ul>
<l1>- They can access all balances </l1><br>
<l1> - ThirdParty users can join the database </l1><br>
<l1> - You can create new accounts</l1><br>
</ul>

The AccountHolders:
<ul>
<l1>- Can  view the balance of their own accounts </l1><br>
<l1> - Should be able to transfer money from any of their accounts to any other account </l1><br>
<l1> - To receive and send money, Third-Party Users must provide their hashed key </l1><br>


</ul>
The ThirdParties:
<ul>
<l1>- There is a way for third-party users to receive and send money to other accounts. </l1><br>
<l1> -  should be able to transfer money from any of their accounts to any other account </l1><br>
</ul>

Obviously each account must have a diferents requirements; interestRate, a minimumBalance and CreditLimit

SavingAccounts:
<ul>
<l1>- InterestRate --> 0.0025 / Maximum Interest -->0.5 </l1><br>
<l1> - MinimumBalance --> 1000 /Not lower than 100 </l1><br>
</ul>

CreditAccounts:
<ul>
<l1>- CreditLimit minimum --> 100 / Maximum creditLimit -->100000 </l1><br>
<l1> -  InterestRate --> 0.2 / Not lower than 0.1  </l1><br>
</ul>

CheckingAccounts:
<ul>
<l1>- If the primaryOwner is less than 24, should be createn a studentChecking, if is more than 24 years, must created a CheckingAccount </l1><br>
<l1> - MinimumBalance --> 250 /Not lower than 12 </l1><br>
</ul>


## Technologies
***
A list of technologies used within the project:
* Java Versión 18.0
* SpringBoot
* * spring-boot-starter-data-jdbc
* * spring-boot-maven-plugin
* * spring-boot-starter-data-jpa
* * spring-boot-starter-security
* * spring-boot-starter-web
* * spring-boot-starter-test
* MySQL
* * mysql-connector-java
* Lombok - lombok
* KeyCloak
* * KeyCloak-admin-client
* * keycloak-spring-boot-starter



## Installation
***
For the development of the project, the programs have been required; IntelliJ, KeyCloak and Postman.


## Collaboration
***

The main worker has been Bea Ibañez with the exquisite support of Salvatore, Lisa and Jorge