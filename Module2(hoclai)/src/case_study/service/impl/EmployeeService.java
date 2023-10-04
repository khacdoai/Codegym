package case_study.service.impl;

import case_study.model.Employee;
import case_study.repository.implEmployee.IEmployeeRepository;
import case_study.repository.implEmployee.EmployeeRepository;
import case_study.service.IEmloyeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmloyeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void EmloyeeDisplay() {
////        List<Employee> employeeList = employeeRepository.getListEmploye();
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i) != null){
//                System.out.println((i+1) + "." + employeeList.get(i));
//            }
//        }

    }

    @Override
    public void EmloyeeAdd() {

    }

    @Override
    public void EmloyeeUpdate() {

    }

    @Override
    public void EmloyeeDelete() {

    }

    @Override
    public void EmloyeeSearch() {

    }
}
