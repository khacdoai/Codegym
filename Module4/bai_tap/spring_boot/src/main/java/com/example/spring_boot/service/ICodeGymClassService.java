package com.example.spring_boot.service;


import com.example.spring_boot.model.CodeGymClass;

import java.util.List;

public interface ICodeGymClassService {
    List<CodeGymClass> findAll();
}
