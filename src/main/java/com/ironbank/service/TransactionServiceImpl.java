package com.ironbank.service;

import com.ironbank.model.Transaction;
import com.ironbank.model.accounts.Account;
import com.ironbank.model.accounts.Money;
import com.ironbank.repositories.TransactionRepository;
import com.ironbank.repositories.accounts.AccountRepository;
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
    @Autowired
    AccountRepository accountRepository;

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

    @Override
    public Transaction fromAccount(String fromAccount) {
        return repository.fromAccount(fromAccount);
    }

    @Override
    public Transaction toAccount(String toAccount) {
        return repository.toAccount(toAccount);
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
    public void deleteTransaction(long transferBalanceId) {
        Transaction trans = new Transaction();
        if (repository.existsById(transferBalanceId)) {
            repository.deleteById(transferBalanceId);
        }
    }

    @Override
    public Transaction create(Transaction transaction) {

        validationAndProcess(transaction);
        //TODO que las cuentas no esten FROZEN
        return repository.save(transaction);
    }

    //VALIDATION IF NOT HAVE ENOUGH MONEY
    private void validationAndProcess(Transaction transaction) {
        var fromAccount = transaction.getFromAccount();
        var toAccount = transaction.getToAccount();
        if (fromAccount.getBalance().getAmount().compareTo(transaction.getAmount()) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Not have enough Money for the transaction");
        } else {
            var fromBalance = fromAccount.getBalance().getAmount().subtract(transaction.getAmount());
            fromAccount.setBalance(new Money((fromBalance), fromAccount.getBalance().getCurrency()));

            var toBalance = toAccount.getBalance().getAmount().add(transaction.getAmount());
            toAccount.setBalance(new Money((toBalance), toAccount.getBalance().getCurrency()));

            if (toAccount.getBalance().getAmount().compareTo(toAccount.getMinimumBalance().getAmount()) < 0) {
                applyPenaltyFee(toAccount);
            }

            if (fromAccount.getBalance().getAmount().compareTo(fromAccount.getMinimumBalance().getAmount()) < 0) {
                applyPenaltyFee(fromAccount);
            }
            accountRepository.saveAll(List.of(fromAccount, toAccount));

        }
    }

    private void applyPenaltyFee(Account account) {
        account.setBalance(new Money((account.getBalance().getAmount().subtract(new BigDecimal(40))), account.getBalance().getCurrency()));

    }


    @Override
    public Transaction changeAmount(Long id, Transaction amount) {
        Transaction third = findById(id);
        var changeAmount = third;
        changeAmount.setAmount(amount.getAmount());
        return repository.save(changeAmount);
    }

    @Override
    public Transaction changeFromAccountNumber(Long transferBalanceId, Transaction fromAccount) {
        Transaction trans = findById(transferBalanceId);
        var changeFrom = trans;
        changeFrom.setFromAccount(fromAccount.getFromAccount());
        return repository.save(changeFrom);
    }

    @Override
    public Transaction changeToAccountNumber(Long transferBalanceId, Transaction toAccountNumber) {
        Transaction trans = findById(transferBalanceId);
        var changeTo = trans;
        changeTo.getToAccount();
        return repository.save(changeTo);
    }

}

