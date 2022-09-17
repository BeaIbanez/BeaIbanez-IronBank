package com.ironbank.model.accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironbank.model.Transaction;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@Entity

public class Account {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue()
    private long id;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    @Embedded
    private Money balance;
    private String secretKey;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "primary_owner")
    private AccountHolder primaryOwner;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })    @Embedded
    @DecimalMin(value = "100", message = "Should be more than 100")
    @DecimalMax(value = "1000", message = "Should be less than 1000")
    private Money minimumBalance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private AccountHolder secondaryOwner;

    @Digits(integer = 40, fraction = 0)
    private BigDecimal penaltyFee;

    private Date localDate;
    private Status status;


    @OneToMany(mappedBy = "fromAccount", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Transaction> fromTransactions;

    @OneToMany(mappedBy = "toAccount", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Transaction> toTransactions;

/*    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate modifyDate;*/

}
