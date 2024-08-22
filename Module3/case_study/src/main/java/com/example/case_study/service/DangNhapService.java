package com.example.case_study.service;

import com.example.case_study.model.Accout;
import com.example.case_study.repository.DangNhapRepository;
import com.example.case_study.repository.IDangNhapRepository;

public class DangNhapService implements IDangNhapService{
    private static IDangNhapRepository dangNhapRepository = new DangNhapRepository();
    @Override
    public boolean dangKi(Accout accout) {
        return dangNhapRepository.dangKi(accout);
    }

    @Override
    public boolean kiemTraDangNhap(String userName, String pass)
    {
        return dangNhapRepository.kiemTraDangNhap(userName,pass);
    }
}
