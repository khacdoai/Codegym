package case_study.repository;

import case_study.model.Customer;
import case_study.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getListEmploye();
    void addEmployee(Employee employee);
    void deleteEmployeeById(String id);
    void updateEmployeeById(String Id,Employee newEmployee);
    List<Employee> searchEmployeeByName(String name);
    boolean searchEmployeeById(String id);
    Employee findByID(String id);
}
