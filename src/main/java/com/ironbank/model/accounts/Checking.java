package com.ironbank.model.accounts;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import javax.persistence.*;
import javax.validation.constraints.Digits;


@Entity
@NoArgsConstructor
@Getter
@Setter


public class Checking extends Account {


    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maitenance_fee")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maitenance_fee_currency"))
    })
    @Embedded
    @Digits(integer=12, fraction=0)
    private Money monthlyMaintenanceFee;


}
