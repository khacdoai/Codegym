package com.example.springboot.service;

import com.example.springboot.model.CodeGymClass;

import java.util.List;

public interface ICodeGymClassService {
    List<CodeGymClass> findAll();
}
