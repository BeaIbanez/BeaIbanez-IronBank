package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.model.users.AccountHolder;

import java.util.List;


public interface SavingService {


    List<Saving> findAll();

    Saving findById(long id);

    List<Saving> findByBalance(Money balance);

    List<Saving> findBySecretKey(String secretKey);

    List<Saving> findByPrimaryOwner(AccountHolder primaryOwner);

    Saving changeBalance(Long id, StudentChecking balance);

    List<Saving> findByStatus(Status status);

    Saving create(Saving saving);

    Saving changePrimaryOwner(Long id, Saving primaryOwner);

    Saving upDateSaving(Long id, Saving saving);

    void delete(long id);

    Saving changeBalance(Long id, Saving balance);

}
