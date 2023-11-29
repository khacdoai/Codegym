package com.example.product.Service;

import com.example.product.Model.Product;
import com.example.product.repository.IProductRepository;
import com.example.product.repository.productRepository;

import java.util.List;

public class productService implements IProductService{
    IProductRepository productRepository = new productRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);

    }

    @Override
    public void update(int id, Product product) {

        productRepository.update(id,product);
    }

    @Override
    public void remote(int id) {
        productRepository.remote(id);

    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
