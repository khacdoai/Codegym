package com.example.bai_tap_lam_them.service;

import com.example.bai_tap_lam_them.model.Product;
import com.example.bai_tap_lam_them.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> showlist(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void add(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product selectById(long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> searchByName(Pageable pageable, String name) {
        return iProductRepository.searchProduct(pageable,name);
    }

}
