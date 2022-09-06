package com.ironbank.model.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class AccountHolder {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String name;
        private String dateOfBirth;
        @Embedded
        private Address Address;
        private String email;

}