package com.ironbank.model.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Table
@MappedSuperclass


public class Accounts {
    @Embedded
    private Money balance;
    @Embedded
    private Money secretKey;
    private String primaryOwner;
    private String secondaryOwner;
    private BigDecimal penaltyFee;
    private Date localDate;
    private Status status;

}
