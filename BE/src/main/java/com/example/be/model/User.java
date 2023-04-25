package com.example.be.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;
    private String name;
    private String password;
    private String dateOfBirth;
    private Integer gender;
    private String address;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();


    @OneToMany(mappedBy = "user")
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "user")
    private Set<Bill> billSet;

    public User() {
    }

    public User(String userName, String name, String password, String email) {
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(int id, String userName, String dateOfBirth, int gender, String address, String email, String phoneNumber, Set<Cart> cartSet, Set<Bill> billSet) {
        this.id = id;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cartSet = cartSet;
        this.billSet = billSet;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
