package com.ironbank.service.accounts;

import com.ironbank.http.requestAccounts.TransferBalanceRequest;
import com.ironbank.model.AccountStatement;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.model.accounts.Status;
import com.ironbank.repositories.accounts.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;

@Service
public class StudentCheckingServiceImpl implements StudentCheckingService {
    @Autowired
    StudentCheckingRepository repository;

    @Override
    public List<StudentChecking> findAll() {
        return repository.findAll();
    }

    @Override
    public List<StudentChecking> findById(long id) {
        return (List<StudentChecking>) repository.findById(id);
    }

    @Override
    public List<StudentChecking> findByBalance(Money balance) {
        return repository.findByBalance(balance);
    }

    @Override
    public List<StudentChecking> findBySecretKey(String secretKey) {
        return repository.findBySecretKey(secretKey);
    }

    @Override
    public List<StudentChecking> findByPrimaryOwner(String primaryOwner) {
        return repository.findByPrimaryOwner(primaryOwner);
    }



    @Override
    public List<StudentChecking> findByStatus(Status status) {
        return repository.findByStatus(status);
    }

    @Override
    public StudentChecking create(StudentChecking StudentChecking) {
        return repository.save(StudentChecking);
    }

    @Override
    public StudentChecking changePrimaryOwner(Long id, StudentChecking primaryOwner) {
        StudentChecking StudentChecking = (StudentChecking) findById(id);
        var changedName = StudentChecking;
        changedName.setPrimaryOwner(primaryOwner.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public StudentChecking upDateStudentChecking(Long id, StudentChecking StudentChecking) {
        StudentChecking upDateStudentChecking = (StudentChecking) findById(id);
        var changedName = upDateStudentChecking;
        changedName.setPrimaryOwner(StudentChecking.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public void deleteStudentChecking(long id) {
        StudentChecking StudentCheckingDel = new StudentChecking();
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public StudentChecking changeBalance(Long id, StudentChecking balance) {
        StudentChecking StudentChecking = (StudentChecking) findById(id);
        var changedName = StudentChecking;
        changedName.setBalance(balance.getBalance());
        return repository.save(changedName);
    }


    @Override
    public StudentChecking save(StudentChecking StudentChecking) {
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
    public StudentChecking findByAccountNumberEquals(String primaryOwner) {
        return null;
    }
}
