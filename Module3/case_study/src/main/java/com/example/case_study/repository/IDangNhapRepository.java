package com.example.case_study.repository;

import com.example.case_study.model.Accout;

public interface IDangNhapRepository {
    boolean dangKi(Accout accout);
    boolean kiemTraDangNhap(String userName, String pass);
}
