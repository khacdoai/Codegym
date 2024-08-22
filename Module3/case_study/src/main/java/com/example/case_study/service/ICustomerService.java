package com.example.case_study.service;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.Customer;

import java.util.List;

public interface ICustomerService{
        List<CustomerDto> showList();
        void addNewCustomer(Customer customer);
        boolean updateCustomer(Customer customer);
        boolean deleteCustomer(int id);
        CustomerDto selectCustomer(int id);
        List<CustomerDto> searchByName(String ho_ten);
        List<CustomerDto> arrangeByName();


}
