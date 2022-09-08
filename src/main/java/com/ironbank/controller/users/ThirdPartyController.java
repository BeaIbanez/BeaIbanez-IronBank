package com.ironbank.controller.users;

import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import com.ironbank.service.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thirdParties")
public class ThirdPartyController {
    @Autowired
    ThirdPartyService thirdPartyService;

//GETMAPPING

    //All
    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> findAll() {
        return thirdPartyService.findAll();
    }

    //Id
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> findById(@RequestParam long id) {
        return thirdPartyService.findById(id);
    }

    //Name
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> findByName(@RequestParam String name) {
        return thirdPartyService.findByName(name);
    }

    //HashKey
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> findByHashKey(@RequestParam String hashkey) {
        return thirdPartyService.findByHashKey(hashkey);
    }

    //POSTMAPPING
    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty create(@RequestBody ThirdParty admin) {
        return thirdPartyService.create(admin);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ThirdParty changeName(@PathVariable Long id, @RequestBody ThirdParty name) {
        return thirdPartyService.changeName(id, name);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/adminupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty upDateThirdParty(@PathVariable Long id, @RequestBody ThirdParty thirdParty) {
        return thirdPartyService.upDateThirdParty(id, thirdParty);
    }
    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteThirdParty(@PathVariable("id") long id) {
        thirdPartyService.deleteAdmin(id);
    }


}




