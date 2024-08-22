package com.example.test.service;

import com.example.test.model.ClassStudent;
import com.example.test.repository.IClassStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class classStudentService implements IClassStudentService{

    @Autowired
    private IClassStudentRepository iClassStudentRepositoryi;
    @Override
    public List<ClassStudent> showList() {
        return iClassStudentRepositoryi.findAll();
    }
}
