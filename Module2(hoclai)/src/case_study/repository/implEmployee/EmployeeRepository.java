package case_study.repository.implEmployee;

import case_study.model.Customer;
import case_study.model.Employee;
import case_study.util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String Patth_Employee = "D:\\CODEGYM\\Module2(hoclai)\\src\\case_study\\data\\employee.csv";

    @Override
    public List<Employee> getListEmploye() {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readCSVFile(Patth_Employee);
        String[] array = null;
        for (String string :stringList) {
            array = string.split(",");
            Employee employee = new Employee(Integer.parseInt(array[0]),array[1],array[2],array[3],Integer.parseInt(array[4]),Integer.parseInt(array[5]),array[6],array[7],array[8],Integer.parseInt(array[9]));
            employeeList.add(employee);
        }

        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        List<String> stringList = new ArrayList<>();
        stringList.add(employee.GetToCSV());
        ReadAndWrite.writeToCSV(Patth_Employee,stringList,true);
    }

    @Override
    public void deleteEmployeeById(int id) {
        List<Employee> employeeList = getListEmploye();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getManhanvien() == id){
                employeeList.remove(i);
            }
            break;
        }
        List<String> stringList = new ArrayList<>();
        for (Employee employee: employeeList) {
            stringList.add(employee.GetToCSV());
        }
        ReadAndWrite.writeToCSV(Patth_Employee,stringList,false);

    }

    @Override
    public void updateEmployeeById(int Id, Employee newEmployee) {

    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return null;
    }

    @Override
    public boolean searchEmployeeById(int id) {
        return false;
    }

    @Override
    public Employee findByID(int id) {
        return null;
    }
}
