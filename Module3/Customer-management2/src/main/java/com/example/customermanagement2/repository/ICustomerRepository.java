package com.example.customermanagement2.repository;

import com.example.customermanagement2.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findBiId(int id);
    void update(int id, Customer customer);
    void remote(int id);
}
