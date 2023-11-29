package com.example.customermanagement2.service;

import com.example.customermanagement2.model.Customer;
import com.example.customermanagement2.repository.CustomerRepository;
import com.example.customermanagement2.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public Customer findBiId(int id) {
        return customerRepository.findBiId(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id,customer);

    }

    @Override
    public void remote(int id) {
        customerRepository.remote(id);

    }
}
