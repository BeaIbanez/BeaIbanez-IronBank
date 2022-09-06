package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}
