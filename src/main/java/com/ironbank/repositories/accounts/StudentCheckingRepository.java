package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.model.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {


    List<StudentChecking> findByBalance(Money balance);

    List<StudentChecking> findBySecretKey(String secretKey);

    List<StudentChecking> findByPrimaryOwner(AccountHolder primaryOwner);

    List<StudentChecking> findByStatus(Status status);

    void delete(StudentChecking entity);
}
