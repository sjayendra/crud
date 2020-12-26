package com.jay.crud1.model;

import javax.persistence.*;

@Entity
@Table
public class Car {
    @Id
    private long id;
    private String name;

}
