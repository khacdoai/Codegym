package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static final List<Student> list;
    static {
        list = new ArrayList<>();
        list.add(new Student(1,"a","a"));
        list.add(new Student(2,"b","b"));
        list.add(new Student(3,"c","c"));
    }
    @Override
    public List<Student> showList() {
        return list;
    }

    @Override
    public void add(Student student) {
        list.add(student);
    }
}
