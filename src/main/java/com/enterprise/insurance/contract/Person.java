package com.enterprise.insurance.contract;

import com.enterprise.insurance.core.data.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Person extends AbstractEntity {
    @Column
    private String firstName;

    @Column
    private String lastName;


}
