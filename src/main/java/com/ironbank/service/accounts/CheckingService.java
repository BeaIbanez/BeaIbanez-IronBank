package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;

import java.util.List;
import java.util.Optional;


public interface CheckingService {



  List<Checking> findAll();

Checking findById(Long id);

  List<Checking> findByBalance(Money balance);

  List<Checking> findBySecretKey(String secretKey);

  List<Checking> findByPrimaryOwner(String primaryOwner);

  List<Checking> findByStatus(Status status);

  Checking create(Checking checking);

  Checking changePrimaryOwner(Long id, Checking primaryOwner);

  Checking upDateChecking(Long id, Checking checking);

  void delete(Long id);

  Checking changeBalance(Long id, Checking balance);



}
