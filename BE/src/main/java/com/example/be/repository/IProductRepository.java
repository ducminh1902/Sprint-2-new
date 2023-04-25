package com.example.be.repository;

import com.example.be.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByProductNameContaining(String productName);
}
