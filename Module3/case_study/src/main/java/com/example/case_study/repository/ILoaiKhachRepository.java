package com.example.case_study.repository;

import com.example.case_study.model.LoaiKhach;

import java.util.List;

public interface ILoaiKhachRepository {
    List<LoaiKhach> findAll();
}
