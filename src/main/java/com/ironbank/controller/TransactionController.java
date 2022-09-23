package com.ironbank.controller;

import com.ironbank.model.Transaction;
import com.ironbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/ironbank/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    //GETS
    @GetMapping(path = "/moderator/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @GetMapping(path = "/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction findById(@PathVariable("id") long id) {
        return transactionService.findById(id);
    }


    @GetMapping(path = "/admin/fromaccount/{fromAccountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction fromAccountNumber(@PathVariable("fromAccountNumber") String fromAccountNumber) {
        return transactionService.fromAccount(fromAccountNumber);
    }


    @GetMapping(path = "/admin/toaccount/{toAccountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction toAccountNumber(@PathVariable("toAccountNumber") String toAccountNumber) {
        return transactionService.toAccount(toAccountNumber);
    }

    @GetMapping(path = "/admin/nameFrom/{primaryOwnerFrom}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction fromAccountName(@PathVariable("primaryOwnerFrom") String fromAccountName) {
        return transactionService.fromAccountName(fromAccountName);
    }


    @GetMapping(path = "/admin/amount/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction findByAmount(@PathVariable("amount") BigDecimal findByAmount) {
        return transactionService.findByAmount(findByAmount);
    }

    //POST
    @PostMapping(path = "/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction create(@RequestBody Transaction transaction) {
        var result = transactionService.create(transaction);
        System.out.println(result);
        return result;

    }

    //PATCH
    //changeAmount
    @PatchMapping("/admin/amount/{transferBalanceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Transaction changeAmount(@PathVariable Long transferBalanceId, @RequestBody Transaction amount) {
        return transactionService.changeAmount(transferBalanceId, amount);

    }

    @PatchMapping("/admin/fromAccountNumber/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Transaction changeFromAccountNumber(@PathVariable Long transferBalanceId, @RequestBody Transaction fromAccountNumber) {
        return transactionService.changeFromAccountNumber(transferBalanceId, fromAccountNumber);

    }

    @PatchMapping("/admin/toAccountNumber/{transferBalanceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Transaction changeToAccountNumber(@PathVariable Long transferBalanceId, @RequestBody Transaction toAccountNumber) {
        return transactionService.changeToAccountNumber(transferBalanceId, toAccountNumber);

    }

    //PUT
    //delete
    @DeleteMapping("/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTransaction(@PathVariable("id") long id) {
        transactionService.deleteTransaction(id);
    }


}
