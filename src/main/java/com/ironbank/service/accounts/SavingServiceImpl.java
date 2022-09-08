package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingServiceImpl implements SavingService {
    @Override
    public List<Saving> findAll() {
        return null;
    }

    @Override
    public List<Saving> findById(long id) {
        return null;
    }

    @Override
    public List<Saving> findByBalance(Money balance) {
        return null;
    }

    @Override
    public List<Saving> findBySecretKey(String secretKey) {
        return null;
    }

    @Override
    public List<Saving> findByPrimaryOwner(String primaryOwner) {
        return null;
    }

    @Override
    public Saving changeBalance(Long id, StudentChecking balance) {
        return null;
    }

    @Override
    public List<Saving> findByStatus(Status status) {
        return null;
    }

    @Override
    public Saving create(Saving saving) {
        return null;
    }

    @Override
    public Saving changePrimaryOwner(Long id, Saving primaryOwner) {
        return null;
    }

    @Override
    public Saving upDateSaving(Long id, Saving saving) {
        return null;
    }

    @Override
    public void deleteSaving(long id) {

    }
}
