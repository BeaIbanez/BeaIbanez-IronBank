package com.ironbank.model.accounts;


import com.ironbank.model.Transaction;
import com.ironbank.model.users.AccountHolder;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor


public class Checking extends Account {

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maitenance_fee")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maitenance_fee_currency"))
    })
    @Embedded
    @Digits(integer = 12, fraction = 0)
    private Money monthlyMaintenanceFee;

    public Checking(Money balance, String secretKey, AccountHolder primaryOwner, Money minimumBalance, AccountHolder secondaryOwner, BigDecimal penaltyFee, Date localDate, Status status, List<Transaction> fromTransactions, List<Transaction> toTransactions, Date createDate, Date modifyDate, Money monthlyMaintenanceFee) {
        super(balance, secretKey, primaryOwner, minimumBalance, secondaryOwner, penaltyFee, localDate, status, fromTransactions, toTransactions, createDate, modifyDate);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Checking(Money money, String secret, AccountHolder aH, Money money1, AccountHolder aC, BigDecimal bigDecimal, LocalDate dateTwo, Status active, List<Account> accList, LocalDate date, LocalDate dateTwo1, Money money2) {
    }
}
