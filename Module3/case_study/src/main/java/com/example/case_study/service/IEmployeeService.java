package com.example.case_study.service;

import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> showList();
    void createEmployee(Employee employee);
    boolean deleteEmployee(int id);
    boolean updateEmploy(Employee employee);
    Employee selectEmployee(int id);
    List<Employee> serchEmployee(String name);
}
