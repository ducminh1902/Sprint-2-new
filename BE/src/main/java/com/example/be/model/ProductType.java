package com.example.be.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameType;

    @OneToMany(mappedBy = "productType")
    private Set<Product> productSet;

}
