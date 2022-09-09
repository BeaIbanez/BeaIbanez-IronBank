package com.ironbank.repositories.users;

import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {

      List<ThirdParty> findByName(String name);

}
