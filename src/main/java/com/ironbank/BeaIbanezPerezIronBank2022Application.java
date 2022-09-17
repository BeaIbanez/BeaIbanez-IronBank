package com.ironbank;

import com.ironbank.model.accounts.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication
@EnableScheduling
public class BeaIbanezPerezIronBank2022Application {

    public static void main(String[] args) {
        SpringApplication.run(BeaIbanezPerezIronBank2022Application.class, args);
    }

}
