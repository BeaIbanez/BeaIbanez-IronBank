package com.ironbank.repositories;

import com.ironbank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    Transaction fromAccount(String fromAccount);

    Transaction toAccount(String toAccount);

    Transaction findByAmount(BigDecimal amount);

    Transaction fromAccountName(String fromAccountName);

    Transaction toAccountName(String toAccountName);
}
