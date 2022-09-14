package com.ironbank.repositories;

import com.ironbank.model.TransactionType;
import com.ironbank.model.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transaction;
import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    List<com.ironbank.model.Transaction> fromAccountNumber(String fromAccountNumber);

    com.ironbank.model.Transaction toAccountNumber(Admin toAccountNumber);

    com.ironbank.model.Transaction amount(BigDecimal amount);

    com.ironbank.model.Transaction transactionType(TransactionType transactionType);
}
