package com.ironbank.model.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor
@Getter
@Setter

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

}
