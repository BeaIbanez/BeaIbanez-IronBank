package com.ironbank.service.users;

import com.ironbank.model.users.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    List<Admin> findAll();
    List<Admin> findById(long id);
    List<Admin> findByName(String name);

    Admin create(Admin admin);

    Admin changeName(Long id, Admin name);

    Admin upDateAdmin(Long id, Admin admin);

    void deleteAdmin(long id);

;
}
