package com.example.thi_ket_thuc_module.service.impl;

import com.example.thi_ket_thuc_module.dto.BenhAnDto;
import com.example.thi_ket_thuc_module.model.BenhAn;
import com.example.thi_ket_thuc_module.repository.IBenhAnRepository;
import com.example.thi_ket_thuc_module.repository.impl.BenhAnRepository;
import com.example.thi_ket_thuc_module.service.IBenhAnService;

import java.util.List;

public class BenhAnService implements IBenhAnService {
    private IBenhAnRepository benhAnRepository = new BenhAnRepository();
    @Override
    public List<BenhAnDto> showList() {
        return benhAnRepository.showList();
    }

    @Override
    public boolean chinhSuaBenhAn(BenhAnDto benhAnDto) {
        return benhAnRepository.chinhSuaBenhAn(benhAnDto);
    }

    @Override
    public boolean xoaBenhAn(int id) {
        return benhAnRepository.xoaBenhAn(id);
    }

    @Override
    public BenhAnDto layBenhAn(int id) {
        return benhAnRepository.layBenhAn(id);
    }
}
