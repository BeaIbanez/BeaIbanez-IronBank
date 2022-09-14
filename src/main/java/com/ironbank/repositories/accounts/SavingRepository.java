package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingRepository extends JpaRepository<Saving, Long> {



      Saving findById(long id);

    List<Saving> findByBalance(Money balance);

    List<Saving> findBySecretKey(String secretKey);

    List<Saving> findByPrimaryOwner(String primaryOwner);

    List<Saving> findByStatus(Status status);
}
