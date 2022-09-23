package com.ironbank.controller.accounts;

import com.ironbank.model.accounts.Credit;
import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.service.accounts.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ironbank/credites")
public class CreditController {

    @Autowired
    CreditService creditService;
//GETMAPPING

    //All
    @GetMapping(path = "/moderator/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findAll() {
        return creditService.findAll();
    }

    //Id
    @GetMapping(path = "/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Credit findById(@RequestParam Long id) {
        return creditService.findById(id);
    }

    //Balance
    @GetMapping(path = "//admin/balance/{balance}")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findByBalance(@RequestParam Money balance) {
        return creditService.findByBalance(balance);
    }

    //secretKey
    @GetMapping(path = "/admin/secretKey/{secretKey}")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findBySecretKey(@RequestParam String secretKey) {
        return creditService.findBySecretKey(secretKey);
    }

    //primaryOwner
    @GetMapping(path = "/admin/primaryOwner/{primaryOwner}")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findByPrimaryOwner(@RequestParam AccountHolder primaryOwner) {
        return creditService.findByPrimaryOwner(primaryOwner);
    }

    //status
    @GetMapping(path = "/admin/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> findByStatus(@RequestParam Status status) {
        return creditService.findByStatus(status);
    }


    //POSTMAPPING
    //create
    @PostMapping(path = "/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Credit create(@RequestBody Credit checking) {
        return creditService.create(checking);
    }

    //PATCHMAPPING
    //changePrimaryOwner
    @PatchMapping("/admin/primaryowner/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Credit changePrimaryOwner(@PathVariable Long id, @RequestBody Credit primaryOwner) {
        return creditService.changePrimaryOwner(id, primaryOwner);
    }

    //PATCHMAPPING
    //changeBalance
    @PatchMapping("/admin/changebalance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Credit changeBalance(@PathVariable Long id, @RequestBody Credit balance) {
        return creditService.changeBalance(id, balance);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/admin/checkingupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Credit upDateCredit(@PathVariable Long id, @RequestBody Credit credit) {
        return creditService.upDateCredit(id, credit);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        creditService.delete(id);
    }


}
