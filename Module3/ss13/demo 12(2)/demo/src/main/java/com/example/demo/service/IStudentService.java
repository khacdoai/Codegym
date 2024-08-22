package com.example.demo.service;

import com.example.demo.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    List<Student> showList();
    void addNewStudent(Student student);
    void deleteStudent(int id);
}
