package com.example.case_study.service.impl;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.Customer;
import com.example.case_study.repository.ICustomerRepository;
import com.example.case_study.repository.impl.customerRepository;
import com.example.case_study.service.ICustomerService;

import java.util.List;

public class customerService implements ICustomerService {
    ICustomerRepository customerRepository = new customerRepository();
    @Override
    public List<CustomerDto> showList() {
        return customerRepository.showList();
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customerRepository.addNewCustomer(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public CustomerDto selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public List<CustomerDto> searchByName(String ho_ten) {
        return customerRepository.searchByName(ho_ten);
    }

    @Override
    public List<CustomerDto> arrangeByName() {
        return customerRepository.arrangeByName();
    }
}
