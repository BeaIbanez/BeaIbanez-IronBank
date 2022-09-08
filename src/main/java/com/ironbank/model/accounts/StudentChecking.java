package com.ironbank.model.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class StudentChecking extends Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}

