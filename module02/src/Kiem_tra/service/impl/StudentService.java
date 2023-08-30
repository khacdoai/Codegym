package Kiem_tra.service.impl;

import Kiem_tra.model.Student;
import Kiem_tra.repository.IStudentRepository;
import Kiem_tra.repository.ipml.StudentRepository;
import Kiem_tra.service.IStudentService;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private Scanner scanner= new Scanner(System.in);
    private static IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void addStudent() {
        Student student = inputInfo();
        iStudentRepository.add(student);
        System.out.println("Thêm mới thành công");
        System.out.println("---------------------------------");
    }
    @Override
    public void removeStudent() {
        System.out.print("Nhập code để xóa: ");
        int code = Integer.parseInt(scanner.nextLine());
        iStudentRepository.remove(code);

    }

    public Student inputInfo() {
        Student student = new Student();
        System.out.print("Nhập mã: ");
        student.setCode(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên: ");
        student.setName(scanner.nextLine());
        System.out.print("Nhập ngày sinh: ");
        student.setDateOfBirth(scanner.nextLine());
        System.out.print("Nhập giới tính: ");
        student.setGioitinh(scanner.nextLine());
        System.out.print("Nhập số điện thoại: ");



        return student;
    }
    public void displayAllStudent() {
        List<ss16.mvc.model.Student> studentList = iStudentRepository.getAll();
        for(ss16.mvc.model.Student student: studentList) {
            System.out.println(student);
        }
    }
}
