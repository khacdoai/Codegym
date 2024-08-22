package com.example.module3_accountname_wbe.service;

import com.example.module3_accountname_wbe.model.Customer;

import java.util.List;

public interface ICustomerService  {
    List<Customer> findByAll();
    boolean deleteCustomer(int id);

}
