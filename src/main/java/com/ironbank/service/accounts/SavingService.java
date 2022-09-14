package com.ironbank.service.accounts;

import com.ironbank.http.requestAccounts.TransferBalanceRequest;
import com.ironbank.model.AccountStatement;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;


public interface SavingService {


    List<Saving> findAll();

    List<Saving> findById(long id);

    List<Saving> findByBalance(Money balance);

    List<Saving> findBySecretKey(String secretKey);

    List<Saving> findByPrimaryOwner(String primaryOwner);

    Saving changeBalance(Long id, StudentChecking balance);

    List<Saving> findByStatus(Status status);

    Saving create(Saving saving);

    Saving changePrimaryOwner(Long id, Saving primaryOwner);

    Saving upDateSaving(Long id, Saving saving);

    void deleteSaving(long id);

    Saving changeBalance(Long id, Saving balance);

    Saving save(Saving Saving);

    Transaction sendMoney(TransferBalanceRequest transferBalanceRequest);

    AccountStatement getStatement(String accountNumber);

    Saving findByAccountNumberEquals(String primaryOwner);
}
