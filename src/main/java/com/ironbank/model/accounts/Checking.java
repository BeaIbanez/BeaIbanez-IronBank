package com.ironbank.model.accounts;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter

public class Checking extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    @Embedded
    private Money minimumBalance;
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maitenance_fee")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maitenance_fee_currency"))
    })
    @Embedded
    private Money monthlyMaintenanceFee;


}
