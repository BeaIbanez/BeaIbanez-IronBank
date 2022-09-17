package com.ironbank.service.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.model.users.AccountHolder;

import java.util.List;


public interface StudentCheckingService {


    List<StudentChecking> findAll();

    StudentChecking findById(long id);

    List<StudentChecking> findByBalance(Money balance);

    List<StudentChecking> findBySecretKey(String secretKey);

    List<StudentChecking> findByPrimaryOwner(AccountHolder primaryOwner);

    List<StudentChecking> findByStatus(Status status);

    StudentChecking create(StudentChecking checking);

    StudentChecking changePrimaryOwner(Long id, StudentChecking primaryOwner);

    StudentChecking upDateStudentChecking(Long id, StudentChecking studentChecking);


    void delete(Long id);

    StudentChecking changeBalance(Long id, StudentChecking balance);


}
