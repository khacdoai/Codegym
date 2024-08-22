package com.example.demo.repository;

import com.example.demo.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Student> showList();
    void addNewStudent(Student student);

}
