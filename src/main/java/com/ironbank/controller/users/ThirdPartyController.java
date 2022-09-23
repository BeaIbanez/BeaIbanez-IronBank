package com.ironbank.controller.users;

import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import com.ironbank.service.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ironbank/thirdParties")
public class ThirdPartyController {
    @Autowired
    ThirdPartyService thirdPartyService;

//GETMAPPING

    //All
    @GetMapping(path = "/moderator/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> findAll() {
        return thirdPartyService.findAll();
    }

    @GetMapping(path = "/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty findById(@PathVariable("id") long id) {
        return thirdPartyService.findById(id);
    }

    //Name
    @GetMapping(path = "/admin/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> findByName(@PathVariable("name") String name) {
        return thirdPartyService.findByName(name);
    }

    @GetMapping(path = "/admin/key/{key}")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> findByHashedKey(@PathVariable("key") String hashedKey) {
        return thirdPartyService.findByHashedKey(hashedKey);
    }

    //POSTMAPPING
    //create
    @PostMapping(path = "/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty create(@RequestBody ThirdParty thirdParty) {
        return thirdPartyService.create(thirdParty);
    }

    //PATCHMAPPING
    //changeName
    @PatchMapping("/admin/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ThirdParty changeName(@PathVariable Long id, @RequestBody ThirdParty name) {
        return thirdPartyService.changeName(id, name);
    }

    //PUTMAPPING
    //upDateAdmin
    @PutMapping(path = "/admin/adminupdate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty upDateThirdParty(@PathVariable Long id, @RequestBody ThirdParty thirdParty) {
        return thirdPartyService.upDateThirdParty(id, thirdParty);
    }

    //PUTMAPPING
    //deleteAdmin
    @DeleteMapping("/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteThirdParty(@PathVariable("id") long id) {
        thirdPartyService.deleteAdmin(id);
    }


}




