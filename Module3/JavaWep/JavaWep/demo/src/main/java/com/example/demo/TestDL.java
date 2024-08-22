package com.example.demo;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService.IProductService;
import com.example.demo.Service.ProductService.ProductService;

import java.util.List;

public class TestDL {
    public static void main(String[] args) {
        IProductService iProductService = new ProductService();
        List<Product> productList = iProductService.showListProduct();
        for (Product o : productList) {
            System.out.println(o);
        }
    }
}
