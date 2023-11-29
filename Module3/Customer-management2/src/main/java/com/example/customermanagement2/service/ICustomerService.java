package com.example.customermanagement2.service;

import com.example.customermanagement2.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer>findAll();
    void save(Customer customer);
    Customer findBiId(int id);
    void update(int id, Customer customer);
    void remote(int id);
}
