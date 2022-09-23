package com.ironbank.controller.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Saving;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.service.accounts.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ironbank/savings")
public class SavingController {

    @Autowired
    SavingService savingsService;
    //GETMAPPING
    //All
    @GetMapping(path = "/moderator/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Saving> findAll() {
        return savingsService.findAll();
    }

    //Id
    @GetMapping(path = "/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Saving findById(@RequestParam Long id) {
        return savingsService.findById(id);
    }

    //Balance //NotTODO
    @GetMapping(path = "/admin/balance/{balance}")
    @ResponseStatus(HttpStatus.OK)
    public List<Saving> findByBalance(@RequestParam Money balance) {
        return savingsService.findByBalance(balance);
    }

    //secretKey
    @GetMapping(path = "/admin/secretKey/{secretKey}")
    @ResponseStatus(HttpStatus.OK)
    public List<Saving> findBySecretKey(@RequestParam String secretKey) {
        return savingsService.findBySecretKey(secretKey);
    }

    //primaryOwner
    @GetMapping(path = "/admin/primaryOwner/{primaryOwner}")
    @ResponseStatus(HttpStatus.OK)
    public List<Saving> findByPrimaryOwner(@RequestParam AccountHolder primaryOwner) {
        return savingsService.findByPrimaryOwner(primaryOwner);
    }

    //changeBalance
    @PatchMapping("/admin/changebalance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Saving changeBalance(@PathVariable Long id, @RequestBody StudentChecking balance) {
        return savingsService.changeBalance(id, balance);
    }

    //status
    @GetMapping(path = "/admin/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Saving> findByStatus(@RequestParam Status status) {
        return savingsService.findByStatus(status);
    }


    //POSTMAPPING
    //create
    @PostMapping(path = "/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Saving create(@RequestBody Saving saving) {
        return savingsService.create(saving);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/admin/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Saving changePrimaryOwner(@PathVariable Long id, @RequestBody Saving primaryOwner) {
        return savingsService.changePrimaryOwner(id, primaryOwner);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/admin/checkingupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Saving upDateStudentChecking(@PathVariable Long id, @RequestBody Saving saving) {
        return savingsService.upDateSaving(id, saving);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        savingsService.delete(id);
    }


}
