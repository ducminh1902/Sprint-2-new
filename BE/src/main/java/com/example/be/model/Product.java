package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private double productPrice;
    private String productDescripe;
    private String productImg;

    @ManyToOne
    @JoinColumn(name = "brand_type",referencedColumnName = "id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "flavor_type",referencedColumnName = "id")
    private Flavor flavor;

    @ManyToOne
    @JoinColumn(name = "product_type",referencedColumnName = "id")
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Bill> billSet;

    public Product() {
    }

    public Product(int id, String productName, double productPrice, String productDescripe, String productImg, Brand brand, Flavor flavor, ProductType productType, Set<Cart> cartSet, Set<Bill> billSet) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescripe = productDescripe;
        this.productImg = productImg;
        this.brand = brand;
        this.flavor = flavor;
        this.productType = productType;
        this.cartSet = cartSet;
        this.billSet = billSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescripe() {
        return productDescripe;
    }

    public void setProductDescripe(String productDescripe) {
        this.productDescripe = productDescripe;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<Cart> getCartSet() {
        return cartSet;
    }

    public void setCartSet(Set<Cart> cartSet) {
        this.cartSet = cartSet;
    }

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }
}
