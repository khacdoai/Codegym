package com.example.springboot.service;

import com.example.springboot.model.CodeGymClass;
import com.example.springboot.repository.ICodeGymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeGymClassService implements ICodeGymClassService {
    @Autowired
    private ICodeGymClassRepository iCodeGymClassRepository;

    @Override
    public List<CodeGymClass> findAll() {
        return iCodeGymClassRepository.findAll();
    }
}
