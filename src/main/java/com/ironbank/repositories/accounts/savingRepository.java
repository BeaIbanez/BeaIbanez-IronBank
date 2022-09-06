package com.ironbank.repositories.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface savingRepository extends JpaRepository<Saving, Long> {
}
