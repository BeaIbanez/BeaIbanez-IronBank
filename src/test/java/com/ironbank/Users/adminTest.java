package com.ironbank.Users;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ironbank.model.users.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class adminTest {

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private com.ironbank.repositories.users.adminRepository adminRepository;
    @BeforeEach
    void setUp_() {
              adminRepository.deleteAll();

        var employee = List.of(
                new Admin("Bea"),
                new Admin("José"),
                new Admin("Joan"),
                new Admin("Pere"),
                new Admin("Salva"),
                new Admin("Lisa")
        );
        adminRepository.saveAll(employee);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        var adminOne = new Admin("matavies");
        adminRepository.save(adminOne);
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void test_table() throws Exception {

    }
    }
