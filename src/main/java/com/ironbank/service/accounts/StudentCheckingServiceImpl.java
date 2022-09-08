package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCheckingServiceImpl implements StudentCheckingService {
    @Override
    public List<StudentChecking> findAll() {
        return null;
    }

    @Override
    public List<StudentChecking> findById(long id) {
        return null;
    }

    @Override
    public List<StudentChecking> findByBalance(Money balance) {
        return null;
    }

    @Override
    public List<StudentChecking> findBySecretKey(String secretKey) {
        return null;
    }

    @Override
    public List<StudentChecking> findByPrimaryOwner(String primaryOwner) {
        return null;
    }

    @Override
    public List<StudentChecking> findByStatus(Status status) {
        return null;
    }

    @Override
    public StudentChecking create(StudentChecking checking) {
        return null;
    }

    @Override
    public StudentChecking changePrimaryOwner(Long id, StudentChecking primaryOwner) {
        return null;
    }

    @Override
    public StudentChecking upDateStudentChecking(Long id, StudentChecking studentChecking) {
        return null;
    }

    @Override
    public void deleteStudentChecking(long id) {

    }

    @Override
    public StudentChecking changeBalance(Long id, StudentChecking balance) {
        return null;
    }
}
