package com.ironbank.Accounts;


import com.ironbank.model.accounts.*;
import com.ironbank.repositories.accounts.CheckingRepository;
import com.ironbank.repositories.accounts.CreditRepository;
import com.ironbank.repositories.accounts.SavingRepository;
import com.ironbank.repositories.accounts.StudentCheckingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


@SpringBootTest
class accountsControllerTester {

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    /*private final ObjectMapper objectMapper = new ObjectMapper();*/

    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private CreditRepository creditRepository;


    @Autowired
    private SavingRepository savingRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    //TODO todos los nuevos son  NULOS
    @BeforeEach
    void setUp_() {
// ACCOUNTS

        //CHECKING ACCOUNTS-----------------------------------------
        checkingRepository.deleteAll();
        /*var date= LocalDate.of(2000, 10, 19);
        var dateTwo= LocalDate.of(1999, 12, 12);

        var aH= new AccountHolder("bea",  date, new Address(23,"Sala Boadella","Spain",130L),"bea@gmail.com");
        var aC= new AccountHolder("TRokolo",  date, new Address(23,"Sala Boadella","Spain",130L),"bea@gmail.com");
       var AccList= new List<Account> hey;
        var primaryOwner = new Checking(new Money(BigDecimal.valueOf(1000)),"secret",aH,new Money(BigDecimal.valueOf(2)),aC,new BigDecimal(23333),dateTwo, Status.ACTIVE,AccList, date, dateTwo, new Money(BigDecimal.valueOf(100)));*/
        var checkingTest = List.of(
                new Checking(),//TODO LLENARLOS
                new Checking()//TODO LLENARLOS

        );
        checkingRepository.saveAll(checkingTest);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();


        var checkingOne = new Checking(null);//TODO LLENARLOS
        checkingRepository.save(checkingOne);


        //CREDIT ACCOUNT-----------------------------------------

        creditRepository.deleteAll();

        var creditTester = List.of(
                new Credit(),//TODO LLENARLOS
                new Credit()//TODO LLENARLOS
        );
//TODO POSTAL CODE

        creditRepository.saveAll(creditTester);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        var creditOne = new Credit();//TODO LLENARLOS
        creditRepository.save(creditOne);


        //SAVING ACCOUNT-----------------------------------------

        savingRepository.deleteAll();

        var savingTester = List.of(
                new Saving(),//TODO LLENARLOS
                new Saving()//TODO LLENARLOS
        );

        savingRepository.saveAll(savingTester);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        var savingOne = new Saving();//TODO LLENARLOS
        savingRepository.save(savingOne);

        //STUDENTCHECKING ACCOUNT-----------------------------------------

        studentCheckingRepository.deleteAll();

        var studentTester = List.of(
                new StudentChecking(),//TODO LLENARLOS
                new StudentChecking()//TODO LLENARLOS
        );

        studentCheckingRepository.saveAll(studentTester);

        //MOCKMVC
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        var studentCheckingOne = new Saving();//TODO LLENARLOS
        savingRepository.save(studentCheckingOne);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_table() throws Exception {

    }
}
