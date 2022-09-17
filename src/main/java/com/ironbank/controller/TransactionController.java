package com.ironbank.controller;

import com.ironbank.model.Transaction;
import com.ironbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    //GETS
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


    @GetMapping(path = "/fromaccount/{fromAccountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction fromAccountNumber(@PathVariable("fromAccountNumber") String fromAccountNumber) {
        return transactionService.fromAccount(fromAccountNumber);
    }


    @GetMapping(path = "/toaccount/{toAccountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction toAccountNumber(@PathVariable("toAccountNumber") String toAccountNumber) {
        return transactionService.toAccount(toAccountNumber);
    }
    @GetMapping(path = "/nameFrom/{primaryOwnerFrom}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction fromAccountName(@PathVariable("primaryOwnerFrom") String fromAccountName) {
        return transactionService.fromAccountName(fromAccountName);
    }


    @GetMapping(path = "/amount/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction findByAmount(@PathVariable("amount") BigDecimal findByAmount) {
        return transactionService.findByAmount(findByAmount);
    }




    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  Transaction create(@RequestBody Transaction transaction) {
        var result= transactionService.create(transaction);
        System.out.println(result);
        return result;
/*
        return transactionService.create(transaction);
*/
    }




    //PATCH

    //changeAmount
    @PatchMapping("/amount/{transferBalanceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Transaction changeAmount(@PathVariable Long transferBalanceId, @RequestBody Transaction amount) {
        return transactionService.changeAmount(transferBalanceId, amount);

    }
    @PatchMapping("/fromAccountNumber/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Transaction changeFromAccountNumber(@PathVariable Long transferBalanceId, @RequestBody Transaction fromAccountNumber) {
        return transactionService.changeFromAccountNumber(transferBalanceId, fromAccountNumber);

    }
    @PatchMapping("/toAccountNumber/{transferBalanceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Transaction changeToAccountNumber(@PathVariable Long transferBalanceId, @RequestBody Transaction toAccountNumber) {
        return transactionService.changeToAccountNumber(transferBalanceId, toAccountNumber);

    }

    //PUT
    //delete
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTransaction(@PathVariable("id") long id) {
        transactionService.deleteTransaction(id);
    }


}
