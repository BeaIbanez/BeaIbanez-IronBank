package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface checkingRepository extends JpaRepository<Checking, Long> {
}
