package com.ironbank.controller.accounts;

import com.ironbank.model.accounts.Checking;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.service.accounts.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/checkings")
public class CheckingController {

    @Autowired
    CheckingService checkingService;
//GETMAPPING

    //All
    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findAll() {
        return checkingService.findAll();
    }

    //Id
    @GetMapping(path = "/id")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findById(@RequestParam long id) {
        return checkingService.findById(id);
    }

    //Balance
    @GetMapping(path = "/balance")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findByBalance(@RequestParam Money balance) {
        return checkingService.findByBalance(balance);
    }

    //secretKey
    @GetMapping(path = "/secretKey")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findBySecretKey(@RequestParam String secretKey) {
        return checkingService.findBySecretKey(secretKey);
    }

    //primaryOwner
    @GetMapping(path = "/primaryOwner")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findByPrimaryOwner(@RequestParam String primaryOwner) {
        return checkingService.findByPrimaryOwner(primaryOwner);
    }
    //PATCHMAPPING
    //changeBalance
    @PatchMapping("/changebalance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Checking changeBalance(@PathVariable Long id, @RequestBody Checking balance) {
        return checkingService.changeBalance(id, balance);
    }

    //status
    @GetMapping(path = "/status")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findByStatus(@RequestParam Status status) {
        return checkingService.findByStatus(status);
    }


    //POSTMAPPING
    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Checking create(@RequestBody Checking checking) {
        return checkingService.create(checking);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Checking changePrimaryOwner(@PathVariable Long id, @RequestBody Checking primaryOwner) {
        return checkingService.changePrimaryOwner(id, primaryOwner);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/checkingupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checking upDateChecking(@PathVariable Long id, @RequestBody Checking checking) {
        return checkingService.upDateChecking(id, checking);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteChecking(@PathVariable("id") long id) {
        checkingService.deleteChecking(id);
    }


}
