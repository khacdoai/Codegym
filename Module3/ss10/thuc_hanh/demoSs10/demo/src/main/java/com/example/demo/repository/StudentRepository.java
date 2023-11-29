package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class    StudentRepository implements IStudentRepository{
    private static List<Student> list = new ArrayList<>();
    static {
        list.add(new Student(1,"Vũ",true, 6));
        list.add(new Student(2,"Thông",true, 7));
        list.add(new Student(3,"Thư",false, 5));
    }
    @Override
    public List<Student> showList() {
        return list;
    }
}
