package com.ironbank.controller.accounts;

import com.ironbank.model.accounts.Account;
import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.service.accounts.CheckingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ironbank/checkings")
public class CheckingController {

    @Autowired
    CheckingService checkingService;
    //GETMAPPING

    //All
    @GetMapping(path = "/moderator/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findAll() {
        List<Checking> all = checkingService.findAll();
        return all;
    }

    //Id
    @GetMapping(path = "/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checking findById(@RequestParam Long id) {
        return checkingService.findById(id);
    }

    //Balance
    @GetMapping(path = "/admin/balance/{balance}")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findByBalance(@RequestParam Money balance) {
        return checkingService.findByBalance(balance);
    }

    //secretKey
    @GetMapping(path = "/admin/secretKey/{secretKey}")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findBySecretKey(@RequestParam String secretKey) {
        return checkingService.findBySecretKey(secretKey);
    }

    //primaryOwner
    @GetMapping(path = "/admin/primaryOwner/{primaryOwner}")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findByPrimaryOwner(@RequestParam AccountHolder primaryOwner) {
        return checkingService.findByPrimaryOwner(primaryOwner);
    }

    //PATCHMAPPING
    //changeBalance
    @PatchMapping("/admin/changebalance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Checking changeBalance(@PathVariable Long id, @RequestBody Checking balance) {
        return checkingService.changeBalance(id, balance);
    }

    //status
    @GetMapping(path = "/admin/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findByStatus(@RequestParam Status status) {
        return checkingService.findByStatus(status);
    }


    //POSTMAPPING
    //create
    @PostMapping(path = "/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Checking checking) {

        return checkingService.create(checking);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/admin/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Checking changePrimaryOwner(@PathVariable Long id, @RequestBody Checking primaryOwner) {
        return checkingService.changePrimaryOwner(id, primaryOwner);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/admin/checkingupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checking upDateChecking(@PathVariable Long id, @RequestBody Checking checking) {
        return checkingService.upDateChecking(id, checking);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        checkingService.delete(id);
    }

}
