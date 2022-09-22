package com.ironbank.Users;


import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Address;
import com.ironbank.model.users.Admin;
import com.ironbank.model.users.ThirdParty;
import com.ironbank.repositories.users.AccountHolderRepository;
import com.ironbank.repositories.users.AdminRepository;
import com.ironbank.repositories.users.ThirdPartyRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;



@SpringBootTest
class usersTester {

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    /*private final ObjectMapper objectMapper = new ObjectMapper();*/

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;
    @BeforeEach
    void setUp_() {
// USERS
        //ADMIN-----------------------------------------
              adminRepository.deleteAll();

        var admins = List.of(
                new Admin("yep"),
                new Admin("yep")

        );
        adminRepository.saveAll(admins);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        var adminOne = new Admin("matavies");
        adminRepository.save(adminOne);


        //ACCOUNTHOLDERS-----------------------------------------

        accountHolderRepository.deleteAll();
      //TODO poner bien la fecha!

        var accountHolder = List.of(
                new AccountHolder("Bea", LocalDate.of(2000,10,20) ,new Address(23,"Sala Boadella","Spain",130L),"beatrizip1@gmail.com"),
                new AccountHolder("Sergio",null,new Address(10,"Sala Pimnxun","France",130L),"sergio_ip@gmail.com"));
//TODO POSTAL CODE

        accountHolderRepository.saveAll(accountHolder);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        var accountHolderOne = new AccountHolder("Lalo",null,new Address(23,"Sala Boadella","Spain",null),"beatrizip1@gmail.com");
        accountHolderRepository.save(accountHolderOne);


        //THIRDPARTY-----------------------------------------

        thirdPartyRepository.deleteAll();

        var thirdpartyNew = List.of(
                new ThirdParty("Bea","8912819"),
                new ThirdParty("Sergio","9910182jss"));


        thirdPartyRepository.saveAll(thirdpartyNew);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        var thirdPartyOne = new ThirdParty("Lalo","98999i");
        thirdPartyRepository.save(thirdPartyOne);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_table() throws Exception {

    }
    }
