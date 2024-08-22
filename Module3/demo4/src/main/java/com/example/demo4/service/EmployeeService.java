package com.example.demo4.service;

import com.example.demo4.model.Employee;
import com.example.demo4.repository.EmployeeRepository;
import com.example.demo4.repository.IEmloyeeRepository;

import java.util.List;

public class EmployeeService implements IEmloyeeeService{
    private static IEmloyeeRepository emloyeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> showList() {
        return emloyeeRepository.showList();
    }

    @Override
    public void addNewEmployee(Employee employee) {

    }

    @Override
    public boolean deteleEmployee(int maNhanvien) {
        return emloyeeRepository.deteleEmployee(maNhanvien);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public Employee selectEmployee(int maNhanVien) {
        return null;
    }
}
