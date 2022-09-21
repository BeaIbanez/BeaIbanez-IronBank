package com.ironbank.model.users;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString


public class AccountHolder
        extends User
{

        private LocalDate dateOfBirth;
        @Embedded
        private Address address;
        private String email;

        public AccountHolder( LocalDate dateOfBirth, Address address, String email) {

                this.dateOfBirth = dateOfBirth;
                this.address = address;
                this.email = email;
        }


}
