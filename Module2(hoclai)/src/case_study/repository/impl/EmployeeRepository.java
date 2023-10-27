package case_study.repository.impl;

import case_study.model.Employee;
import case_study.repository.IEmployeeRepository;
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
            Employee employee = new Employee((array[0]),array[1],array[2],array[3],(array[4]),(array[5]),array[6],array[7],array[8],Integer.parseInt(array[9]));
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
    public void deleteEmployeeById(String id) {
        List<Employee> employeeList = getListEmploye();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getManhanvien().equals(id)){
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
    public void updateEmployeeById(String Id, Employee newEmployee) {
        boolean check = false;
        List<Employee> employeeList = getListEmploye();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getManhanvien().equals(Id)){
                employeeList.get(i).setManhanvien(newEmployee.getManhanvien());
                employeeList.get(i).setHoten(newEmployee.getHoten());
                employeeList.get(i).setNgaysinh(newEmployee.getNgaysinh());
                employeeList.get(i).setGioitinh(newEmployee.getGioitinh());
                employeeList.get(i).setCMND(newEmployee.getCMND());
                employeeList.get(i).setSdt(newEmployee.getSdt());
                employeeList.get(i).setEmail(newEmployee.getEmail());
                employeeList.get(i).setTrinhdo(newEmployee.getTrinhdo());
                employeeList.get(i).setVitri(newEmployee.getVitri());
                employeeList.get(i).setLuong(newEmployee.getLuong());
                check= true;
            }
            if (check){
                List<String> stringList = new ArrayList<>();
                for (Employee employee:employeeList) {
                    stringList.add(employee.GetToCSV());
                }
                ReadAndWrite.writeToCSV(Patth_Employee,stringList,false);
            }else {
                System.out.println("Khong tim thay ID");
            }
        }

    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> employeeList = getListEmploye();
        List<Employee> searchEmployees = new ArrayList<>();
        for (int i = 0; i<employeeList.size();i++){
            if(employeeList.get(i).getHoten().contains(name)){
                searchEmployees.add(employeeList.get(i));
            }
        }
        return searchEmployees;
    }

    @Override
    public boolean searchEmployeeById(String id) {
        return false;
    }

    @Override
    public Employee findByID(String id) {
        List<Employee> employeeList = getListEmploye();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getManhanvien().equals(id) ){
                return employeeList.get(i);
            }
        }
        return null;
    }
}
