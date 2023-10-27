package case_study.service.impl;

import case_study.model.Employee;
import case_study.repository.IEmployeeRepository;
import case_study.repository.impl.EmployeeRepository;
import case_study.service.IEmloyeeService;
import case_study.util.CheckData;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmloyeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void EmloyeeDisplay() {
        List<Employee> employeeList = employeeRepository.getListEmploye();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i) != null){
                System.out.println((i+1) + "." + employeeList.get(i));
            }
        }

    }

    @Override
    public void EmloyeeAdd() {
        while (true){
            try{
                System.out.printf("Nhap ma nhan vien(NV-xxxx): ");
                String id = scanner.nextLine();
                if(!CheckData.isValiCode(id) ){
                    throw new Exeption("Ma nhan vien khong hop le !");
                }
                System.out.printf("Nhap ten nhan vien: ");
                String ten = scanner.nextLine();
                if(!CheckData.isValidName(ten) ){
                    throw new Exeption("Ten nhan vien khong hop le !");
                }
                System.out.printf("Nhap ngay sinh nhan vien(yyyy-MM-dd): ");
                String ngaysinh = scanner.nextLine();
                if(!CheckData.isValidBirthDate(ngaysinh) ){
                    throw new Exeption("Ngay sinh nhan vien khong hop le !");
                }
                System.out.printf("Nhap gioi tinh nhan vien: ");
                String gioitinh = scanner.nextLine();
                System.out.printf("Nhap cnnd nhan vien (9 ki tu): ");
                String cmnd = scanner.nextLine();
                if(!CheckData.isValidIdCard(cmnd) ){
                    throw new Exeption("CMND nhan vien khong hop le !");
                }
                System.out.printf("Nhap SDT nhan vien(bat dau bang 0 va co 10 so): ");
                String sdt = scanner.nextLine();
                if(!CheckData.isValidPhoneNumber(sdt) ){
                    throw new Exeption("SDT nhan vien khong hop le !");
                }
                System.out.printf("Nhap email nhan vien: ");
                String email = scanner.nextLine();
                System.out.printf("Nhap trinh do nhan vien: ");
                String trinhdo = scanner.nextLine();
                System.out.printf("Nhap vi tri nhan vien: ");
                String vitri = scanner.nextLine();
                System.out.printf("Nhap luong nhan vien: ");
                int luong = Integer.parseInt(scanner.nextLine());
                if(!CheckData.isValidSalary(luong) ){
                    throw new Exeption("Luong phai lon hon 0 !");
                }
                Employee newEmployee = new Employee(id,ten,ngaysinh,gioitinh,cmnd,sdt,email,trinhdo,vitri,luong);
                employeeRepository.addEmployee(newEmployee);
                System.out.println("Them moi thanh cong");
                break;

            } catch (Exeption exeption) {
                System.err.print("Lỗi : " + exeption.getMessage());
            }
        }


    }

    @Override
    public void EmloyeeUpdate() {
        System.out.printf("Nhap ma nhan vien: ");
        String id = scanner.nextLine();
        Employee setEmployee = employeeRepository.findByID(id);
        if(setEmployee != null) {
            System.out.printf("Nhap ten nhan vien: ");
            String ten = scanner.nextLine();
            System.out.printf("Nhap ngay sinh nhan vien can sua: ");
            String ngaysinh = scanner.nextLine();
            System.out.printf("Nhap gioi tinh nhan vien can sua: ");
            String gioitinh = scanner.nextLine();
            System.out.printf("Nhap cnnd nhan vien can sua: ");
            String cmnd = scanner.nextLine();
            System.out.printf("Nhap SDT nhan vien can sua: ");
            String sdt = scanner.nextLine();
            System.out.printf("Nhap email nhan vien can sua: ");
            String email = scanner.nextLine();
            System.out.printf("Nhap trinh do nhan vien can sua: ");
            String trinhdo = scanner.nextLine();
            System.out.printf("Nhap vi tri nhan vien can sua: ");
            String vitri = scanner.nextLine();
            System.out.printf("Nhap luong nhan vien can sua: ");
            int luong = Integer.parseInt(scanner.nextLine());
            setEmployee.setManhanvien(id);
            setEmployee.setHoten(ten);
            setEmployee.setNgaysinh(ngaysinh);
            setEmployee.setGioitinh(gioitinh);
            setEmployee.setCMND(cmnd);
            setEmployee.setSdt(sdt);
            setEmployee.setEmail(email);
            setEmployee.setTrinhdo(trinhdo);
            setEmployee.setVitri(vitri);
            setEmployee.setLuong(luong);
            employeeRepository.updateEmployeeById(id,setEmployee);
        }else {
            System.out.println("Khong tim thay id");
        }

    }

    @Override
    public void EmloyeeDelete() {
        System.out.printf("Nhap id nhan vien can xoa: ");
        String id = scanner.nextLine();
        Employee deleteEmployee = employeeRepository.findByID(id);
        if(deleteEmployee != null){
            employeeRepository.deleteEmployeeById(id);
        }else {
            System.out.println("Khong tim thay id");
        }

    }

    @Override
    public void EmloyeeSearch() {
        System.out.printf("Nhap ten nhan vien can tim: ");
        String searchName = scanner.nextLine();
        List<Employee> employeeList = employeeRepository.searchEmployeeByName(searchName);
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i) != null){
                System.out.println(employeeList.get(i));
            }
        }
    }
}
class Exeption extends  Exception{
    public Exeption(String message){
        super(message);
    }
}
