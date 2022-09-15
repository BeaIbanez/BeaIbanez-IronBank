package com.ironbank.service;

import com.ironbank.model.Transaction;
import com.ironbank.model.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {


    List<Transaction> findAll();
    Transaction findById(long transferBalanceId);
    Transaction fromAccountNumber(String fromAccountNumber);
    Transaction toAccountNumber(String toAccountNumber);

    //NAME
    Transaction fromAccountName(String fromAccountName);

    Transaction toAccountName(String toAccountName);

    Transaction findByAmount(BigDecimal amount);
    Transaction findByTransactionType (TransactionType transactionType);


    void deleteTransaction(long transferBalanceId);

    Transaction create(Transaction transaction);

    Transaction changeAmount(Long id, Transaction amount);


    Transaction changeFromAccountNumber(Long transferBalanceId, Transaction fromAccountNumber);

    Transaction changeToAccountNumber(Long transferBalanceId, Transaction toAccountNumber);
}
