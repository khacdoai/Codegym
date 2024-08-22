package com.example.demo_jstl_c0723.repository;

import com.example.demo_jstl_c0723.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<Student> searchByName(String searchName);
    boolean add(Student student);
    boolean delete(int id);
}