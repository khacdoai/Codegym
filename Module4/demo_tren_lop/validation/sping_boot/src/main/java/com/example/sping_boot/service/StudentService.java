package com.example.sping_boot.service;


import com.example.sping_boot.model.Student;
import com.example.sping_boot.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
    public void delete(long id) {
        iStudentRepository.deleteById(id);
    }

}
