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

    Credit findById(Long id);

    List<Credit> findByBalance(Money balance);

    List<Credit> findBySecretKey(String secretKey);

    List<Credit> findByPrimaryOwner(String primaryOwner);

    List<Credit> findByStatus(Status status);

    Credit create(Credit checking);

    Credit changePrimaryOwner(Long id, Credit primaryOwner);

    Credit changePrimaryOwner(long id, Credit primaryOwner);

    Credit upDateCredit(long id, Credit Credit);

    void delete(Long id);


    Credit upDateCredit(Long id, Credit credit);


    Credit changeBalance(long id, Credit balance);


}
