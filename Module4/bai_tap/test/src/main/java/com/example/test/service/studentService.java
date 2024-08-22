package com.example.test.service;

import com.example.test.model.Student;
import com.example.test.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class studentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Page<Student> showList(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        iStudentRepository.deleteById(id);

    }

    @Override
    public void add(Student student) {
        iStudentRepository.save(student);

    }

    @Override
    public void update(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Student selecterById(Long id) {
        return iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Student> searchByName(Pageable pageable, String name) {
        return iStudentRepository.searchStudent(pageable,name);
    }
}
