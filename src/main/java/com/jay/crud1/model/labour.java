package com.jay.crud1.model;

import javax.persistence.*;

@Entity
@Table
public class labour {
    @Id
    private long id;
    private int repairTime;
    private double rate;
    private double total;

}
