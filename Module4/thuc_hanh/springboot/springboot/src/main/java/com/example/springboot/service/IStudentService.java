package com.example.springboot.service;

import com.example.springboot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> showlist(Pageable pageable);
    void add(Student student);
    void remove(Long id);
    Student findById(Long id);
}
