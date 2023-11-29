package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer );
    void remote(int id);
}
