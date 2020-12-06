package com.jay.crud1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Table - User
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@NotBlank(message = "Name is mandatory")
    private String name;

    //@NotBlank(message = "Email is mandatory")
    private String email;

    private String role;
    // standard constructors / setters / getters / toString

    protected User() {
    }
    public User(String name,String role, String email) {
        super();
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public long getId() {
        return  id;
    }
    public String getRole() {return role;}
    public String getEmail() {return email;}

}