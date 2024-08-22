package com.example.bai_tap_lam_them.service;

import com.example.bai_tap_lam_them.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> showlist(Pageable pageable);
    void delete(Long id);
    void add(Product product);
    void  update(Product product);
    Product selectById(long id);

    Page<Product> searchByName(Pageable pageable, String name);

}
