package case_study.repository.implEmployee;

import case_study.model.Customer;
import case_study.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getListEmploye();
    void addEmployee(Employee employee);
    void deleteEmployeeById(int id);
    void updateEmployeeById(int Id,Employee newEmployee);
    List<Employee> searchEmployeeByName(String name);
    boolean searchEmployeeById(int id);
    Employee findByID(int id);
}
