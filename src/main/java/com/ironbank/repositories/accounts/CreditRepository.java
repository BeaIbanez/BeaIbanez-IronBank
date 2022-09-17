package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {


      Credit findById(String id);

      List<Credit> findByBalance(Money balance);

      List<Credit> findBySecretKey(String secretKey);

      List<Credit> findByPrimaryOwner(AccountHolder primaryOwner);

      List<Credit> findByStatus(Status status);
      void delete(Credit entity);
}
