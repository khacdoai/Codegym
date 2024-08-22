package com.example.module3_accountname_wbe.repository;

import com.example.module3_accountname_wbe.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findByAll();
    boolean deleteCustomer(int id);
}
