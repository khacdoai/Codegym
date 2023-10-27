package case_study.repository;

import case_study.model.Customer;
import case_study.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> getListCustomer();
    void addCustomer(Customer customer );
    void deleteCustomerById(int id);
    void updateCustomerById(int id, Customer newCustomer);
    List<Customer> searchCustomerByName(String name);
    boolean searchCustomerById(int id);
    Customer findByID(int id);
}
