package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
}
