package com.ironbank.service;

import com.ironbank.model.TransactionType;
import com.ironbank.model.users.Admin;
import com.ironbank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transaction;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository repository;

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Transaction> findById(long transferBalanceId) {
              return repository.findById(transferBalanceId);

    }

    @Override
    public List<com.ironbank.model.Transaction> fromAccountNumber(String fromAccountNumber) {
        return repository.fromAccountNumber(fromAccountNumber);
    }

    @Override
    public com.ironbank.model.Transaction toAccountNumber(Admin toAccountNumber) {
        return repository.toAccountNumber(toAccountNumber);
    }

    @Override
    public com.ironbank.model.Transaction amount(BigDecimal amount) {
        return repository.amount(amount);
    }

    @Override
    public com.ironbank.model.Transaction transactionType(TransactionType transactionType) {
        return repository.transactionType(transactionType);
    }



}
