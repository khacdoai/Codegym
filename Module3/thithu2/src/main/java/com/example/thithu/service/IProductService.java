package com.example.thithu.service;

import com.example.thithu.dto.ProductDto;
import com.example.thithu.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> showList();
    void createProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    ProductDto selectProduct(int id);
    List<ProductDto> searchProductByName(String name);
    List<ProductDto> searchProductByMaMatHang(String maMatHang);

}
