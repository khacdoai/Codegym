package com.example.demo_bai_1.repository;

import com.example.demo_bai_1.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> showList();
    Student selectStudent(int id);
    void deleteStudent(int id);
    void updateStudent(int id, Student student);
    void createStudent(Student student);
    List<Student> searchStudent(String name);
}
