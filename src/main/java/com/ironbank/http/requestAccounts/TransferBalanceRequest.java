package com.ironbank.http.requestAccounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class TransferBalanceRequest {
    @Id
    @Column( nullable = false)
    private Long transferBalanceId;

    private String fromAccountNumber;

    private String toAccountNumber;

    private BigDecimal amount;

}