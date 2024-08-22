package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> showList();
    void add(Student student);
}
