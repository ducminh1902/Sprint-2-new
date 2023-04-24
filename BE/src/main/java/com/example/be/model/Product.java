package com.example.be.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private String productBrand;
    private String productPrice;
    private String productDescripe;
    @ManyToOne
    @JoinColumn(name = "product_type",referencedColumnName = "id")
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "product")
    private Set<Bill> billSet;
}
