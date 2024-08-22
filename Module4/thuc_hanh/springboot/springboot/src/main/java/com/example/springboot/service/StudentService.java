package com.example.springboot.service;

import com.example.springboot.model.Student;
import com.example.springboot.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public Page<Student> showlist(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public void add(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return iStudentRepository.findById(id).orElse(null);
    }
}
