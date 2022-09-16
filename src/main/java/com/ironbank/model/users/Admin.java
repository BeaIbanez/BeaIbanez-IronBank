package com.ironbank.model.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Admin
        extends User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
private String name;
}
