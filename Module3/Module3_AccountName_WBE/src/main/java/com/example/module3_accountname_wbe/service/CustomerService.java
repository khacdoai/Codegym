package com.example.module3_accountname_wbe.service;

import com.example.module3_accountname_wbe.model.Customer;
import com.example.module3_accountname_wbe.repository.CustomerRepository;
import com.example.module3_accountname_wbe.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    ICustomerRepository customerRepository =  new CustomerRepository();
    @Override
    public List<Customer> findByAll() {
        return customerRepository.findByAll();
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }
}
