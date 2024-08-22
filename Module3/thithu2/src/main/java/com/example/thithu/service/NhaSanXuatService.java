package com.example.thithu.service;

import com.example.thithu.model.NhaSanXuat;
import com.example.thithu.repository.INhaSanXuatRepository;
import com.example.thithu.repository.impl.NhaSanXuatRepository;

import java.util.List;

public class NhaSanXuatService implements INhaSanXuatService{
    private INhaSanXuatRepository nhaSanXuatRepository = new NhaSanXuatRepository();
    @Override
    public List<NhaSanXuat> showList() {
        return nhaSanXuatRepository.showList();
    }
}
