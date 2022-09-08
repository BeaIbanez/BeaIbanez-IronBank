package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Override
    public List<Credit> findAll() {
        return null;
    }

    @Override
    public List<Credit> findById(long id) {
        return null;
    }

    @Override
    public List<Credit> findByBalance(Money balance) {
        return null;
    }

    @Override
    public List<Credit> findBySecretKey(String secretKey) {
        return null;
    }

    @Override
    public List<Credit> findByPrimaryOwner(String primaryOwner) {
        return null;
    }

    @Override
    public List<Credit> findByStatus(Status status) {
        return null;
    }

    @Override
    public Credit create(Credit checking) {
        return null;
    }

    @Override
    public Credit changePrimaryOwner(Long id, Credit primaryOwner) {
        return null;
    }

    @Override
    public Credit changeBalance(Long id, Credit balance) {
        return null;
    }

    @Override
    public Credit upDateCredit(Long id, Credit credit) {
        return null;
    }

    @Override
    public void deleteCredit(long id) {

    }
}
