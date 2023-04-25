package com.example.be.controller;

import com.example.be.model.Product;
import com.example.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.findAll();
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Product> findById(@PathVariable int id){
        Product product = productService.findById(id);
        if (product == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
    }

    @GetMapping("/findProduct/{productName}")
    public  ResponseEntity<List<Product>> findByName(@PathVariable String productName){
        List<Product> productList = productService.findByName(productName);
        if (productList.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return  new ResponseEntity<>(productList,HttpStatus.OK);
        }
    }
}
