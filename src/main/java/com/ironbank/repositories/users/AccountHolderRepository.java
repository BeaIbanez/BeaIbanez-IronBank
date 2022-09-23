package com.ironbank.repositories.users;

import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    List<AccountHolder> findByName(String name);

    List<AccountHolder> findByDateOfBirth(String birth);
}
