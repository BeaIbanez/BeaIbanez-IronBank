package com.ironbank.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironbank.model.accounts.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue()
    private long id;

    public User(List<Account> accounts, List<Account> secondaryAccounts, String name) {
        this.accounts = accounts;
        this.secondaryAccounts = secondaryAccounts;
        this.name = name;
    }

    @OneToMany(mappedBy = "primaryOwner", cascade={CascadeType.ALL} )
    @JsonIgnore
    private List<Account> accounts;

    @OneToMany(mappedBy = "secondaryOwner", cascade={CascadeType.ALL} )
    @JsonIgnore
    private List<Account> secondaryAccounts;

    private String name;
}
