package com.ironbank.repositories.accounts;


import com.ironbank.model.accounts.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface creditRepository extends JpaRepository<Credit, Long> {
}
