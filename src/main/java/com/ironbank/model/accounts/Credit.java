package com.ironbank.model.accounts;

import com.ironbank.model.Transaction;
import com.ironbank.model.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Credit extends Account {
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "credit_limit")),
            @AttributeOverride(name = "currency", column = @Column(name = "credit_limit_currency"))
    })
    @Embedded
    @Min(value = 100, message = "Should be more than 100")
    @Max(value = 100000, message = "Should be less than 100000")
    private Money creditLimit;
    @Embedded
    @DecimalMin(value = "0.1", message = "Should be more than 0.1")
    @DecimalMax(value = "0.2", message = "Should be less than 0.2")
    private Money interestRate;


    private LocalDate lastInterestRate;


    public Credit(Money balance, String secretKey, AccountHolder primaryOwner, Money minimumBalance, AccountHolder secondaryOwner, BigDecimal penaltyFee, Date localDate, Status status, List<Transaction> fromTransactions, List<Transaction> toTransactions, Date createDate, Date modifyDate, Money creditLimit, Money interestRate) {
        super(balance, secretKey, primaryOwner, minimumBalance, secondaryOwner, penaltyFee, localDate, status, fromTransactions, toTransactions, createDate, modifyDate);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }
}
