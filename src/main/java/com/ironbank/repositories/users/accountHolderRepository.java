package com.ironbank.repositories.users;

import com.ironbank.model.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface accountHolderRepository extends JpaRepository<AccountHolder, Long> {
}