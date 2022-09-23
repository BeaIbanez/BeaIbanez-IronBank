package com.ironbank.model;

import com.ironbank.model.accounts.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "transfer_id")
    private String transferId;

    @ManyToOne
    private Account fromAccount;
    @ManyToOne
    private Account toAccount;
    private BigDecimal amount;
    private String fromAccountName;
    private String toAccountName;


}