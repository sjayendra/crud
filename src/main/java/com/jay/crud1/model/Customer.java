package com.jay.crud1.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    private long id;
    private String name;

}
