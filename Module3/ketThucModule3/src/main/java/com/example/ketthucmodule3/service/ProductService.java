package com.example.ketthucmodule3.service;

import com.example.ketthucmodule3.model.Product;
import com.example.ketthucmodule3.repository.IProductRepository;
import com.example.ketthucmodule3.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProducyService{
    IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> showList() {
        return productRepository.showList();
    }

    @Override
    public void addNewUser(Product product) {
        productRepository.addNewUser(product);

    }

    @Override
    public boolean updateUser(Product product) {
        return false;
    }

    @Override
    public Product selectUser(int id) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return productRepository.deleteUser(id);
    }

    @Override
    public List<Product> searchUserByName(String ten) {
        return null;
    }

    @Override
    public List<Product> sortByName() {
        return null;
    }
}
