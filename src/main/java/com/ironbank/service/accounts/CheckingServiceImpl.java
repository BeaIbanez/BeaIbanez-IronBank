package com.ironbank.service.accounts;


import com.ironbank.model.accounts.*;

import com.ironbank.model.users.AccountHolder;
import com.ironbank.repositories.accounts.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CheckingServiceImpl implements CheckingService {

    @Autowired
    CheckingRepository repository;
    @Autowired
    StudentCheckingService studentCheckingService;

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
    public List<Checking> findByPrimaryOwner(AccountHolder primaryOwner) {
        return repository.findByPrimaryOwner(primaryOwner);
    }

    @Override
    public List<Checking> findByStatus(Status status) {
        return repository.findByStatus(status);
    }

    @Override
    public Account create(Checking checking) {

        var accountHolderDOB= checking.getPrimaryOwner().getDateOfBirth();
        var date= LocalDate.now();
        var difAge= ChronoUnit.YEARS.between(accountHolderDOB, date);

        var studentCheck= new StudentChecking (checking.getBalance(),checking.getSecretKey(),checking.getPrimaryOwner(),checking.getMinimumBalance(),
        checking.getSecondaryOwner(),checking.getPenaltyFee(),checking.getLocalDate(),checking.getStatus(),checking.getFromTransactions(),checking.getToTransactions());

        if(difAge < 24){

                    return studentCheckingService.create(studentCheck);
                }

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


    public List<Checking> findAll(Principal principal) {
        return repository.findByPrimaryOwner((AccountHolder) principal);
    }
}