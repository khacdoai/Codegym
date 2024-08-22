package com.example.test.service;

import com.example.test.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    Page<Student> showList(Pageable pageable);
    void delete(Long id);
    void add(Student student);
    void update(Student student);
    Student selecterById(Long id);

    Page<Student> searchByName(Pageable pageable, String name);
}
