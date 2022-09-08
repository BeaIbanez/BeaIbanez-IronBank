package com.ironbank.service.users;

import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountHolderService {

    List<AccountHolder> findAll();

    List<AccountHolder> findById(long id);

    List<AccountHolder> findByName(String name);

    AccountHolder create(AccountHolder admin);

    List<Admin> findByDateOfBirth(String birth);

    AccountHolder changeName(Long id, AccountHolder name);

    AccountHolder upDateAccountHolder(Long id, AccountHolder accountHolder);

    void deleteAccountHolder(long id);


}
