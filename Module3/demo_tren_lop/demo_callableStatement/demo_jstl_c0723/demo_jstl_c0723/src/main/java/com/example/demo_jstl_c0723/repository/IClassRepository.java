package com.example.demo_jstl_c0723.repository;

import com.example.demo_jstl_c0723.model.Clazz;
import com.example.demo_jstl_c0723.model.Student;

import java.util.List;

public interface IClassRepository {
    List<Clazz> findAll();
}
