package com.example.product.Service;

import com.example.product.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product>findAll();
    void create(Product product);
    void update(int id, Product product );
    void remote(int id);
    Product findById(int id);
    Product findByName(String name);
}
