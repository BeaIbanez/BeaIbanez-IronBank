package com.ironbank.model.accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Table
@MappedSuperclass


public class Accounts {
    /*@Column(precision = 32, scale = 4)*/
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    @Embedded
    private Money balance;
    private String secretKey;
    private String primaryOwner;
    private String secondaryOwner;
    private BigDecimal penaltyFee;
    private Date localDate;
    private Status status;
}
