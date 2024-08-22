package com.example.thi.service;

import com.example.thi.modell.DoanhNghiep;
import com.example.thi.repository.IDoanhNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class doanhNghiepService implements IDoanhNghiepService {
    @Autowired
    private IDoanhNghiepRepository iDoanhNghiepRepository;

    @Override
    public List<DoanhNghiep> showList() {
        return iDoanhNghiepRepository.findAll();
    }
}
