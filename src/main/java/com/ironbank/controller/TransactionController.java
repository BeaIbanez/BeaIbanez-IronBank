package com.ironbank.controller;

import com.ironbank.model.Transaction;
import com.ironbank.model.users.ThirdParty;
import com.ironbank.service.TransactionService;
import com.ironbank.service.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @GetMapping(path = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction findById(@PathVariable("id") long id) {
        return transactionService.findById(id);
    }

    //Name
    @GetMapping(path = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List< Transaction> findByName(@PathVariable("name") String name) {
        return transactionService.findByName(name);
    }
    //HashKey //TODO
    @GetMapping(path = "/key/{key}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findByHashKey(@PathVariable("key") String hashedKey) {
        return transactionService.findByHashKey(hashedKey);
    }

}
