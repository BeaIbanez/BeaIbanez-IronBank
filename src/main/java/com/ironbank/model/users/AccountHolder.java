package com.ironbank.model.users;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString


public class AccountHolder extends User{
private String name;
        private LocalDate dateOfBirth;
        @Embedded
        private Address address;
        private String email;


        public AccountHolder(String name, LocalDate dateOfBirth, Address address, String email) {
                this.name = name;
                this.dateOfBirth = dateOfBirth;
                this.address = address;
                this.email = email;
        }
}
