package com.example.bai_tap_lam_them.repository;

import com.example.bai_tap_lam_them.model.ProductDetail;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDeltailRepository extends JpaRepository<ProductDetail,Long> {
}
