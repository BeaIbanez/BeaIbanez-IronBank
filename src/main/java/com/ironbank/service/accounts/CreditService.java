package com.ironbank.service.accounts;

import com.ironbank.http.requestAccounts.TransferBalanceRequest;
import com.ironbank.model.AccountStatement;
import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;


public interface CreditService {

    List<Credit> findAll();

    List<Credit> findById(long id);

    List<Credit> findByBalance(Money balance);

    List<Credit> findBySecretKey(String secretKey);

    List<Credit> findByPrimaryOwner(String primaryOwner);

    List<Credit> findByStatus(Status status);

    Credit create(Credit checking);

    Credit changePrimaryOwner(Long id, Credit primaryOwner);
    Credit changeBalance(Long id, Credit balance);

    Credit upDateCredit(Long id, Credit credit);

    void deleteCredit(long id);


    Credit save(Credit Credit);

    Transaction sendMoney(TransferBalanceRequest transferBalanceRequest);

    AccountStatement getStatement(String accountNumber);

    Credit findByAccountNumberEquals(String primaryOwner);
}
