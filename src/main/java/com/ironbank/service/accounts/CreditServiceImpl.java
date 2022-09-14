package com.ironbank.service.accounts;

import com.ironbank.http.requestAccounts.TransferBalanceRequest;
import com.ironbank.model.AccountStatement;
import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.repositories.accounts.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {


    @Autowired
    CreditRepository repository;

    @Override
    public List<Credit> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Credit> findById(long id) {
        return (List<Credit>) repository.findById(id);
    }

    @Override
    public List<Credit> findByBalance(Money balance) {
        return repository.findByBalance(balance);
    }

    @Override
    public List<Credit> findBySecretKey(String secretKey) {
        return repository.findBySecretKey(secretKey);
    }

    @Override
    public List<Credit> findByPrimaryOwner(String primaryOwner) {
        return repository.findByPrimaryOwner(primaryOwner);
    }

    @Override
    public List<Credit> findByStatus(Status status) {
        return repository.findByStatus(status);
    }

    @Override
    public Credit create(Credit Credit) {
        return repository.save(Credit);
    }

    @Override
    public Credit changePrimaryOwner(Long id, Credit primaryOwner) {
        Credit Credit = (Credit) findById(id);
        var changedName = Credit;
        changedName.setPrimaryOwner(primaryOwner.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public Credit upDateCredit(Long id, Credit Credit) {
        Credit upDateCredit = (Credit) findById(id);
        var changedName = upDateCredit;
        changedName.setPrimaryOwner(Credit.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public void deleteCredit(long id) {
        Credit CreditDel = new Credit();
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public Credit changeBalance(Long id, Credit balance) {
        Credit Credit = (Credit) findById(id);
        var changedName = Credit;
        changedName.setBalance(balance.getBalance());
        return repository.save(changedName);
    }


    @Override
    public Credit save(Credit Credit) {
        return null;
    }


    @Override
    public Transaction sendMoney(TransferBalanceRequest transferBalanceRequest) {
        return null;
    }

    @Override
    public AccountStatement getStatement(String accountNumber) {
        return null;
    }

    @Override
    public Credit findByAccountNumberEquals(String primaryOwner) {
        return null;
    }
}

