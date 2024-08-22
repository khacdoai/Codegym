package com.example.studyinformation.service.impl;

import com.example.studyinformation.model.Student;
import com.example.studyinformation.repository.IStudentRepository;
import com.example.studyinformation.repository.impl.StudentRepository;
import com.example.studyinformation.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> showlist() {
        return studentRepository.showlist();
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public void addnewStudent(Student student) {
        studentRepository.addnewStudent(student);


    }

    @Override
    public Student selectStudent(int id) {
        return studentRepository.selectStudent(id);
    }
}
