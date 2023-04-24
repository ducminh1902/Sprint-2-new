package com.example.be.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String dateOfBirth;
    private int gender;
    private String address;
    private String email;
    private String phoneNumber;


    @OneToMany(mappedBy = "user")
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "user")
    private Set<Bill> billSet;
}
