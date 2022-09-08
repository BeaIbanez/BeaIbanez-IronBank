package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingServiceImpl implements CheckingService {
    @Override
    public List<Checking> findAll() {
        return null;
    }

    @Override
    public List<Checking> findById(long id) {
        return null;
    }

    @Override
    public List<Checking> findByBalance(Money balance) {
        return null;
    }

    @Override
    public List<Checking> findBySecretKey(String secretKey) {
        return null;
    }

    @Override
    public List<Checking> findByPrimaryOwner(String primaryOwner) {
        return null;
    }

    @Override
    public List<Checking> findByStatus(Status status) {
        return null;
    }

    @Override
    public Checking create(Checking checking) {
        return null;
    }

    @Override
    public Checking changePrimaryOwner(Long id, Checking primaryOwner) {
        return null;
    }

    @Override
    public Checking upDateChecking(Long id, Checking checking) {
        return null;
    }

    @Override
    public void deleteChecking(long id) {

    }

    @Override
    public Checking changeBalance(Long id, Checking balance) {
        return null;
    }
}
