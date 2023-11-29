package com.example.product.repository;

import com.example.product.Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class productRepository implements IProductRepository{
   private static Map<Integer, Product>products = new HashMap<>();
   static {
       products.put(1,new Product(1,"iphoneX",3000000,"không","Apple"));
       products.put(2,new Product(2,"iphoneXS",3500000,"không","Apple"));
       products.put(3,new Product(3,"SamSung z flip 3",3600000,"không","Samsung"));
       products.put(4,new Product(4,"SamSung z flip 4",3700000,"không","Samsung"));
       products.put(5,new Product(5,"SamSung z flip 5",3800000,"không","Samsung"));
       products.put(6,new Product(6,"iphone 11",3900000,"không","Apple"));
       products.put(7,new Product(7,"iphone 12",4000000,"không","Apple"));
   }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
       products.put(product.getId(),product);

    }

    @Override
    public void update(int id, Product product) {
       products.put(id,product);
    }

    @Override
    public void remote(int id) {
       products.remove(id);

    }

    @Override
    public Product findById(int id) {
         return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        return products.get(name);
    }
}
