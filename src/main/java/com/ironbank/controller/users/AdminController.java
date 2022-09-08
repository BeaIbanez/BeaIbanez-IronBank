package com.ironbank.controller.users;

import com.ironbank.model.users.Admin;
import com.ironbank.service.users.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;

//GETMAPPING

    //All
    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> findAll() {
        return adminService.findAll();
    }

    //Id
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> findById(@RequestParam long id) {
        return adminService.findById(id);
    }

    //Name
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> findByName(@RequestParam String name) {
        return adminService.findByName(name);
    }


    //POSTMAPPING
    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Admin create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Admin changeName(@PathVariable Long id, @RequestBody Admin name) {
        return adminService.changeName(id, name);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/adminupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin upDateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.upDateAdmin(id, admin);
    }
    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdmin(@PathVariable("id") long id) {
        adminService.deleteAdmin(id);
    }


}



