package com.ironbank.service;

import com.ironbank.model.Transaction;
import com.ironbank.model.TransactionType;
import com.ironbank.model.users.Admin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionService {


    List<Transaction> findAll();
    Optional<Transaction> findById(long transferBalanceId);
    List<Transaction> fromAccountNumber(String fromAccountNumber);
    Transaction toAccountNumber(Admin toAccountNumber);
    Transaction amount(BigDecimal amount);
    Transaction transactionType (TransactionType transactionType);


}
