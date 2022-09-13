package com.ironbank.model;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table
public class AccountStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountStatementid;
    BigDecimal currentBalance;

}
