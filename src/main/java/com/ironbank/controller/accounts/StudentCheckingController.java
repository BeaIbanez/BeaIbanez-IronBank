package com.ironbank.controller.accounts;

import com.ironbank.model.accounts.Money;
import com.ironbank.model.accounts.Status;
import com.ironbank.model.accounts.StudentChecking;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.service.accounts.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/studentcheckings")
public class StudentCheckingController {

    @Autowired
    StudentCheckingService studentCheckingService;
//GETMAPPING

    //All
    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> findAll() {
        return studentCheckingService.findAll();
    }

    //Id
    @GetMapping(path = "/id")
    @ResponseStatus(HttpStatus.OK)
    public StudentChecking findById(@RequestParam long id) {
        return studentCheckingService.findById(id);
    }

    //Balance
    @GetMapping(path = "/balance")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> findByBalance(@RequestParam Money balance) {
        return studentCheckingService.findByBalance(balance);
    }

    //secretKey
    @GetMapping(path = "/secretKey")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> findBySecretKey(@RequestParam String secretKey) {
        return studentCheckingService.findBySecretKey(secretKey);
    }

    //primaryOwner
    @GetMapping(path = "/primaryOwner")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> findByPrimaryOwner(@RequestParam AccountHolder primaryOwner) {
        return studentCheckingService.findByPrimaryOwner(primaryOwner);
    }

    //changeBalance
    @PatchMapping("/changebalance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public StudentChecking changeBalance(@PathVariable long id, @RequestBody StudentChecking balance) {
        return studentCheckingService.changeBalance(id, balance);
    }

    //status
    @GetMapping(path = "/status")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> findByStatus(@RequestParam Status status) {
        return studentCheckingService.findByStatus(status);
    }


    //POSTMAPPING
    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentChecking create(@RequestBody  StudentChecking  checking) {
        return studentCheckingService.create(checking);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public StudentChecking changePrimaryOwner(@PathVariable long id, @RequestBody StudentChecking primaryOwner) {
        return studentCheckingService.changePrimaryOwner(id, primaryOwner);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/checkingupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentChecking upDateStudentChecking(@PathVariable long id, @RequestBody StudentChecking studentChecking) {
        return studentCheckingService.upDateStudentChecking(id, studentChecking);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        studentCheckingService.delete(id);
    }


}
