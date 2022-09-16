package com.ironbank.model.users;

import com.ironbank.model.accounts.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name = "account")
    private List<Account> accounts;


    private String name;
}
