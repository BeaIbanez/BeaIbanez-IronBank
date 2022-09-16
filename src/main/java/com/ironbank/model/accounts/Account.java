package com.ironbank.model.accounts;

import com.ironbank.model.users.User;
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
@Entity


public class Account {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    /*@Column(precision = 32, scale = 4)*/
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    @Embedded
    private Money balance;
    private String secretKey;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;


    private String primaryOwner;
    private String secondaryOwner;
    private BigDecimal penaltyFee;
    private Date localDate;
    private Status status;

/*    public static void monthlyFee(BigDecimal fee, BigDecimal balance){
        balance = balance.add(fee);
        Account.setBalance(balance);
        System.out.println("It works");
    }*/ //TODO InterestRate
}
