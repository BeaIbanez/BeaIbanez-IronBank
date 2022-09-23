package com.ironbank.service.users;

import com.ironbank.model.users.Admin;

import java.util.List;
import java.util.Optional;


public interface AdminService {

    List<Admin> findAll();

    Admin findById(long id);

    List<Admin> findByName(String name);

    Admin create(Admin admin);

    Admin changeName(Long id, Admin name);

    void deleteAdmin(long id);
}
