package com.example.sping_boot.service;


import com.example.sping_boot.model.Student;
import com.example.sping_boot.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> showList() {
        return iStudentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        iStudentRepository.save(student);
    }
}
