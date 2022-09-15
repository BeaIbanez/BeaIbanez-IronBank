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
public class Saving extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private Money interestRate;

}
