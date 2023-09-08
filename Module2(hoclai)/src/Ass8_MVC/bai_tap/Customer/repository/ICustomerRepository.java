package Ass8_MVC.bai_tap.Customer.repository;

import Ass8_MVC.bai_tap.Customer.model.Customer;

import java.util.ArrayList;

public interface ICustomerRepository {
    ArrayList<Customer> getListCustomer();
    void addCustomer(Customer customer);
    void deleteCustomerById(int id);
    void updateCustomerById(int id, Customer customer);
    void searchCustomerByName(String name);
    boolean searchCustomerById(int id);
}
