package com.ironbank.service.accounts;


import com.ironbank.http.requestAccounts.TransferBalanceRequest;
import com.ironbank.model.AccountStatement;
import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;

import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.repositories.accounts.CheckingRepository;
import com.ironbank.repositories.accounts.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transaction;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingServiceImpl implements CheckingService {

    @Autowired
    CheckingRepository repository;

    @Override
    public List<Checking> findAll() {
        return repository.findAll();
    }

    @Override
    public Checking findById(Long id) {
       return repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Checking with id " + id + "not found."));
    }

    @Override
    public List<Checking> findByBalance(Money balance) {
        return repository.findByBalance(balance);
    }

    @Override
    public List<Checking> findBySecretKey(String secretKey) {
        return repository.findBySecretKey(secretKey);
    }

    @Override
    public List<Checking> findByPrimaryOwner(String primaryOwner) {
        return repository.findByPrimaryOwner(primaryOwner);
    }

    @Override
    public List<Checking> findByStatus(Status status) {
        return repository.findByStatus(status);
    }

    @Override
    public Checking create(Checking checking) {
        return repository.save(checking);
    }

    @Override
    public Checking changePrimaryOwner(Long id, Checking primaryOwner) {
        Checking checking = (Checking) findById(id);
        var changedName = checking;
        changedName.setPrimaryOwner(primaryOwner.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public Checking upDateChecking(Long id, Checking checking) {
        Checking upDateChecking =  findById(id);
        var changedName = upDateChecking;
        changedName.setPrimaryOwner(checking.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public void delete(Long id) {
        Checking checkingDel = new Checking();
        if (repository.existsById(id)); {
            repository.deleteById(id);
        }
    }

    @Override
    public Checking changeBalance(Long id, Checking balance) {
        Checking checking = (Checking) findById(id);
        var changedName = checking;
        changedName.setBalance(balance.getBalance());
        return repository.save(changedName);
    }



}