package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {


      List<Checking> findByBalance(Money balance);

      List<Checking> findBySecretKey(String secretKey);

      List<Checking> findByPrimaryOwner(String primaryOwner);

      List<Checking> findByStatus(Status status);


      void delete(Checking entity);
}
