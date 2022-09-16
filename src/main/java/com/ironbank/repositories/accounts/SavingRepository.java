package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingRepository extends JpaRepository<Saving, Long> {



      Saving findById(String id);

    List<Saving> findByBalance(Money balance);

    List<Saving> findBySecretKey(String secretKey);

    List<Saving> findByPrimaryOwner(String primaryOwner);

    List<Saving> findByStatus(Status status);
    void delete(Saving entity);
}
