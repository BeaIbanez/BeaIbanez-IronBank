package com.ironbank.controller.accounts;

import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.service.accounts.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credites")
public class CreditController {

    @Autowired
    CreditService creditService;
//GETMAPPING

    //All
    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findAll() {
        return creditService.findAll();
    }

    //Id
    @GetMapping(path = "/id")
    @ResponseStatus(HttpStatus.OK)
    public Credit findById(@RequestParam Long id) {
        return creditService.findById(id);
    }

    //Balance
    @GetMapping(path = "/balance")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findByBalance(@RequestParam Money balance) {
        return creditService.findByBalance(balance);
    }

    //secretKey
    @GetMapping(path = "/secretKey")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findBySecretKey(@RequestParam String secretKey) {
        return creditService.findBySecretKey(secretKey);
    }

    //primaryOwner
    @GetMapping(path = "/primaryOwner")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findByPrimaryOwner(@RequestParam String primaryOwner) {
        return creditService.findByPrimaryOwner(primaryOwner);
    }

    //status
    @GetMapping(path = "/status")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findByStatus(@RequestParam Status status) {
        return creditService.findByStatus(status);
    }


    //POSTMAPPING
    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Credit create(@RequestBody Credit checking) {
        return creditService.create(checking);
    }

    //PATCHMAPPING
    //changePrimaryOwner
    @PatchMapping("/primaryowner/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Credit changePrimaryOwner(@PathVariable Long id, @RequestBody Credit primaryOwner) {
        return creditService.changePrimaryOwner(id, primaryOwner);
    }

    //PATCHMAPPING
    //changeBalance
    @PatchMapping("/changebalance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Credit changeBalance(@PathVariable Long id, @RequestBody Credit balance) {
        return creditService.changeBalance(id, balance);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/checkingupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Credit upDateCredit(@PathVariable Long id, @RequestBody Credit credit) {
        return creditService.upDateCredit(id, credit);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        creditService.delete(id);
    }


}
