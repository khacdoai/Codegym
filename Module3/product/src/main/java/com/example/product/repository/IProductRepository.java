package com.example.product.repository;

import com.example.product.Model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void create(Product product);
    void update(int id, Product product );
    void remote(int id);
    Product findById(int id);
    Product findByName(String name);
}
