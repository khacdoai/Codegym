package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> showList();
    void add(Student student);
}
