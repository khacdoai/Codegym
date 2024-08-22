package com.example.demo_jstl_c0723.service;

import com.example.demo_jstl_c0723.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> searchByName(String searchName);
    boolean add(Student student);
    boolean delete(int id);
}
