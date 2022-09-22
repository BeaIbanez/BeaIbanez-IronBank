package com.ironbank.service.users;

import com.ironbank.model.users.AccountHolder;


import java.security.Principal;
import java.util.List;


public interface AccountHolderService {


    AccountHolder findById(long id);

    List<AccountHolder> findByName(String name);

    AccountHolder create(AccountHolder accountholder);

    List<AccountHolder> findByDateOfBirth(String birth);

    AccountHolder changeName(Long id, AccountHolder name);

    AccountHolder upDateAccountHolder(Long id, AccountHolder accountHolder);

    void deleteAccountHolder(long id);


    List<AccountHolder> findAll();
}
