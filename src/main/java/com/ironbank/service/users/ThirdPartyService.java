package com.ironbank.service.users;

import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThirdPartyService {

    List<ThirdParty> findAll();

    List<ThirdParty> findById(long id);

    List<ThirdParty> findByName(String name);

    List<Admin> findByHashKey(String hashkey);


    ThirdParty upDateThirdParty(Long id, ThirdParty thirdParty);

    ThirdParty changeName(Long id, ThirdParty name);

    ThirdParty create(ThirdParty admin);

    void deleteAdmin(long id);


    ;
}
