package com.example.demo.Service.ProductService;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository.IProductRepository;
import com.example.demo.Repository.ProductRepository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> showListProduct() {
        return iProductRepository.showListProduct();
    }

    @Override
    public void create(Product product) {
        iProductRepository.create(product);
    }

    @Override
    public void delete(int[] ids) {
        iProductRepository.delete(ids);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }

    @Override
    public Product selecterById(int id) {
        return iProductRepository.selecterById(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return iProductRepository.updateProduct(product);
    }
}
