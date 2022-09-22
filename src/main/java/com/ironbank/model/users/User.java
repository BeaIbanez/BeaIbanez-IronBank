package com.ironbank.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironbank.model.accounts.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
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

    @GeneratedValue()
    private String keyCloakId;
   /* @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate modifyDate;*/

    @OneToMany(mappedBy = "primaryOwner", cascade={CascadeType.ALL} )
    @JsonIgnore
    private List<Account> accounts;

    @OneToMany(mappedBy = "secondaryOwner", cascade={CascadeType.ALL} )
    @JsonIgnore
    private List<Account> secondaryAccounts;

    private String name;
}
