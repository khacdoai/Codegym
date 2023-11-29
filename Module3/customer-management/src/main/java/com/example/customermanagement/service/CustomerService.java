package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.repository.CustomerReppsitory;
import com.example.customermanagement.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerReppsitory();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();

    }

    @Override
    public void save(Customer customer) {
        if (customer != null) {
            customerRepository.save(customer);
        }
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);

    }

    @Override
    public void remote(int id) {

    }
}
