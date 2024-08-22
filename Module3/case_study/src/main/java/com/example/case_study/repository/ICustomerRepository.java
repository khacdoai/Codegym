package com.example.case_study.repository;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.Customer;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface ICustomerRepository {
    List<CustomerDto> showList();
    void addNewCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
    CustomerDto selectCustomer(int id);
    List<CustomerDto> searchByName(String ho_ten);
    List<CustomerDto> arrangeByName();



}
