package com.ironbank.service.users;

import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {
    @Override
    public List<ThirdParty> findAll() {
        return null;
    }

    @Override
    public List<ThirdParty> findById(long id) {
        return null;
    }

    @Override
    public List<ThirdParty> findByName(String name) {
        return null;
    }

    @Override
    public List<Admin> findByHashKey(String hashkey) {
        return null;
    }

    @Override
    public ThirdParty upDateThirdParty(Long id, ThirdParty thirdParty) {
        return null;
    }

    @Override
    public ThirdParty changeName(Long id, ThirdParty name) {
        return null;
    }

    @Override
    public ThirdParty create(ThirdParty admin) {
        return null;
    }

    @Override
    public void deleteAdmin(long id) {

    }
}
