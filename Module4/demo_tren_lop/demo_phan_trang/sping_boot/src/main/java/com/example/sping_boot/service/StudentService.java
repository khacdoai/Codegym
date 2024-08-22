package com.example.sping_boot.service;


import com.example.sping_boot.model.Student;
import com.example.sping_boot.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Page<Student> showList(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public void add(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Page<Student> SearchByName(Pageable pageable, String name) {
        return iStudentRepository.searchAllBy(pageable, name);
    }
}
