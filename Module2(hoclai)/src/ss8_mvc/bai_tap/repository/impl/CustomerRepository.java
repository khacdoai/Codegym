package ss8_mvc.bai_tap.repository.impl;

import ss8_mvc.bai_tap.model.Customer;
import ss8_mvc.bai_tap.repository.ICustomerRepository;

import java.util.ArrayList;

public class CustomerRepository implements ICustomerRepository {
    private static ArrayList<Customer> customerArrayList = new ArrayList<Customer>(10);
    private static Customer[] customerSearchs = new Customer[5];
    static {
        customerArrayList.add(new Customer(1,"Iphone",90000,"no"));
        customerArrayList.add(new Customer(2,"SamSung",9023500,"no"));
        customerArrayList.add(new Customer(3,"Vivo",9034320,"no"));
        customerArrayList.add(new Customer(4,"Acer",904540,"no"));
    }
    @Override
    public ArrayList<Customer> getListCustomer() {
        return customerArrayList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerArrayList.add(customer);
        }


    @Override
    public void deleteCustomerById(int id) {
        for (int i = 0; i< customerArrayList.size(); i++){
            if(customerArrayList.get(i).getId() == id){
                customerArrayList.remove(i);
                break;
            }
        }
    }

    @Override
    public void updateCustomerById(int id, Customer customer) {
        for (int i= 0; i < customerArrayList.size(); i++){
            if(customerArrayList.get(i).getId() == id){
                customerArrayList.remove(i);
                customerArrayList.add(customer);
                break;
            }
        }
    }
    public boolean searchCustomerById(int id){
        boolean a = false;
        for (int i = 0; i < customerArrayList.size(); i++) {
            if (customerArrayList.get(i) != null) {
                if (customerArrayList.get(i).getId() == id) {
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
        for (int i =0; i <  customerArrayList.size(); i++){
            if (customerArrayList.get(i) != null && customerArrayList.get(i).getName() != null){
            if (customerArrayList.get(i).getName().equals(name)) {
                System.out.println("tìm thấy");
                num = 1;
                customerSearchs[i] = customerArrayList.get(i);
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
