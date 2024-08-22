package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Long id);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Page<Product> searchStudent (Pageable pageable, String keyword);
}
