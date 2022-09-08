package com.ironbank.service.users;


import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {
    @Override
    public List<AccountHolder> findAll() {
        return null;
    }

    @Override
    public List<AccountHolder> findById(long id) {
        return null;
    }

    @Override
    public List<AccountHolder> findByName(String name) {
        return null;
    }

    @Override
    public AccountHolder create(AccountHolder admin) {
        return null;
    }

    @Override
    public List<Admin> findByDateOfBirth(String birth) {
        return null;
    }

    @Override
    public AccountHolder changeName(Long id, AccountHolder name) {
        return null;
    }

    @Override
    public AccountHolder upDateAccountHolder(Long id, AccountHolder accountHolder) {
        return null;
    }

    @Override
    public void deleteAccountHolder(long id) {

    }
}
