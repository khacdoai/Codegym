package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerReppsitory implements ICustomerRepository {
    private static Map<Integer,Customer>customerList;
    static {
        customerList.put(1,new Customer(1,"Võ Khắc Đoài","doai28@gmail.com","Quảng Bình"));
        customerList.put(2,new Customer(2,"Nguyễn Văn Tiến Đạt","dat29@gmail.com","Quảng Bình"));
        customerList.put(3,new Customer(3,"Trần Văn Vững","vungCr07@gmail.com","Quảng Bình"));
        customerList.put(4,new Customer(4,"Trần Văn Hiếu","hieuTV@gmail.com","Nghệ An"));
        customerList.put(5,new Customer(5,"Trần Anh Hoàng","hang2k2@gmail.com","Nghệ An"));
        customerList.put(6,new Customer(6,"Võ Trọng Đạt","datVT@gmail.com","Quảng Ngãi"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void save(Customer customer) {
            customerList.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {

        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.put(id,customer);

    }

    @Override
    public void remote(int id) {
        customerList.remove(id);

    }
}
