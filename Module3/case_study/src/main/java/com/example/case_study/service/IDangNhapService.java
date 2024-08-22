package com.example.case_study.service;

import com.example.case_study.model.Accout;

public interface IDangNhapService {
    boolean dangKi(Accout accout);
    boolean kiemTraDangNhap(String userName, String pass);
}
