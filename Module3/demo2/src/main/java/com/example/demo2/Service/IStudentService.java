package com.example.demo2.Service;

import com.example.demo2.Model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findByAll();
    boolean deleteStudent(int id);
    void addNewStudent(Student student);
    boolean updateStudent(Student student);
    Student selectStudent (int id);

}
