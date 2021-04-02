package com.enterprise.insurance.contract;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Person contractHolder;
}
