package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> showList(Pageable pageable);
    void add(Product product);
    void remove(Long id);
    Optional<Product> findById(Long id);
    Page<Product> searchName(Pageable pageable, String keyword);
}
