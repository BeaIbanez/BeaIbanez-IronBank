package com.ironbank.model.accounts;

import com.ironbank.model.Transaction;
import com.ironbank.model.users.AccountHolder;
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
@Entity

public class StudentChecking extends Account {
    public StudentChecking(Money balance, String secretKey, AccountHolder primaryOwner, Money minimumBalance, AccountHolder secondaryOwner, BigDecimal penaltyFee, Date localDate, Status status, List<Transaction> fromTransactions, List<Transaction> toTransactions) {
    }
}

