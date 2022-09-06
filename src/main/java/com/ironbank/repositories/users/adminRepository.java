package com.ironbank.repositories.users;

import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends JpaRepository<Admin, Long> {
}
