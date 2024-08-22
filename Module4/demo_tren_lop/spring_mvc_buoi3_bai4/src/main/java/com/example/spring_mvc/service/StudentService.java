package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Student;
import com.example.spring_mvc.repository.IStudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> showList() {
        return iStudentRepository.showList();
    }

    @Override
    public void add(Student student) {
        iStudentRepository.add(student);
    }
}
