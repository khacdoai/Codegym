package com.example.thithu.service;

import com.example.thithu.dto.ProductDto;
import com.example.thithu.model.Product;
import com.example.thithu.repository.IProductRepository;
import com.example.thithu.repository.impl.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductDto> showList() {
        return productRepository.showList();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public ProductDto selectProduct(int id) {
        return productRepository.selectProduct(id);
    }

    @Override
    public List<ProductDto> searchProductByName(String name) {
        return productRepository.searchProductByName(name);
    }

    @Override
    public List<ProductDto> searchProductByMaMatHang(String maMatHang) {
        return productRepository.searchProductByMaMatHang(maMatHang);
    }
}
