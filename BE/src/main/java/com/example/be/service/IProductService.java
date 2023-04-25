package com.example.be.service;

import com.example.be.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    List<Product> findByName(String productName);
}
