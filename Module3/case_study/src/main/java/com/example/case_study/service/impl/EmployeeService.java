package com.example.case_study.service.impl;

import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.Employee;
import com.example.case_study.repository.IEmployeeRepository;
import com.example.case_study.repository.impl.EmployeeRepository;
import com.example.case_study.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private static IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<EmployeeDto> showList() {
        return employeeRepository.showList();
    }

    @Override
    public void createEmployee(Employee employee) {

    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmploy(Employee employee) {
        return false;
    }

    @Override
    public Employee selectEmployee(int id) {
        return null;
    }

    @Override
    public List<Employee> serchEmployee(String name) {
        return null;
    }
}
