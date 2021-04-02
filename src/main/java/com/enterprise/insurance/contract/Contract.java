package com.enterprise.insurance.contract;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Person contractHolder;
}
