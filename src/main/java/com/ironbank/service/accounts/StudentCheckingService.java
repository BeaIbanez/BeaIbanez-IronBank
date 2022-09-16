package com.ironbank.service.accounts;

import com.ironbank.http.requestAccounts.TransferBalanceRequest;
import com.ironbank.model.AccountStatement;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;


public interface StudentCheckingService {


    List<StudentChecking> findAll();

    StudentChecking findById(long id);

    List<StudentChecking> findByBalance(Money balance);

    List<StudentChecking> findBySecretKey(String secretKey);

    List<StudentChecking> findByPrimaryOwner(String primaryOwner);

    List<StudentChecking> findByStatus(Status status);

    StudentChecking create(StudentChecking checking);

    StudentChecking changePrimaryOwner(Long id, StudentChecking primaryOwner);

    StudentChecking upDateStudentChecking(Long id, StudentChecking studentChecking);


    void delete(Long id);

    StudentChecking changeBalance(Long id, StudentChecking balance);


}
