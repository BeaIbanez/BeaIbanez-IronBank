package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {


      Credit findById(long id);

      List<Credit> findByBalance(Money balance);

      List<Credit> findBySecretKey(String secretKey);

      List<Credit> findByPrimaryOwner(String primaryOwner);

      List<Credit> findByStatus(Status status);
}
