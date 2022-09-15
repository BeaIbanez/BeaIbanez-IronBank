package com.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "transferId")
    private String transferId;

    /*@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SEQNO", unique = true, nullable = false)
    public Integer getSeqno() {
        return this.seqno;
    }*/

    private String fromAccountNumber;

    private String toAccountNumber;

    private BigDecimal amount;

    private TransactionType transactionType;

    private String fromAccountName;

    private String toAccountName;
    private Long income;
    private Long charge;
}