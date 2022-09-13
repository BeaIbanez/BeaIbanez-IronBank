package com.ironbank.http.requestAccounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table
public class AccountStatementRequest {
    private String accountNumber;

}
