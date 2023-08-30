package ss8_mvc.service.impl;

import ss8_mvc.model.Student;
import ss8_mvc.repository.IStudentRepository;
import ss8_mvc.repository.impl.StudentRepository;
import ss8_mvc.service.IStudentService;

import java.util.Scanner;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public void display() {
        Student[] students = studentRepository.getListStudent();
        for (int i=0; i<students.length;i++){
            if (students[i]!=null){
                System.out.println((1+i) + "." + students[i]);
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
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id sinh viên cần xoá");
        int deleteId = Integer.parseInt(scanner.nextLine());
        studentRepository.deleteStudentById(deleteId);
    }
}
