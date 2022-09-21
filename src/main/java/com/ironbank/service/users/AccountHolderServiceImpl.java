package com.ironbank.service.users;


import com.ironbank.model.users.AccountHolder;

import com.ironbank.model.users.ThirdParty;
import com.ironbank.repositories.users.AccountHolderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

    List<AccountHolder> accountHolders= new ArrayList<AccountHolder>();

    @Autowired
    AccountHolderRepository repository;

    @Override
    public List<AccountHolder> findAll() {
        return repository.findAll();
    }

    @Override
    public AccountHolder findById(long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "AccountHolder with id " + id + "not found."));
    }

    @Override
    public List<AccountHolder> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public AccountHolder create(AccountHolder accountHolder) {
        return repository.save(accountHolder);
    }

    @Override
    public List<AccountHolder> findByDateOfBirth(String birth) {
        return repository.findByDateOfBirth(birth);
    }

    @Override
    public AccountHolder changeName(Long id, AccountHolder name) {
        AccountHolder accountHold = (AccountHolder) findById(id);
        var changedaccountHold = accountHold;
        changedaccountHold.setName(name.getName());
        return repository.save(changedaccountHold);
    }

    @Override
    public AccountHolder upDateAccountHolder(Long id, AccountHolder accountHolder) {
        AccountHolder ac = (AccountHolder) findById(id);
        var changedaAc = ac;
        changedaAc.setName(accountHolder.getName());
        return repository.save(changedaAc);
    }



    @Override
    public void deleteAccountHolder(long id) {
        AccountHolder accountHold = new AccountHolder();
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
