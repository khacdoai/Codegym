package com.example.case_study.service.impl;

import com.example.case_study.model.ViTri;
import com.example.case_study.repository.IViTriRepository;
import com.example.case_study.repository.impl.ViTriRepository;
import com.example.case_study.service.IViTriService;

import java.util.List;

public class ViTriService implements IViTriService {
    public static IViTriRepository viTriRepository = new ViTriRepository();
    @Override
    public List<ViTri> showList() {
        return viTriRepository.showList();
    }
}
