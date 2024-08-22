package com.example.demo2.Repository;

import com.example.demo2.Model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findByAll();
    boolean deleteStudent(int id);
    void addNewStudent(Student student);
    boolean updateStudent(Student student);
    Student selectStudent (int id);

}
