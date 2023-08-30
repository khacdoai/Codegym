package Ass8_MVC.bai_tap.Customer.repository;

import Ass8_MVC.bai_tap.Customer.model.Customer;

public interface ICustomerRepository {
    Customer[] getListCustomer();
    void addCustomer(Customer customer);
    void deleteCustomerById(int id);
    void updateCustomerById(int id, Customer customer);
    void searchCustomerByName(String name);
    boolean searchCustomerById(int id);
}
