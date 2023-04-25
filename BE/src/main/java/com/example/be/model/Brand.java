package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.management.GarbageCollectorMXBean;
import java.util.Set;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBrand;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private Set<Product> productSet;

    public Brand() {
    }

    public Brand(int id, String nameBrand, Set<Product> productSet) {
        this.id = id;
        this.nameBrand = nameBrand;
        this.productSet = productSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
