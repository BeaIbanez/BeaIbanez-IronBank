package com.ironbank.repositories;

import com.ironbank.model.Transaction;
import com.ironbank.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    Transaction fromAccountNumber(String fromAccountNumber);

    Transaction toAccountNumber(String toAccountNumber);

    Transaction findByTransactionType(TransactionType transactionType);

    Transaction findByAmount(BigDecimal amount);

    Transaction fromAccountName(String fromAccountName);

    Transaction toAccountName(String toAccountName);
}
