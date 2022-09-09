package com.ironbank.service.users;

import com.ironbank.model.users.Admin;
import com.ironbank.repositories.users.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository repository;

    @Override
    public List<Admin> findAll() {
        return repository.findAll();
    }

    @Override
    public Admin findById(long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Admin with id " + id + "not found."));
    }

    @Override
    public List<Admin> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);

    }

    @Override
    public Admin changeName(Long id, Admin name) {
        Admin adminfound = findById(id);
        var changedName = adminfound;
        changedName.setName(name.getName());
        return repository.save(changedName);

    }

    @Override
    public void deleteAdmin(long id) {
        Admin admin = new Admin();
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
