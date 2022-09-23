package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.repositories.accounts.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public StudentChecking findById(long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "StudentCheking with id " + id + "not found."));
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
    public List<StudentChecking> findByPrimaryOwner(AccountHolder primaryOwner) {
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
    public void delete(Long id) {
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


}
