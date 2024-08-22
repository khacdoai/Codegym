package com.example.demo_bai_1.service;

import com.example.demo_bai_1.model.Student;
import com.example.demo_bai_1.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> showList() {
        return studentRepository.showList();
    }

    @Override
    public Student selectStudent(int id) {
        return studentRepository.selectStudent(id);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        studentRepository.updateStudent(id,student);
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    @Override
    public List<Student> searchStudent(String name) {
        return studentRepository.searchStudent(name);
    }

}
