package com.example.demo2.Service;

import com.example.demo2.Model.Student;
import com.example.demo2.Repository.IStudentRepository;
import com.example.demo2.Repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findByAll() {
        return studentRepository.findByAll();
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public void addNewStudent(Student student) {
        studentRepository.addNewStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public Student selectStudent(int id) {
        return studentRepository.selectStudent(id);
    }
}
