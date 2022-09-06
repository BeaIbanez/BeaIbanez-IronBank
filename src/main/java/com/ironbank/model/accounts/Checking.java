package com.ironbank.model.accounts;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table
public class Checking extends Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private Money minimumBalance;
    @Embedded
    private Money monthlyMaintenanceFee;
}
