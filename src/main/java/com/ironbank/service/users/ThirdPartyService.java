package com.ironbank.service.users;

import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ThirdPartyService {

    List<ThirdParty> findAll();

   ThirdParty findById(long id);

    List<ThirdParty> findByName(String name);

    List<ThirdParty> findByHashKey(String hashedKey);


    ThirdParty upDateThirdParty(Long id, ThirdParty thirdParty);

    ThirdParty changeName(Long id, ThirdParty name);

    ThirdParty create(ThirdParty thirdParty);

    void deleteAdmin(long id);


    ;
}
