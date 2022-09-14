package com.ironbank.service.accounts;

import com.ironbank.http.requestAccounts.TransferBalanceRequest;
import com.ironbank.model.AccountStatement;
import com.ironbank.model.accounts.*;
import com.ironbank.repositories.accounts.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;

@Service
public class SavingServiceImpl implements SavingService {
    @Autowired
    SavingRepository repository;

    @Override
    public List<Saving> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Saving> findById(long id) {
        return (List<Saving>) repository.findById(id);
    }

    @Override
    public List<Saving> findByBalance(Money balance) {
        return repository.findByBalance(balance);
    }

    @Override
    public List<Saving> findBySecretKey(String secretKey) {
        return repository.findBySecretKey(secretKey);
    }

    @Override
    public List<Saving> findByPrimaryOwner(String primaryOwner) {
        return repository.findByPrimaryOwner(primaryOwner);
    }

    @Override
    public Saving changeBalance(Long id, StudentChecking balance) {
        Saving Saving = (Saving) findById(id);
        var changedName = Saving;
        changedName.setBalance(balance.getBalance());
        return repository.save(changedName);
    }

    @Override
    public List<Saving> findByStatus(Status status) {
        return repository.findByStatus(status);
    }

    @Override
    public Saving create(Saving Saving) {
        return repository.save(Saving);
    }

    @Override
    public Saving changePrimaryOwner(Long id, Saving primaryOwner) {
        Saving Saving = (Saving) findById(id);
        var changedName = Saving;
        changedName.setPrimaryOwner(primaryOwner.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public Saving upDateSaving(Long id, Saving Saving) {
        Saving upDateSaving = (Saving) findById(id);
        var changedName = upDateSaving;
        changedName.setPrimaryOwner(Saving.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public void deleteSaving(long id) {
        Saving SavingDel = new Saving();
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public Saving changeBalance(Long id, Saving balance) {
        Saving Saving = (Saving) findById(id);
        var changedName = Saving;
        changedName.setBalance(balance.getBalance());
        return repository.save(changedName);
    }


    @Override
    public Saving save(Saving Saving) {
        return null;
    }


    @Override
    public Transaction sendMoney(TransferBalanceRequest transferBalanceRequest) {
        return null;
    }

    @Override
    public AccountStatement getStatement(String accountNumber) {
        return null;
    }

    @Override
    public Saving findByAccountNumberEquals(String primaryOwner) {
        return null;
    }
}

