package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Flavor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameFlavor;

    @OneToMany(mappedBy = "flavor")
    @JsonIgnore
    private Set<Product> productSet;


    public Flavor() {
    }

    public Flavor(int id, String nameFlavor, Set<Product> productSet) {
        this.id = id;
        this.nameFlavor = nameFlavor;
        this.productSet = productSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFlavor() {
        return nameFlavor;
    }

    public void setNameFlavor(String nameFlavor) {
        this.nameFlavor = nameFlavor;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
