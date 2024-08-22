package com.example.demo4.service;

import com.example.demo4.model.Employee;

import java.util.List;

public interface IEmloyeeeService {
    List<Employee> showList();
    void addNewEmployee(Employee employee);
    boolean deteleEmployee(int maNhanvien);
    boolean updateEmployee(Employee employee);
    Employee selectEmployee(int maNhanVien);
}
