package com.example.case_study.repository;

import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeDto> showList();
    void createEmployee(Employee employee);
    boolean deleteEmployee(int id);
    boolean updateEmploy(Employee employee);
    Employee selectEmployee(int id);
    List<Employee> serchEmployee(String name);
}
