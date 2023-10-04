package ss8_mvc.service.impl;

import ss8_mvc.model.Student;
import ss8_mvc.repository.IStudentRepository;
import ss8_mvc.repository.impl.StudentRepository;
import ss8_mvc.service.IStudentService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public void display() {
        List<Student> students = studentRepository.getListStudent();
        for (int i=0; i<students.size();i++){
            if (students.get(i)!=null){
                System.out.println((1+i) + "." + students.get(i));
            }

        }
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập tên lớp");
        String className = scanner.nextLine();
        Student student = new Student(id,name,className);
        studentRepository.addStudent(student);

    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        Student editStudent = studentRepository.findById(id);
        if (editStudent!=null){
            System.out.println("Nhập lại name");
            String newName = scanner.nextLine();
            System.out.println("Nhập lại class name");
            String newClassName = scanner.nextLine();
            editStudent.setName(newName);
            editStudent.setClassName(newClassName);
            studentRepository.edit(id,editStudent);
        }else {
            System.out.println("Id không tìm thấy");
        }


    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id sinh viên cần xoá");
        int deleteId = Integer.parseInt(scanner.nextLine());
        studentRepository.deleteStudentById(deleteId);
    }

    @Override
    public void displayByClassName() {
        List<Student> students = studentRepository.sortByClassName();
        for (int i=0; i<students.size();i++){
            if (students.get(i)!=null){
                System.out.println((1+i) + "." + students.get(i));
            }

        }
    }

    @Override
    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên sinh viên cần tìm");
        String searchName = scanner.nextLine();
        List<Student> students = studentRepository.searchByName(searchName);
        for (int i=0; i<students.size();i++){
            if (students.get(i)!=null){
                System.out.println((1+i) + "." + students.get(i));
            }
        }
    }
}
