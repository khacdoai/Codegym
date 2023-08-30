package Ass8_MVC.bai_tap.Customer.repository.impl;

import Ass8_MVC.bai_tap.Customer.model.Customer;
import Ass8_MVC.bai_tap.Customer.repository.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository {
    private static Customer[] customers = new Customer[10];
    private static Customer[] customerSearchs = new Customer[5];
    static {
        customers[0] = new Customer(1,"iphone",1200000,"no");
        customers[1] = new Customer(2,"samsung",900000,"no");
        customers[2] = new Customer(3,"nokia",300000,"no");
        customers[3] = new Customer(4,"vivo",400000,"no");
    }
    @Override
    public Customer[] getListCustomer() {
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        for (int i = 0; i< customers.length; i++){
            if(customers[i] == null){
                customers[i] =  customer;
                break;
            }
        }


    }

    @Override
    public void deleteCustomerById(int id) {
        for (int i = 0; i< customers.length; i++){
            if(customers[i].getId() == id){
                customers[i] = null;
                break;
            }
        }
    }

    @Override
    public void updateCustomerById(int id, Customer customer) {
        for (int i= 0; i < customers.length; i++){
            if(customers[i] != null )
            if(customers[i].getId() == id){
                customers[i] = customer;
                break;
            }
        }
    }
    public boolean searchCustomerById(int id){
        boolean a = false;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                if (customers[i].getId() == id) {
                    a = true;
                    break;
                }
            }
        }
        return a;
    }
    @Override
    public void searchCustomerByName(String name) {
        int num = -1;
        for (int i =0; i < customers.length; i++){
            if (customers[i] != null && customers[i].getName() != null){
            if (customers[i].getName().equals(name)) {
                System.out.println("tìm thấy");
                num = 1;
                customerSearchs[i] = customers[i];
                break;
            }
            }else {
                System.out.println(" không tìm thấy");
                break;
            }
            }
        if (num == 1) {
            for (int i = 0; i < customerSearchs.length; i++) {
                if (customerSearchs[i] != null) {
                    System.out.println(customerSearchs[i]);
                }
            }
        }

    }
}
