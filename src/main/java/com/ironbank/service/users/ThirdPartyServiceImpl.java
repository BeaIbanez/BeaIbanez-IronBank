package com.ironbank.service.users;

import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import com.ironbank.repositories.users.AdminRepository;
import com.ironbank.repositories.users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {
    @Autowired
    ThirdPartyRepository repository;

    @Override
    public List<ThirdParty> findAll() {
        return repository.findAll();
    }

    @Override
    public ThirdParty findById(long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "ThirdParty with id " + id + "not found."));
    }

    @Override
    public List<ThirdParty> findByName(String name) {
        return repository.findByName(name);
    }


    @Override
    public ThirdParty upDateThirdParty(Long id, ThirdParty thirdParty) {
        ThirdParty third = (ThirdParty) findById(id);
        var changedathird = third;
        changedathird.setName(thirdParty.getName());
        return repository.save(changedathird);
    }


    @Override
    public ThirdParty changeName(Long id, ThirdParty name) {
        ThirdParty third = (ThirdParty) findById(id);
        var changethird = third;
        changethird.setName(name.getName());
        return repository.save(changethird);
    }

    @Override
    public ThirdParty create(ThirdParty thirdParty) {
        return repository.save(thirdParty);
    }

    @Override
    public void deleteAdmin(long id) {
        ThirdParty thirdParty = new ThirdParty();
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public List<ThirdParty> findByHashedKey(String hashedKey) {
        return repository.findByHashedKey(hashedKey);
    }
}
