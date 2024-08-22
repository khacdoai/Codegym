package com.example.case_study.service.impl;

import com.example.case_study.model.LoaiKhach;
import com.example.case_study.repository.ILoaiKhachRepository;
import com.example.case_study.repository.impl.LoaiKhachRepository;
import com.example.case_study.service.ILoaiKhachService;

import java.util.List;

public class LoaiKhachService implements ILoaiKhachService {
    ILoaiKhachRepository loaiKhachRepository = new LoaiKhachRepository();
    @Override
    public List<LoaiKhach> findAll() {
        return loaiKhachRepository.findAll();
    }
}
