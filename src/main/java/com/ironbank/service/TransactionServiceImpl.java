package com.ironbank.service;

import com.ironbank.model.Transaction;
import com.ironbank.model.TransactionType;
import com.ironbank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository repository;

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Transaction findById(long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Transaction with id " + id + "not found."));
    }
//NUMBER
    @Override
    public Transaction fromAccountNumber(String fromAccountNumber) {
        return repository.fromAccountNumber(fromAccountNumber);
    }

    @Override
    public Transaction toAccountNumber(String toAccountNumber) {
        return repository.toAccountNumber(toAccountNumber);
    }
//NAME
    @Override
    public Transaction fromAccountName(String fromAccountName) {
        return repository.fromAccountName(fromAccountName);
    }

    @Override
    public Transaction toAccountName(String toAccountName) {
        return repository.toAccountName(toAccountName);
    }

    @Override
    public Transaction findByAmount(BigDecimal amount) {
        return repository.findByAmount(amount);
    }

    @Override
    public Transaction findByTransactionType(TransactionType transactionType) {
        return repository.findByTransactionType(transactionType);
    }



    @Override
    public void deleteTransaction(long transferBalanceId) {
        Transaction trans = new Transaction();
        if (repository.existsById(transferBalanceId)) {
            repository.deleteById(transferBalanceId);
        }
    }

    @Override
    public Transaction create(Transaction transaction) {
        System.out.println(transaction);
        var result= repository.save(transaction);
        return result;
    }

    @Override
    public Transaction changeAmount(Long id, Transaction amount) {
        Transaction third = findById(id);
        var changeAmount = third;
        changeAmount.setAmount(amount.getAmount());
        return repository.save(changeAmount);
    }
    @Override
    public Transaction changeFromAccountNumber(Long transferBalanceId, Transaction fromAccountNumber) {
        Transaction trans = findById(transferBalanceId);
        var changeFrom = trans;
        changeFrom.setFromAccountNumber(fromAccountNumber.getFromAccountNumber());
        return repository.save(changeFrom);
    }

    @Override
    public Transaction changeToAccountNumber(Long transferBalanceId, Transaction toAccountNumber) {
        Transaction trans = findById(transferBalanceId);
        var changeTo = trans;
        changeTo.getToAccountNumber();
        return repository.save(changeTo);
    }





}
