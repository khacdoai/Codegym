package com.example.demo_jstl_c0723.service.impl;

import com.example.demo_jstl_c0723.model.Student;
import com.example.demo_jstl_c0723.repository.IStudentRepository;
import com.example.demo_jstl_c0723.repository.impl.StudentRepository;
import com.example.demo_jstl_c0723.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        // validate
        return studentRepository.add(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }
}
