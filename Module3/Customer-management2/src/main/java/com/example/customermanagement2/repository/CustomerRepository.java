package com.example.customermanagement2.repository;

import com.example.customermanagement2.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository  implements ICustomerRepository{
    private static Map<Integer,Customer> customers  = new HashMap<>();
    static {
        customers.put(1,new Customer(1,"Võ Khắc Đoài","doai28@gmail.com","Quảng Bình"));
        customers.put(2,new Customer(2,"Nguyễn Văn Tiến Đạt","dat29@gmail.com","Quảng Bình"));
        customers.put(3,new Customer(3,"Trần Văn Vững","vungCr07@gmail.com","Quảng Bình"));
        customers.put(4,new Customer(4,"Trần Văn Hiếu","hieuTV@gmail.com","Nghệ An"));
        customers.put(5,new Customer(5,"Trần Anh Hoàng","hang2k2@gmail.com","Nghệ An"));
        customers.put(6,new Customer(6,"Võ Trọng Đạt","datVT@gmail.com","Quảng Ngãi"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);

    }

    @Override
    public Customer findBiId(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remote(int id) {
        customers.remove(id);
    }
}
