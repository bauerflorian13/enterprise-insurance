package com.enterprise.insurance.core.data;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected long id;
}
