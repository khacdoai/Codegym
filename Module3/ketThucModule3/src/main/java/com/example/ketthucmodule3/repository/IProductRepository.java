package com.example.ketthucmodule3.repository;

import com.example.ketthucmodule3.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showList();
    void addNewUser(Product product);
    boolean updateUser(Product product);
    Product selectUser(int id);
    boolean deleteUser(int id);
    List<Product> searchUserByName(String ten);
    List<Product> sortByName();
}
