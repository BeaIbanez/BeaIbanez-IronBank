package com.ironbank.controller.users;

import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Admin;
import com.ironbank.service.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ironbank/account_holders")
public class AccountHolderController {
    @Autowired
    AccountHolderService accountHolderService;

//GETMAPPING

    //All
    @GetMapping(path = "/moderator/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findAll() {
        return accountHolderService.findAll();
    }

    //Id
    @GetMapping(path = "/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder findById(@PathVariable("id") long id) {
        return accountHolderService.findById(id);
    }

    //Name
    @GetMapping(path = "/admin/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findByName(@PathVariable("name") String name) {
        return accountHolderService.findByName(name);
    }

    //POSTMAPPING
    //create
    @PostMapping(path = "/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder create(@RequestBody AccountHolder accountHolder) {
        return accountHolderService.create(accountHolder);
    }

    //DateOfBirth
    @GetMapping(path = "/admin/date-birthday/{birth}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findByDateOfBirth(@RequestParam String birth) {
        return accountHolderService.findByDateOfBirth(birth);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/admin/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AccountHolder changeName(@PathVariable Long id, @RequestBody AccountHolder name) {
        return accountHolderService.changeName(id, name);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/admin/accountHolder/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder upDateAccountHolder(@PathVariable Long id, @RequestBody AccountHolder accountHolder) {
        return accountHolderService.upDateAccountHolder(id, accountHolder);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountHolder(@PathVariable("id") long id) {
        accountHolderService.deleteAccountHolder(id);
    }


}



