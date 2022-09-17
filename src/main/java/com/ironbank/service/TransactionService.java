package com.ironbank.service;

import com.ironbank.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {


    List<Transaction> findAll();
    Transaction findById(long transferBalanceId);
    Transaction fromAccount(String fromAccount);
    Transaction toAccount(String toAccount);

    //NAME
    Transaction fromAccountName(String fromAccountName);

    Transaction toAccountName(String toAccountName);

    Transaction findByAmount(BigDecimal amount);

    void deleteTransaction(long transferBalanceId);

    Transaction create(Transaction transaction);

    Transaction changeAmount(Long id, Transaction amount);


    Transaction changeFromAccountNumber(Long transferBalanceId, Transaction fromAccountNumber);

    Transaction changeToAccountNumber(Long transferBalanceId, Transaction toAccountNumber);
}
