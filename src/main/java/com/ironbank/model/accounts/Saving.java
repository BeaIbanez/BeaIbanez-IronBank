package com.ironbank.model.accounts;

import com.ironbank.model.Transaction;
import com.ironbank.model.users.AccountHolder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@Entity
public class Saving extends Account {


    @Embedded
    @DecimalMin(value = "0.0025", message = "Should be more than 0.0025")
    @DecimalMax(value = "0.5", message = "Should be less than 0.5")
    private Money interestRate;


}
