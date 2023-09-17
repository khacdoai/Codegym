package ss8_mvc.bai_tap.repository;


import ss8_mvc.bai_tap.model.Customer;

import java.util.ArrayList;

public interface ICustomerRepository {
    ArrayList<Customer> getListCustomer();
    void addCustomer(Customer customer);
    void deleteCustomerById(int id);
    void updateCustomerById(int id, Customer customer);
    void searchCustomerByName(String name);
    boolean searchCustomerById(int id);
}
