package com.example.bai_tap_lam_them.service;

import com.example.bai_tap_lam_them.model.ProductDetail;
import com.example.bai_tap_lam_them.repository.IProductDeltailRepository;
import com.example.bai_tap_lam_them.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductDetailService implements IProductdetallService {
    @Autowired
    private IProductDeltailRepository iProductDeltailRepository;
    @Override
    public List<ProductDetail> showList() {
        return iProductDeltailRepository.findAll();
    }
}
