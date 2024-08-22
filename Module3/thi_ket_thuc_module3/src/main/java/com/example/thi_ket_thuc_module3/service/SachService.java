package com.example.thi_ket_thuc_module3.service;

import com.example.thi_ket_thuc_module3.model.Sach;
import com.example.thi_ket_thuc_module3.repository.ISachRepository;
import com.example.thi_ket_thuc_module3.repository.SachRepository;

import java.util.List;

public class SachService implements ISachService{
    private ISachRepository sachRepository = new SachRepository();
    @Override
    public List<Sach> showList() {
        return sachRepository.showList();
    }
}
