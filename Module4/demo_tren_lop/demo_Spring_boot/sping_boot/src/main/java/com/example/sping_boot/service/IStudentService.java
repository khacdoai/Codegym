package com.example.sping_boot.service;


import com.example.sping_boot.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> showList();
    void add(Student student);
}
