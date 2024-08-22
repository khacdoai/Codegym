package com.example.demo_jstl_c0723.service.impl;

import com.example.demo_jstl_c0723.model.Clazz;
import com.example.demo_jstl_c0723.repository.IClassRepository;
import com.example.demo_jstl_c0723.repository.impl.ClassRepository;
import com.example.demo_jstl_c0723.service.IClassService;

import java.util.List;

public class ClassService implements IClassService {
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<Clazz> findAll() {
        return classRepository.findAll();
    }
}
