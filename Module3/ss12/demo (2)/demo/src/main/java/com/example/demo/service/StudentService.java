package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<Student> showList(){
        return iStudentRepository.showList();
    }

    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.addNewStudent(student);
    }


}
