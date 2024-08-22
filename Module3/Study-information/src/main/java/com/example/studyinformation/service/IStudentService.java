package com.example.studyinformation.service;

import com.example.studyinformation.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> showlist();
    boolean deleteStudent(int id);
    boolean updateStudent(Student student);
    void addnewStudent(Student student);
    Student selectStudent(int id);
}
