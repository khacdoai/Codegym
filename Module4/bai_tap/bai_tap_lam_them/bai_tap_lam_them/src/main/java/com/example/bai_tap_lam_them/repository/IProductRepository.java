package com.example.bai_tap_lam_them.repository;

import com.example.bai_tap_lam_them.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);

    @Query("select p from Product p where p.ten like %?1%")
    Page<Product>searchProduct(Pageable pageable, String name);
}
