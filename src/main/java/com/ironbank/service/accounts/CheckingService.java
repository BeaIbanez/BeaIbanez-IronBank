package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CheckingService {

    List<Checking> findAll();

    List<Checking> findById(long id);

    List<Checking> findByBalance(Money balance);

    List<Checking> findBySecretKey(String secretKey);

    List<Checking> findByPrimaryOwner(String primaryOwner);

    List<Checking> findByStatus(Status status);

    Checking create(Checking checking);

    Checking changePrimaryOwner(Long id, Checking primaryOwner);

    Checking upDateChecking(Long id, Checking checking);

    void deleteChecking(long id);

    Checking changeBalance(Long id, Checking balance);
}
